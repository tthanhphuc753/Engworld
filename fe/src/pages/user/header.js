import { Link } from "react-router-dom";

export default function Header() {
    return (
        <header className="flex flex-row w-screen justify-center items-center bg-blue-400 text-white">
            <div className="basis-2/12 text-3xl text-center">E-Learning</div>
            <ul className="flex flex-row basis-10/12 justify-end items-center">
                <li className="flex mr-5 gap-5">
                    <div>
                        <Link to="/courses">
                            Khóa học
                        </Link>
                    </div>
                    <div>
                        <Link to="/tests">
                            Thư viện đề thi
                        </Link>
                    </div>
                </li>
                <li>
                    <button className="py-3 px-5 m-3 rounded-full bg-white text-blue-400">Đăng nhập</button>
                </li>
            </ul>
        </header>
    )
}