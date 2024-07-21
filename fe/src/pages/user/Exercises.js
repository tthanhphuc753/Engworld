import React, { useState, useEffect } from 'react';
import { userGetAllQuestion } from '../../service';

export default function Exercises() {
    const [questions, setQuestions] = useState([]);
    
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await userGetAllQuestion();
                setQuestions(response.content);
                setSelectedAnswers(Array(response.length).fill(null))
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        };

        fetchData();

    }, []);
    const [selectedAnswers, setSelectedAnswers] = useState(Array(questions.length).fill(null));
    const [showExplanation, setShowExplanation] = useState(Array(questions.length).fill(false));
    const handleAnswerSelect = (questionIndex, optionIndex) => {
        const newSelectedAnswers = [...selectedAnswers];
        newSelectedAnswers[questionIndex] = optionIndex;
        setSelectedAnswers(newSelectedAnswers);
    };

    const toggleExplanation = (questionIndex) => {
        setShowExplanation(prevState => {
            const newState = [...prevState];
            newState[questionIndex] = !newState[questionIndex];
            return newState;
        });
    };

    return (
        <div className="flex flex-col items-center justify-center">
            <div className='text-2xl my-5'>Exercises:</div>
            <ul className=''>
                {questions.map((question, index1) => (
                    <li key={index1}>
                        <p className='text-lg font-medium'>{question.questionText}</p>
                        {question.options.map((option, index2) => (
                            <div key={index2}>
                                <input
                                    type="radio"
                                    name={`q${index1}`}
                                    checked={selectedAnswers[index1] === index2}
                                    onChange={() => handleAnswerSelect(index1, index2)}
                                />
                                <label className='ml-2'>{option}</label>
                            </div>
                        ))}
                        {selectedAnswers[index1] !== null && (
                            <div>
                                <button onClick={() => toggleExplanation(index1)}>
                                    {showExplanation[index1] ? "Ẩn giải thích" : "Hiện giải thích"}
                                </button>
                                {showExplanation[index1] && (
                                    <div>
                                        <p>{question.correctAnswer}</p>
                                        <p className='text-wrap max-w-md'>{question.explanation} vvv vvv vvv vvv vvv vvv vvv vvv vvv vvv vvv vvv vvv vv vvv vvv vvv vvv vvv vvv vvv vv vvv vvv vvv vvv vvv vvv vvv vv vvv vvv vvv vvv vvv vvv vvv</p>
                                    </div>
                                )}
                            </div>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
}
