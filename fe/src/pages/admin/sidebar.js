import Cookies from "universal-cookie";

export default function Sidebar() {
    const cookies = new Cookies()
    const handleLogout = () => {
        cookies.remove('token')
        cookies.remove('role')
        cookies.remove('username')
        cookies.remove('name')
        // cookies.remove('JSESSIONID')
        window.location.href = "/"
      };
    return (
        <div className="shadow-md">
            <ul className="flex flex-row">
                <li className="basis-10/12 h-14 flex justify-center items-center">
                    <div className="">
                        <p className="text-2xl italic">
                            Welcome nghia
                        </p>
                    </div>
                </li>
                <li className="basis-2/12 flex justify-end items-center mr-5">
                    <button className="px-7 py-2 text-white bg-main-color border rounded-full" onClick={handleLogout}>dang xuat</button>
                </li>
            </ul>
        </div>
    );
}
