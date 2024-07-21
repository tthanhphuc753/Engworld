import { FaMagnifyingGlass } from "react-icons/fa6";
import { useState, useEffect } from "react";
import { getAllUser } from "../../service";
// const users = [
//     {
//         name: "thanh phuc",
//         email: "tthanhphuc753@gmail.com",
//         password: "******",
//         role: "admin"
//     },
//     {
//         name: "thanh phuc111",
//         email: "tthanhphuc753@gmail.com",
//         password: "******",
//         role: "user"
//     }
// ]
export default function Accounts() {
    const [users, setUsers] = useState([]);
    const [filteredUsers, setFilteredUsers] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getAllUser();
                setUsers(response.data); // Assuming response is an array of users
                setFilteredUsers(response.data); // Initialize filteredUsers with all users
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        };

        fetchData();

    }, []);

    const handleSearchChange = (e) => {
        setSearchTerm(e.target.value);
    };
    const handleFind = () => {
        const filtered = users.filter(user =>
            user.firstName.toLowerCase().includes(searchTerm.toLowerCase()) ||
            user.lastName.toLowerCase().includes(searchTerm.toLowerCase()) ||
            user.email.toLowerCase().includes(searchTerm.toLowerCase())
        );
        setFilteredUsers(filtered);
    };
    return (
        <div className="flex flex-col justify-center items-center m-5">
            <div className="flex items-center justify-center w-full mb-5">
                <input type="text" className="border border-e-0 rounded-tl-full rounded-bl-full w-1/3 p-2 focus:outline-none pl-4" placeholder="Type here..." onChange={handleSearchChange} />
                <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full " onClick={handleFind}>
                    <FaMagnifyingGlass />
                </button>
                <button className="bg-blue-500 text-white py-2 px-10 border rounded-full" >
                    Add
                </button>
            </div>
            <table className="w-full border">
                <thead>
                    <tr>
                        <th className="border">First Name</th>
                        <th className="border">Lastt Name</th>
                        <th className="border">Email</th>
                        <th className="border">Password</th>
                        <th className="border">Role</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {filteredUsers.map((user, index) => (
                        <tr key={index}>
                            <td className="border">{user.firstName}</td>
                            <td className="border">{user.lastName}</td>
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