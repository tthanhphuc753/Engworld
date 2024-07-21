import { Link } from "react-router-dom"
export default function Login() {
    return (
        <div className="container flex justify-center items-center">

            <div className="flex flex-col justify-center items-center border">
                <p className="text-2xl mt-4">Đăng nhập</p>
                <form className="flex flex-col min-w-96 gap-4 m-4">
                    <div className="flex flex-col w-full">

                        <label >
                            Email:
                        </label>
                        <input className="border rounded-full p-2 " type="email" placeholder="abc123@gmail.com"></input>
                    </div>
                    <div className="flex flex-col w-full">

                        <label>
                            Password:
                        </label>
                        <input className="border rounded-full p-2" type="password" placeholder="123@abc"></input>
                    </div>
                    
                    <div className="w-full text-center">

                        <input className="bg-blue-400 w-full max-w-60 p-2 text-white text-lg rounded-full" type="submit" value={"Đăng nhập"}></input>
                    </div>
                </form>
                <p className="mb-4">Bạn đã có tài khoản chưa? <Link to="/register">Đăng ký</Link></p>
            </div>
        </div>
    )
}