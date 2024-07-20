import React, { useState } from 'react';
import api, {authenticate} from '../../services';
import Cookies from 'universal-cookie';
import { useNavigate } from 'react-router-dom';

export default function Login() {
    const [formData, setFormData] = useState({ email: '', password: '' });
    const cookies = new Cookies()
    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        // Thực hiện các bước gửi dữ liệu formData đến server tại đây
        try {
            const response = await authenticate(formData)
            await Promise.all([
                cookies.set('token', response.token),
                cookies.set('role', response.role),
                cookies.set('username', response.username),
                cookies.set('name', response.name)
            ]);
            window.location.replace('/')
        } catch (e) {
            console.error(e)
        }
    };

    return (
        <div className="my-48" >
            <div className="w-96 bg-white flex flex-col items-center border border-inherit rounded-md px-5">
                <p className="text-2xl my-5">Đăng nhập</p>
                <form className="w-full flex flex-col" onSubmit={handleSubmit}>
                    <div className="mb-7">
                        <label
                            htmlFor="email"
                            className=" text-gray-600"
                        >
                            Email
                        </label>
                        <input
                            id="email"
                            name="email"
                            type="email"
                            className="h-10 w-full border border-inherit rounded-md pl-2 focus:outline-none"
                            value={formData.email}
                            onChange={handleChange}
                            placeholder=" "
                        />

                    </div>
                    <div className="mb-7">
                        <label
                            htmlFor="password"
                            className="text-gray-600"
                        >
                            Mật Khẩu
                        </label>
                        <input
                            id="password"
                            name="password"
                            type="password"
                            className="h-10 w-full border border-inherit rounded-md pl-2 focus:outline-none"
                            value={formData.password}
                            onChange={handleChange}
                            placeholder=" "
                        />

                    </div>
                    <div className="flex justify-center border border-inherit rounded-md text-white bg-main-color h-10">
                        <input type="submit" value="Đăng nhập" className="w-full h-full cursor-pointer" />
                    </div>
                </form>
                <div className="flex my-3">
                    <p className="mr-2">Bạn đã có tài khoản chưa?</p>
                    <a href="/#" className="decoration-solid decoration-inherit hover:underline">Đăng ký</a>
                </div>
            </div>
        </div>
    );
}
