import { useState } from "react";
import { Link, useHistory } from "react-router-dom";
import { authenticate } from "../../service";
import Cookies from "universal-cookie";

export default function Login() {
    const cookies = new Cookies();

    const [formData, setFormData] = useState({
        email: "",
        password: ""
    });
    const [error, setError] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await authenticate(formData);
            cookies.set("token", response.token);
            cookies.set("name", response.name);
            cookies.set("username", response.username);
            cookies.set("role", response.role);
            window.location.replace('/')
        } catch (error) {
            console.error("Login error:", error);
            setError("Đăng nhập thất bại. Vui lòng thử lại."); // Update error state for displaying to the user
        }
    };

    return (
        <div className="container flex justify-center items-center">
            <div className="flex flex-col justify-center items-center border">
                <p className="text-2xl mt-4">Đăng nhập</p>
                <form className="flex flex-col min-w-96 gap-4 m-4" onSubmit={handleSubmit}>
                    <div className="flex flex-col w-full">
                        <label>Email:</label>
                        <input
                            className="border rounded-full p-2"
                            type="email"
                            name="email"
                            placeholder="abc123@gmail.com"
                            value={formData.email}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="flex flex-col w-full">
                        <label>Password:</label>
                        <input
                            className="border rounded-full p-2"
                            type="password"
                            name="password"
                            placeholder="123@abc"
                            value={formData.password}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="w-full text-center">
                        <input
                            className="bg-blue-400 w-full max-w-60 p-2 text-white text-lg rounded-full"
                            type="submit"
                            value="Đăng nhập"
                        />
                    </div>
                    {error && <p className="text-red-500 text-sm mt-2">{error}</p>}
                </form>
                <p className="mb-4">
                    Bạn đã có tài khoản chưa? <Link to="/register">Đăng ký</Link>
                </p>
            </div>
        </div>
    );
}
