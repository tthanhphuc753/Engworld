const users = [
    {
        name: "thanh phuc",
        email: "tthanhphuc753@gmail.com",
        role: "admin"
    },
    {
        name: "thanh phuc111",
        email: "tthanhphuc753@gmail.com",
        role: "user"
    }
]
const courses = [
    {
        title: "ielts 7.5",
        price: "2000000",

    }
]
export default function Dashboard() {
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
                            <th className="border">name</th>
                            <th className="border">email</th>
                            <th className="border">role</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users && users.map((user, index) =>
                            <tr>
                                <td className="border">{user.name}</td>

                                <td className="border">{user.email}</td>
                                <td className="border">{user.role}</td>
                            </tr>
                        )}
                    </tbody>
                </table>

                <table className="border basis-1/3">
                    <thead>
                        <tr>
                            <th className="border">title</th>
                            <th className="border">price</th>
                        </tr>
                    </thead>
                    <tbody>
                        {courses && courses.map((course, index) =>
                            <tr>
                                <td className="border">{course.title}</td>

                                <td className="border">{course.price}</td>

                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}