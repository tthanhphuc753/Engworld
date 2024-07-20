import { useState, useRef } from "react";

const questions = [
    {
        question: "The babysitter has told Billy’s parents about his _____ behavior and how he starts acting as soon as they leave home.",
        options: ["focus-seeking", "meditation-seeking", "attention-seeking", "concentration-seeking"],
        answer: "attention-seeking"
    },
    {
        question: "_____ as a masterpiece, a work of art must transcend the ideals of the period in which it was created.",
        options: ["In order to be ranking", "Ranking", "Being ranked", "To be ranked"],
        answer: "To be ranked"
    },
    {
        question: "Every _____ piece of equipment was sent to the fire.",
        options: ["disposable", "consumable", "spendable", "available"],
        answer: "disposable"
    },
    {
        question: "Smith had a lucky escape. He _____ killed.",
        options: ["should have been", "would have been", "must have been", "could have been"],
        answer: "could have been"
    },
    {
        question: "Neither of the boys came to school yesterday, _____?",
        options: ["didn’t he", "does he", "did he", "doesn’t he"],
        answer: "did he"
    },
    {
        question: "A good leader in globalization is not to impose but _____ change.",
        options: ["facilitate", "show", "cause", "oppose"],
        answer: "facilitate"
    },
    {
        question: "The old man warned the young boys _____ in the deep river.",
        options: ["not to swimming", "don’t swim", "to swim", "against swimming"],
        answer: "against swimming"
    },
    {
        question: "His father used to be a _____ professor at the university. Many students worshipped him.",
        options: ["distinguishing", "distinct", "distinctive", "distinguished"],
        answer: "distinguished"
    },
    {
        question: "If Tim _____ so fast, his car wouldn’t have crashed into a tree.",
        options: ["haven’t driven", "didn’t drive", "drives", "hadn’t driven"],
        answer: "hadn’t driven"
    },
    {
        question: "Most of the _____ in this workshop do not work very seriously or productively.",
        options: ["rank and file", "tooth and nail", "eager beavers", "old hand"],
        answer: "rank and file"
    },
    {
        question: "Not only _____ in the field of psychology but animal behavior is examined as well.",
        options: ["is human behavior studied", "is studied human behavior", "human behavior", "human behavior is studied"],
        answer: "is human behavior studied"
    },
    {
        question: "Luckily, the rain _____ so we were able to play the match.",
        options: ["watered down", "gave out", "got away", "held off"],
        answer: "held off"
    }
];

export default function Test() {
    const [selectedOptions, setSelectedOptions] = useState(Array(12).fill(null));
    const questionRefs = useRef([]);

    const handleOptionChange = (questionIndex, optionIndex) => {
        const newSelectedOptions = [...selectedOptions];
        newSelectedOptions[questionIndex] = optionIndex;
        setSelectedOptions(newSelectedOptions);
    };

    const handleLabelClick = (index) => {
        if (questionRefs.current[index]) {
            questionRefs.current[index].scrollIntoView({ behavior: 'smooth', block: 'start' });
        }
    };

    const handleCheckboxChange = (index) => {
        // Chỉ thay đổi trạng thái checkbox nếu chưa được đánh dấu
        if (!selectedOptions[index]) {
            const newSelectedOptions = [...selectedOptions];
            newSelectedOptions[index] = 0; // Chọn tùy chọn đầu tiên
            setSelectedOptions(newSelectedOptions);
        }
    };
    const handleSubmit = () => {
        
    }
    return (
        <div className="container ">
            <div className="w-full text-center text-lg font-medium mb-5">
                <p>Đề 1</p>
            </div>
            <div className="flex flex-row">
                <div className="sticky top-0 text-xs w-60 h-fit border rounded-md text-center">
                    <ul className="grid grid-cols-5 place-items-center">
                        {questions.map((_, index) => (
                            <li key={index} className="flex flex-col">
                                <label htmlFor={`checkbox-${index}`} onClick={() => handleLabelClick(index)} className="text-lg cursor-pointer">
                                    {index + 1}
                                </label>
                                <input
                                    type="checkbox"
                                    id={`checkbox-${index}`}
                                    checked={selectedOptions[index] !== null}
                                    onChange={() => handleCheckboxChange(index)}
                                    disabled
                                    style={{ cursor: 'pointer' }}
                                    className="checkbox-custom mb-1"
                                />

                            </li>
                        ))}

                    </ul>
                    <button onClick={handleSubmit} className="my-3 px-4 py-2 bg-blue-500 text-white rounded">
                        Nộp bài
                    </button>
                </div>
                <ul className="flex-1 ml-4">
                    {questions.map((question, index) => (
                        <li key={index} ref={el => (questionRefs.current[index] = el)}>
                            <p className="font-medium text-lg">Question {index + 1}: {question.question}</p>
                            {question.options.map((option, optIndex) => (
                                <div key={optIndex} className="flex">
                                    <input
                                        type="radio"
                                        name={`q${index}`}
                                        value={optIndex}
                                        checked={selectedOptions[index] === optIndex}
                                        onChange={() => handleOptionChange(index, optIndex)}
                                        className="radio-custom mr-1"
                                    />
                                    <p>{option}</p>
                                </div>
                            ))}
                        </li>
                    ))}
                    <div className="italic">---Hết---</div>
                </ul>
            </div>
        </div>
    );
}
