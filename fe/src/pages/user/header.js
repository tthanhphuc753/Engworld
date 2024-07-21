import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Cookies from "universal-cookie";

export default function Header() {
    const [token, setToken] = useState("")
    const [name, setName] = useState("")
    const cookies = new Cookies()
    useEffect(() => {
        const tokenE = cookies.get('token')
        if (tokenE) {
            setToken(tokenE)
            setName(cookies.get('name'))
        }
    }, [])
    const navigate = useNavigate()
    const handleLogin = () => {
        navigate('/login')
    }
    const handleLogout = () => {
        cookies.remove('token')
        cookies.remove('name')
        cookies.remove('username')
        cookies.remove('role')
    }
    return (
        <header className="flex flex-row w-screen justify-center items-center bg-blue-400 text-white">
            <div className="basis-2/12 text-3xl text-center">
                <Link to="/">
                    E-Learning
                </Link>
            </div>
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
                {token ? (
                    <li>
                        <button className="py-3 px-5 m-3 rounded-full bg-white text-blue-400" onClick={handleLogout}>Đăng xuất</button>
                    </li>
                ) : (
                    // Kiểm tra xem có phải đang chạy trong môi trường trình duyệt và location có tồn tại không
                    typeof window !== 'undefined' && window.location && window.location.pathname === "/login" ? (
                        <li>
                            <button className="py-3 px-5 m-3 rounded-full bg-white text-blue-400" onClick={handleLogin}>Đăng ký</button>
                        </li>
                    ) : (
                        <li>
                            <button className="py-3 px-5 m-3 rounded-full bg-white text-blue-400" onClick={handleLogin}>Đăng nhập</button>
                        </li>
                    )
                )}
            </ul>
        </header>
    )
}