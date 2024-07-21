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

export default function Test() {
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
                                    <label>{index}</label>
                                    <input type="checkbox"></input>
                                </li>
                            ))
                        }
                    </ul>
                    <button className="m-2 bg-blue-400 text-white py-2 px-5 rounded-full">Nộp bài</button>
                </div>
                <ul>
                    {
                        questions.map((question, index) => (
                            <li key={`q${index}`}>
                                <p className="font-medium">{question.question}</p>
                                {question.options.map((option, index2) => (
                                    <div className="flex gap-4">
                                        <input type="radio" name={`q${index}`}></input>
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