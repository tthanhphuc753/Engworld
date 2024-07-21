import { Link } from "react-router-dom";
import { MdDashboard } from "react-icons/md";
import { MdAccountCircle } from "react-icons/md";
import { LuFileQuestion } from "react-icons/lu";
import { FiDatabase } from "react-icons/fi";
import { TbVocabulary } from "react-icons/tb";
export default function Nav() {
    return (
        <div className="bg-blue-400 min-h-screen flex flex-col fixed top-0 left-0 w-1/6">
            <div className="min-h-14 flex justify-center items-center my-10">
                <Link to="/" className="text-white text-4xl">E-Learning</Link>
            </div>
            <ul className="flex flex-col space-y-4 text-white">
                <li className="py-2 flex items-center justify-center text-xl">
                    <Link to="/dashboard" className="flex items-center justify-center">
                        <MdDashboard />

                        Dashboard
                    </Link>
                </li>
                <li className="py-2 flex items-center justify-center text-xl">
                    <Link to="/accounts" className="flex items-center justify-center">
                    <MdAccountCircle />
                        Accounts
                    </Link>
                </li>
                <li className="py-2 flex items-center justify-center text-xl">
                    <Link to="/questions" className="flex items-center justify-center">
                    <LuFileQuestion />
                        Questions
                    </Link>
                </li>
                <li className="py-2 flex items-center justify-center text-xl">
                    <Link to="/courses" className="flex items-center justify-center">
                    <FiDatabase />
                        Courses
                    </Link>
                </li>
                <li className="py-2 flex items-center justify-center text-xl">
                    <Link to="/vocabulary" className="flex items-center justify-center">
                    <TbVocabulary />
                        Vocabulary
                    </Link>
                </li>
            </ul>
        </div>
    )
}
