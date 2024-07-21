import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { clientGetTest } from "../../service";
export default function Test() {
    const [questions, setQuestions] = useState([])
    const [selectedAnswers, setSelectedAnswers] = useState([]);
    const [score, setScore] = useState(null);
    const { id } = useParams()
    console.log('id:', id)
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await clientGetTest(id);
                setQuestions(response.content);
                console.log(response.content)
                setSelectedAnswers(Array(response.content.length).fill(null));
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        };

        fetchData();
    }, []);
    const handleAnswerSelect = (questionIndex, optionIndex) => {
        const newSelectedAnswers = [...selectedAnswers];
        newSelectedAnswers[questionIndex] = optionIndex;
        setSelectedAnswers(newSelectedAnswers);
    };
    const handleSubmit = () => {
        console.log('slcas:',selectedAnswers)
        let correctCount = 0;
        questions.forEach((question, index) => {
            const selectedOptionIndex = selectedAnswers[index];
            if (selectedOptionIndex !== null && selectedOptionIndex === question.correctAnswer) {
                correctCount++;
            }
        });

        const totalQuestions = questions.length;
        const percentageScore = (correctCount / totalQuestions) * 100;
        setScore(percentageScore);

        // Hiển thị thông báo kết quả
        alert(`Số câu đúng: ${correctCount}/${totalQuestions}\nĐiểm số: ${percentageScore}%`);
        window.location.href = '/tests';
    };
    console.log('question', questions)
    return (
        <div className="m-5">
            <div className="w-full text-center my-5">

                <p className="text-2xl">Đề số 1</p>
            </div>
            <div className="flex ">
                <div className="min-w-80 border h-fit text-center mr-4">
                    <ul className="grid grid-cols-5 m-2 ">
                        {
                            questions.map((_, index) => (
                                <li key={`q${index}`} className="flex flex-col text-center">
                                    <label>{index + 1 }</label>
                                    <input type="checkbox" checked={selectedAnswers[index] !== null} disabled></input>
                                </li>
                            ))
                        }
                    </ul>
                    <button className="m-2 bg-blue-400 text-white py-2 px-5 rounded-full" onClick={handleSubmit}>Nộp bài</button>
                </div>
                <ul>
                    {
                        questions.map((question, index) => (
                            <li key={`q${index}`}>
                                <p className="font-medium">{question.questionText}</p>
                                {question.options.map((option, optionIndex) => (
                                    <div className="flex gap-4">
                                        <input type="radio" name={`q${index}`} checked={selectedAnswers[index] === optionIndex}
                                        onChange={() => handleAnswerSelect(index, option)}></input>
                                        <p className="">{option}</p>
                                    </div>
                                ))}
                            </li>
                        ))
                    }
                </ul>
            </div>
        </div>
    )
}