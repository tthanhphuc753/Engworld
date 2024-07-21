import { FaMagnifyingGlass } from "react-icons/fa6";
import { useState, useEffect } from "react";
import { getAllQuestion, deleteQuestion, uploadQuestionsFile } from "../../service";

export default function Questions() {
    const [questions, setQuestions] = useState([]);
    const [filteredQuestions, setFilteredQuestion] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [showForm, setShowForm] = useState(false); // State để điều khiển hiển thị form
    const [selectedFile, setSelectedFile] = useState(null); // State để lưu file Excel được chọn

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getAllQuestion();
                setQuestions(response.content);
                setFilteredQuestion(response.content);

            } catch (error) {
                console.error("Error fetching data:", error);
            }
        };

        fetchData();

    }, []);

    const handleSearchChange = (e) => {
        setSearchTerm(e.target.value);
    };

    const handleFind = () => {
        const filtered = questions.filter(item =>
            item.question.toLowerCase().includes(searchTerm.toLowerCase()) 
        );
        setFilteredQuestion(filtered);
    };

    const handleDelete = async (id) => {
        try {
            const response = await deleteQuestion(id);
            if (response.status === 200) {
                console.log('Delete successful');
                const updatedVocabulary = questions.filter(item => item.vocabId !== id);
                setQuestions(updatedVocabulary);
                setFilteredQuestion(updatedVocabulary);
            } else {
                console.log('Delete failed:', response.statusText);
            }
        } catch (error) {
            console.error('Error deleting vocabulary:', error);
        }
    };

    const handleAdd = () => {
        setShowForm(true); // Hiển thị form khi nhấn nút Add
    };

    const handleCloseForm = () => {
        setShowForm(false); // Đóng form
    };

    const handleSubmitForm = (formData) => {
        console.log('Form data:', formData);
        // Xử lý logic thêm từ vựng từ formData
        setShowForm(false); // Đóng form sau khi thêm thành công
    };

    const handleFileChange = (e) => {
        setSelectedFile(e.target.files[0]); // Lưu file Excel được chọn vào state
    };

    const handleUploadFile = async () => {
        if (!selectedFile) {
            console.log('Please select a file.');
            return;
        }

        try {
            const formData = new FormData();
            formData.append('file', selectedFile);

            const response = await uploadQuestionsFile(formData);
            console.log('Upload successful:', response.data);

            // Sau khi upload thành công, có thể cập nhật lại danh sách từ vựng
            // Ví dụ:
            // const updatedVocabulary = [...vocabulary, ...response.data];
            // setVocabulary(updatedVocabulary);
            // setFilteredVocabulary(updatedVocabulary);

            setSelectedFile(null); // Đặt lại selectedFile về null sau khi hoàn thành
        } catch (error) {
            console.error('Error uploading file:', error);
        }
    };
    return (
        <div className="flex flex-col justify-center items-center m-5">
            <div className="flex items-center justify-center w-full mb-5">
                <input type="text" className="border border-e-0 rounded-tl-full rounded-bl-full w-1/3 p-2 focus:outline-none pl-4" placeholder="Type here..." onChange={handleSearchChange} />
                <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full " onClick={handleFind}>
                    <FaMagnifyingGlass />
                </button>
                <button className="bg-blue-500 text-white py-2 px-10 border rounded-full" onClick={handleAdd}>
                    Add
                </button>
                {/* Upload file form */}
                <div className=" flex flex-row justify-center items-center">
                    <input type="file" onChange={handleFileChange} />
                    <button className="bg-blue-500 text-white py-2 px-4 rounded-full ml-2" onClick={handleUploadFile}>Upload File</button>
                </div>
            </div>
            <table className="w-full border">
                <thead>
                    <tr>
                        <th className="border">Question</th>
                        <th className="border">Option 1</th>
                        <th className="border">Option 2</th>
                        <th className="border">Option 3</th>
                        <th className="border">Answer</th>
                        <th className="border">Exsercise Type</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                        {filteredQuestions.length > 0 && filteredQuestions.map((question, index) => (
                            <tr key={index}>
                                <td className="border">{question.questionText}</td>
                                <td className="border">{question.op1}</td>
                                <td className="border">{question.op2}</td>
                                <td className="border">{question.op3}</td>
                                <td className="border">{question.correctAnswer}</td>
                                <td className="border">{question.exerciseType}</td>
                                <td className="border">
                                    <button className="bg-red-500 text-white mx-4 py-2 px-4 rounded-full" onClick={()=> handleDelete(question.id)}>Delete</button>
                                </td>
                            </tr>
                        ))}

                </tbody>
            </table>
            {/* Form để thêm từ vựng */}
            {showForm && (
                <CourseForm onClose={handleCloseForm} onSubmit={handleSubmitForm} />
            )}
        </div>
    );
}


function CourseForm({ onClose, onSubmit }) {
    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = {
            question: e.target.elements.question.value,
            op1: e.target.elements.question.op1,
            op2: e.target.elements.question.op2,
            op3: e.target.elements.question.op3,
            answer: e.target.elements.answer.value,
            explanation: e.target.elements.explanation.value,
        };
        onSubmit(formData);
    };

    return (
        <div className="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-gray-300 bg-opacity-75 z-50">
            <div className="bg-white p-8 rounded-lg shadow-lg w-1/2">
                <h2 className="text-lg font-bold mb-4">Add Vocabulary</h2>
                <form onSubmit={handleSubmit}>
                    <div className="mb-4">
                        <label className="block mb-1" htmlFor="vocabWord">Question</label>
                        <input className="border w-full p-2" type="text" id="question" name="question" required />
                    </div>
                    <div className="mb-4">
                        <label className="block mb-1" htmlFor="gern">Option 1</label>
                        <input className="border w-full p-2" type="text" id="op1" name="op1" />
                    </div>
                    <div className="mb-4">
                        <label className="block mb-1" htmlFor="gern">Option 2</label>
                        <input className="border w-full p-2" type="text" id="op2" name="op2" />
                    </div>
                    <div className="mb-4">
                        <label className="block mb-1" htmlFor="gern">Option 3</label>
                        <input className="border w-full p-2" type="text" id="op3" name="op3" />
                    </div>
                    <div className="mb-4">
                        <label className="block mb-1" htmlFor="gern">Answer</label>
                        <input className="border w-full p-2" type="text" id="answer" name="answer" />
                    </div>
                    <div className="mb-4">
                        <label className="block mb-1" htmlFor="vocabIPA">Exercise Type</label>
                        <input className="border w-full p-2" type="text" id="exserciseType" name="exserciseType" />
                    </div>
                    <div className="flex justify-end">
                        <button type="submit" className="bg-blue-500 text-white py-2 px-4 rounded mr-2">Add</button>
                        <button type="button" className="bg-gray-400 text-white py-2 px-4 rounded" onClick={onClose}>Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    );
}