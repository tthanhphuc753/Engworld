import { useContext, useEffect, useState } from "react"
import { Link, useLocation, useNavigate } from "react-router-dom"
import Cookies from "universal-cookie"

export default function Header() {
    const [token, setToken] = useState()
    const cookies = new Cookies()
    const navigate = useNavigate()
    const location = useLocation()
    const isLoginPage = location.pathname === "/login"
    useEffect(() => {
        const tokenE = cookies.get('token')
        if (tokenE) {
            setToken(tokenE)
        }
    }, [])
    const handleLogout = () => {
        cookies.remove('token')
        cookies.remove('userRole')
        cookies.remove('username')
        // cookies.remove('name')
        // cookies.remove('JSESSIONID')
        window.location.href = "/"
    };
    const handleLogin = () => {
        navigate("/login")
    }
    const handleRegister = () => {
        navigate("/register")
    }
    return (
        <header className="mb-4">
            <nav className="flex flex-row max-w-full h-20 items-center bg-main-color">
                <div className="basis-1/6 text-center text-white text-3xl cursor-pointer">
                <Link to="/">
                    E-Learning
                </Link>
                </div>
                <ul className="flex flex-row justify-end basis-4/6 text-white">
                    <li className="mr-10 cursor-pointer relative after:absolute after:bottom-0 after:left-0 after:bg-white after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-in-out after:duration-300">
                        <Link to="/courses">
                            Khóa học
                        </Link>
                    </li>
                    <li className="mr-10 cursor-pointer relative after:absolute after:bottom-0 after:left-0 after:bg-white after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-in-out after:duration-300">
                        <Link to="/tests">
                            Đề thi
                        </Link>
                    </li>
                    <li className="mr-10 cursor-pointer relative after:absolute after:bottom-0 after:left-0 after:bg-white after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-in-out after:duration-300">
                        <Link to="/topics">
                            Topic
                        </Link>
                    </li>
                </ul>
                {token ? (
                    <div>
                        <button
                            className="basis-1/6 bg-white text-main-color my-2 rounded-3xl max-w-40 py-2"
                            onClick={handleLogout}
                        >
                            Đăng xuất
                        </button>
                    </div>
                ) : (
                    isLoginPage ? (
                        <button
                            className="basis-1/6 bg-white text-main-color my-2 rounded-3xl max-w-40 py-2"
                            onClick={handleRegister}
                        >
                            Đăng ký
                        </button>
                    ) : (
                        <button
                            className="basis-1/6 bg-white text-main-color my-2 rounded-3xl max-w-40 py-2"
                            onClick={handleLogin}
                        >
                            Đăng nhập
                        </button>
                    )
                )}
            </nav>
        </header>
    )
}