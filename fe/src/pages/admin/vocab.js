import { FaMagnifyingGlass } from "react-icons/fa6";
import { useState, useEffect } from "react";
import { deleteVocabulary, getAllVocabulary, uploadVocabFile } from "../../service";

export default function Vocabulary() {
  const [vocabulary, setVocabulary] = useState([]);
  const [filteredVocabulary, setFilteredVocabulary] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [showForm, setShowForm] = useState(false); // State để điều khiển hiển thị form
  const [selectedFile, setSelectedFile] = useState(null); // State để lưu file Excel được chọn

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getAllVocabulary();
        setVocabulary(response.data.content);
        setFilteredVocabulary(response.data.content);
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
    const filtered = vocabulary.filter(item =>
      item.vocabWord.toLowerCase().includes(searchTerm.toLowerCase()) ||
      item.topicName.toLowerCase().includes(searchTerm.toLowerCase()) ||
      item.vocabMeaning.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setFilteredVocabulary(filtered);
  };

  const handleDelete = async (id) => {
    try {
      const response = await deleteVocabulary(id);
      if (response.status === 200) {
        console.log('Delete successful');
        const updatedVocabulary = vocabulary.filter(item => item.vocabId !== id);
        setVocabulary(updatedVocabulary);
        setFilteredVocabulary(updatedVocabulary);
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

      const response = await uploadVocabFile(formData);
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
        <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full" onClick={handleFind}>
          <FaMagnifyingGlass />
        </button>
        <button className="bg-blue-500 text-white py-2 px-10 border rounded-full mr-5" onClick={handleAdd}>
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
            <th className="border">Text</th>
            <th className="border">Gern</th>
            <th className="border">IPA</th>
            <th className="border">Mean</th>
            <th className="border">Example</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {filteredVocabulary.map((v, index) => (
            <tr key={index}>
              <td className="border">{v.vocabWord}</td>
              <td className="border">{v.gern}</td>
              <td className="border">{v.vocabIPA}</td>
              <td className="border">{v.vocabMeaning}</td>
              <td className="border">{v.vocabExample}</td>
              <td className="border">
                <button className="bg-red-500 text-white mx-4 py-2 px-4 rounded-full" onClick={() => handleDelete(v.vocabId)}>delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Form để thêm từ vựng */}
      {showForm && (
        <VocabularyForm onClose={handleCloseForm} onSubmit={handleSubmitForm} />
      )}


    </div>
  );
}

// Component Form để thêm từ vựng
function VocabularyForm({ onClose, onSubmit }) {
  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = {
      vocabWord: e.target.elements.vocabWord.value,
      gern: e.target.elements.gern.value,
      vocabIPA: e.target.elements.vocabIPA.value,
      vocabMeaning: e.target.elements.vocabMeaning.value,
      vocabExample: e.target.elements.vocabExample.value,
    };
    onSubmit(formData);
  };

  return (
    <div className="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-gray-300 bg-opacity-75 z-50">
      <div className="bg-white p-8 rounded-lg shadow-lg w-1/2">
        <h2 className="text-lg font-bold mb-4">Add Vocabulary</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="vocabWord">Vocabulary Word</label>
            <input className="border w-full p-2" type="text" id="vocabWord" name="vocabWord" required />
          </div>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="gern">Gern</label>
            <input className="border w-full p-2" type="text" id="gern" name="gern" />
          </div>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="vocabIPA">IPA Pronunciation</label>
            <input className="border w-full p-2" type="text" id="vocabIPA" name="vocabIPA" />
          </div>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="vocabMeaning">Meaning</label>
            <input className="border w-full p-2" type="text" id="vocabMeaning" name="vocabMeaning" required />
          </div>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="vocabExample">Example Sentence</label>
            <input className="border w-full p-2" type="text" id="vocabExample" name="vocabExample" required />
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
