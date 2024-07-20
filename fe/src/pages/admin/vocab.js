export default function MVoacb() {
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
                        <th className="border p-2">text</th>
                        <th className="border p-2">ipa</th>
                        <th className="border p-2">mean</th>
                        <th className="border p-2">example</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td className="border p-2">school</td>
                        <td className="border p-2">/skˈuːl/</td>
                        <td className="border p-2">Truong hoc</td>
                        <td className="border p-2">The behaviour of this school in public is sometimes not very good.</td>
                        <td className="border p-2 text-center">
                            <button className="bg-red-500 text-white p-2 rounded">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td className="border p-2">vegetable</td>
                        <td className="border p-2">/ˈvedʒtəbl/</td>
                        <td className="border p-2">rau</td>
                        <td className="border p-2">We grow potatoes, beans, and other vegetables</td>
                        <td className="border p-2 text-center">
                            <button className="bg-red-500 text-white p-2 rounded">Delete</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}
