import React, { useState } from 'react';

const questions = [
    {
        question: "Question 26: The babysitter has told Billy’s parents about his _____ behavior and how he starts acting as soon as they leave home.",
        options: [
            "A. focus-seeking",
            "B. meditation-seeking",
            "C. attention-seeking",
            "D. concentration-seeking"
        ],
        answer: "C. attention-seeking",
        explanation: "Attention-seeking behavior refers to behavior that is intended to attract attention to oneself, typically to gain validation or recognition."
    },
    {
        question: "Question 27: _____ as a masterpiece, a work of art must transcend the ideals of the period in which it was created.",
        options: [
            "A. In order to be ranking",
            "B. Ranking",
            "C. Being ranked",
            "D. To be ranked"
        ],
        answer: "D. To be ranked",
        explanation: "The sentence structure requires an infinitive phrase ('to be ranked') to complete the meaning: 'In order to be ranked as a masterpiece...'."
    },
    // Add more questions here
];

export default function Exercises() {
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
        <div className="">
            <div className='text-2xl'>Exercises:</div>
            <ul className=''>
                {questions.map((question, index1) => (
                    <li key={index1}>
                        <p>{question.question}</p>
                        {question.options.map((option, index2) => (
                            <div key={index2}>
                                <input
                                    type="radio"
                                    name={`q${index1}`}
                                    checked={selectedAnswers[index1] === index2}
                                    onChange={() => handleAnswerSelect(index1, index2)}
                                />
                                <label>{option}</label>
                            </div>
                        ))}
                        {selectedAnswers[index1] !== null && (
                            <div>
                                <button onClick={() => toggleExplanation(index1)}>
                                    {showExplanation[index1] ? "Ẩn giải thích" : "Hiện giải thích"}
                                </button>
                                {showExplanation[index1] && (
                                    <div>
                                        <p className=''>{question.explanation}</p>
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
