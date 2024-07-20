import React, { useState } from 'react';

export default function Register() {
    const [formData, setFormData] = useState({ fname: '', lname: '', email: '', password: '' });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(formData);
        // Thực hiện các bước gửi dữ liệu formData đến server tại đây
    };

    return (
        <div className="my-24">
            <div className="w-96 bg-white flex flex-col items-center border border-inherit rounded-md px-5">
                <p className="text-2xl my-5">Đăng Ký</p>
                <form className="w-full flex flex-col" onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label
                            htmlFor="fname"
                            className=" text-gray-600"
                        >
                            First Name:
                        </label>
                        <input
                            id="fname"
                            name="fname"
                            type="text"
                            className="h-10 w-full border border-inherit rounded-md pl-2 focus:outline-none"
                            value={formData.fname}
                            onChange={handleChange}
                            placeholder=" "
                        />
                    </div>
                    <div className="mb-3">
                        <label
                            htmlFor="lname"
                            className=" text-gray-600"
                        >
                            Last Name:
                        </label>
                        <input
                            id="lname"
                            name="lname"
                            type="text"
                            className="h-10 w-full border border-inherit rounded-md pl-2 focus:outline-none"
                            value={formData.lname}
                            onChange={handleChange}
                            placeholder=" "
                        />

                    </div>
                    <div className="mb-3">
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
                    <div className="mb-3">
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
                    <div className="mb-3">
                        <label
                            htmlFor="password"
                            className="text-gray-600"
                        >
                            Mật Khẩu
                        </label>
                        <input
                            id="passwordConfirm"
                            name="passwordConfirm"
                            type="password"
                            className="h-10 w-full border border-inherit rounded-md pl-2 focus:outline-none"
                            value={formData.passwordConfirm}
                            onChange={handleChange}
                            placeholder=" "
                        />

                    </div>
                    <div className="flex justify-center border border-inherit rounded-md text-white bg-main-color h-10">
                        <input type="submit" value="Đăng Ký" className="w-full h-full cursor-pointer" />
                    </div>
                </form>
                <div className="flex my-3">
                    <p className="mr-2">Bạn đã có tài khoản chưa?</p>
                    <a href="/#" className="decoration-solid decoration-inherit hover:underline">Đăng Nhập</a>
                </div>
            </div>
        </div>
    );
}
