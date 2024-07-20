export default function MCourses() {
    return (
        <div className="flex flex-col p-4">
            <div className="mx-10 mb-4 flex flex-row">
                <div className="mr-4">
                    <input type="text" className="border p-2 mr-2" placeholder="Type here..." />
                    <button className="bg-blue-500 text-white p-2 rounded">Submit</button>
                </div>
                <button className="bg-blue-500 text-white p-2 rounded">Add</button>
            </div>
            <table className="border-collapse border mx-10">
                <thead>
                    <tr>
                        <th className="border p-2">Name</th>
                        <th className="border p-2">price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td className="border p-2">toic 900</td>
                        <td className="border p-2">200.000</td>
                        <td className="border p-2 text-center">
                            <button className="bg-red-500 text-white p-2 rounded">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td className="border p-2">ielts 6.5</td>
                        <td className="border p-2">200.000</td>
                        <td className="border p-2 text-center">
                            <button className="bg-red-500 text-white p-2 rounded">Delete</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}
