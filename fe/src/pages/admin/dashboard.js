export default function Dashboard() {
    return (
        <div className="m-5">
            <div className="bg-green-300 max-w-60 max-h-20 h-20 mb-5 flex justify-center items-center rounded-3xl">
                <div className="text-2xl">200 khoa hoc</div>
            </div>
            <div className="flex flex-row">
                <table className="border w-60 mr-5 basis-1/2">
                    <thead >
                        <tr>
                            <th className="border">
                                danh sach khoa hoc
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td className="border pl-2">toic 600</td>
                        </tr>
                        <tr>
                            <td className="border pl-2">toic 700</td>
                        </tr>
                        <tr>
                            <td className="border pl-2">toic 800</td>
                        </tr>
                    </tbody>
                </table>
                <table className="border w-60 basis-1/2">
                    <thead >
                        <tr>
                            <th className="border">
                                danh sach tai khoan
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td className="border pl-2">
                                pham nghia
                            </td>
                        </tr>
                        <tr>
                            <td className="border pl-2">thanh phuc</td>
                        </tr>
                        <tr>
                            <td className="border pl-2">hoang nghia</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    )
}