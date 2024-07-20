export default function MQuestion() {
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
                        <th className="border p-2">option 1</th>
                        <th className="border p-2">option 2</th>
                        <th className="border p-2">option 3</th>
                        <th className="border p-2">option 4</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td className="border p-2">“Do you mind if I take a seat?” - “_____.”</td>
                        <td className="border p-2">No I mind</td>
                        <td className="border p-2">No, do as you please</td>
                        <td className="border p-2">Yes, do as you please</td>
                        <td className="border p-2">Yes, I don’t mind</td>
                        <td className="border p-2 text-center">
                            <button className="bg-red-500 text-white p-2 rounded">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td className="border p-2">Jenny: “I think higher living standard is one of the reason that many people want to be a
                            city dweller.” Mark: “_____”
                        </td>
                        <td className="border p-2">Why not?</td>
                        <td className="border p-2">I couldn’t agree more.</td>
                        <td className="border p-2">It’s nice of you to say so.</td>
                        <td className="border p-2">That’s quite all right.
                        </td>
                        <td className="border p-2 text-center">
                            <button className="bg-red-500 text-white p-2 rounded">Delete</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}