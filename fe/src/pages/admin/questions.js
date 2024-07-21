import { FaMagnifyingGlass } from "react-icons/fa6";
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
export default function Questions() {
    const handleSearchChange = () => {

    }
    const handlefind = () => {

    }
    return (
        <div className="flex flex-col justify-center items-center m-5">
            <div className="flex items-center justify-center w-full mb-5">
                <input type="text" className="border border-e-0 rounded-tl-full rounded-bl-full w-1/3 p-2 focus:outline-none pl-4" placeholder="Type here..." onChange={handleSearchChange} />
                <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full " onClick={handlefind}>
                    <FaMagnifyingGlass />
                </button>
                <button className="bg-blue-500 text-white py-2 px-10 border rounded-full" onClick={handlefind}>
                    Add
                </button>
            </div>
            <table className=" border">
                <thead>
                    <tr>
                        <th className="border">question</th>
                        <th className="border">A</th>
                        <th className="border">B</th>
                        <th className="border">C</th>
                        <th className="border">D</th>
                        <th className="border">Answer</th>
                        <th className="border">Explanation</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {questions.map((question, index) => (
                        <tr key={index}>
                            <td className="border">{question.question}</td>
                            {question.options.map((option, index2) => (
                                <td className="border">{option}</td>
                            ))}
                            <td className="border">{question.answer}</td>
                            <td className="border">{question.explanation}</td>
                            <td className="border">
                                <button className="bg-red-500 text-white mx-4 py-2 px-4 rounded-full">delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>

            </table>
        </div>
    )
}