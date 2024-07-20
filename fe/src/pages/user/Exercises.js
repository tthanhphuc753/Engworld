import { useState } from "react";

export default function Exercises() {
    const questions = [
        {
            question: 'Question 1: - “Do you mind if I take a seat?” - “_____.”',
            options: [
                { value: 'A', label: 'A. No I mind' },
                { value: 'B', label: 'B. No, do as you please' },
                { value: 'C', label: 'C. Yes, do as you please' },
                { value: 'D', label: 'D. Yes, I don’t mind' },
            ],
            explanation: 'Explanation for question 3.',
        },
        {
            question: 'Question 2: Jenny: “I think higher living standard is one of the reason that many people want to be a city dweller.” Mark: “_____”',
            options: [
                { value: 'A', label: 'A. Why not?' },
                { value: 'B', label: 'B. I couldn’t agree more.' },
                { value: 'C', label: 'C. It’s nice of you to say so.' },
                { value: 'D', label: 'D. That’s quite all right.' },
            ],
            explanation: 'Explanation for question 4.',
        },
        {
            question: 'Question 3: According to the passage, which of the following is the pending in Raiya Sabha?',
            options: [
                { value: 'A', label: 'A. Real estate bill B. Universal rural housing programme' },
                { value: 'B', label: 'B. The urban dwellers’ inaccessibility to housing' },
                { value: 'C', label: 'C. Universal urban housing programme ' },
                { value: 'D', label: 'D. NDA government’s new scheme' },
            ],
            explanation: 'Explanation for question 4.',
        },
        {
            question: 'Question 4: What is the passage mainly about?',
            options: [
                { value: 'A', label: 'A. The obstacles and resolutions to India’s real estate market' },
                { value: 'B', label: 'B. The urban dwellers’ inaccessibility to housing' },
                { value: 'C', label: 'C. The need for urgent reform in housing distribution' },
                { value: 'D', label: 'D. The lack of housing in India' },
            ],
            explanation: 'Explanation for question 4.',
        },
        {
            question: 'Question 5: According to the passage, state governments _____.',
            options: [
                { value: 'A', label: 'A. encourage the real estate market' },
                { value: 'B', label: 'B. obstruct reforms to access universal urban housing' },
                { value: 'C', label: 'C. hinder the housing purchase process' },
                { value: 'D', label: 'D. reject to mount the housing fee' },
            ],
            explanation: 'Explanation for question 4.',
        },
        {
            question: 'Question 6: The babysitter has told Billy’s parents about his _____ behavior and how he starts acting act as soon as they leave home.',
            options: [
                { value: 'A', label: 'A. focus-seeking' },
                { value: 'B', label: 'B. meditation- seeking' },
                { value: 'C', label: 'C. attention-seeking' },
                { value: 'D', label: 'D. concentration-seeking' },
            ],
            explanation: 'Explanation for question 4.',
        },
    ];

    const [state, setState] = useState(questions.map(() => ({ selectedAnswer: null, showExplanation: false })));

    const handleAnswerChange = (index, value) => {
        const newState = [...state];
        newState[index].selectedAnswer = value;
        newState[index].showExplanation = false;
        setState(newState);
    };

    const toggleExplanation = (index) => {
        const newState = [...state];
        newState[index].showExplanation = !newState[index].showExplanation;
        setState(newState);
    };

    return (
        <div className="container">
            <div>
                <p className="text-2xl font-bold">Exercises:</p>
            </div>
            <ul>
                {questions.map((q, index) => (
                    <li key={index}>
                        <p className="font-medium">{q.question}</p>
                        <div className="flex flex-col">
                            {q.options.map((option, idx) => (
                                <label key={idx}>
                                    <input
                                        type="radio"
                                        name={`q${index}`}
                                        value={option.value}
                                        checked={state[index].selectedAnswer === option.value}
                                        onChange={() => handleAnswerChange(index, option.value)}
                                    />
                                    {option.label}
                                </label>
                            ))}
                        </div>
                        {state[index].selectedAnswer && (
                            <div>
                                <button onClick={() => toggleExplanation(index)}>Giải thích</button>
                                {state[index].showExplanation && (
                                    <div>
                                        <p className="italic">{q.explanation}</p>
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
