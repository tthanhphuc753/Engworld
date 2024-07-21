import { FaMagnifyingGlass } from "react-icons/fa6";
const users = [
    {
        name: "thanh phuc",
        email: "tthanhphuc753@gmail.com",
        password: "******",
        role: "admin"
    },
    {
        name: "thanh phuc111",
        email: "tthanhphuc753@gmail.com",
        password: "******",
        role: "user"
    }
]
export default function Accounts() {
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
            <table className="w-2/3 border">
                <thead>
                    <tr>
                        <th className="border">name</th>
                        <th className="border">email</th>
                        <th className="border">password</th>
                        <th className="border">role</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user, index) => (
                        <tr key={index}>
                            <td className="border">{user.name}</td>
                            <td className="border">{user.email}</td>
                            <td className="border">{user.password}</td>
                            <td className="border">{user.role}</td>
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