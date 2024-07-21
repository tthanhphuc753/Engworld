import { useEffect, useState } from 'react'
import { getAllCourses, getAllUser } from '../../service'
// const users = [
//     {
//         name: "thanh phuc",
//         email: "tthanhphuc753@gmail.com",
//         role: "admin"
//     },
//     {
//         name: "thanh phuc111",
//         email: "tthanhphuc753@gmail.com",
//         role: "user"
//     }
// ]
// const courses = [
//     {
//         title: "ielts 7.5",
//         price: "2000000",

//     }
// ]
export default function Dashboard() {
    const [users, setUsers] = useState([]);
    const [courses, setCourses] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
          try {
            const response = await getAllUser();
            setUsers(response.data); // Assuming response is an array of users
            const response2 = await getAllCourses()
            console.log(response2.data)
            setCourses(response2.data.content)
          } catch (error) {
            console.error("Error fetching data:", error);
          }
        };
    
        fetchData();
    
      }, []);
    return (
        <div className="m-5">
            <div className="flex justify-around mb-5">
                <div className="py-10 px-20 bg-yellow-400 text-2xl">200 Khóa học</div>
                <div className="py-10 px-20 bg-green-400 text-2xl">1000 học sinh</div>
                <div className="py-10 px-20 bg-blue-400 text-2xl">50 đề thi</div>
            </div>
            <div className="flex justify-around">
                <table className="border basis-1/3">
                    <thead>
                        <tr>
                            <th className="border">first name</th>
                            <th className="border">last name</th>
                            <th className="border">email</th>
                            <th className="border">role</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.length > 0 ? users.map((user, index) =>
                            <tr key={index}>
                                <td className="border">{user.firstName}</td>
                                <td className="border">{user.lastName}</td>
                                <td className="border">{user.email}</td>
                                <td className="border">{user.role}</td>
                            </tr>
                        ): null}
                    </tbody>
                </table>
                <table className="border basis-1/3">
                    <thead>
                        <tr>
                            <th className="border">Name</th>
                            <th className="border">Level</th>
                            <th className="border">Des</th>
                        </tr>
                    </thead>
                    <tbody>
                        {courses.length > 0 && courses.map((course, index) =>
                            <tr key={index}>
                                <td className="border">{course.courseName}</td>
                                <td className="border">{course.courseLevel}</td>
                                <td className="border">{course.courseDes}</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}