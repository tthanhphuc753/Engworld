import { useEffect, useState } from "react";
import { FaMagnifyingGlass } from "react-icons/fa6";
const tests = {
    ltest: [
        { "name": "test 1", "Number of Questions": 2, "time": 10, "students": 20 },
        { "name": "test 2", "Number of Questions": 4, "time": 20, "students": 40 },
        { "name": "test 3", "Number of Questions": 6, "time": 30, "students": 60 },
        { "name": "test 4", "Number of Questions": 8, "time": 40, "students": 80 },
        { "name": "test 5", "Number of Questions": 10, "time": 50, "students": 100 },
        { "name": "test 6", "Number of Questions": 12, "time": 60, "students": 120 },
        { "name": "test 7", "Number of Questions": 14, "time": 70, "students": 140 },
        { "name": "test 8", "Number of Questions": 16, "time": 80, "students": 160 },
        { "name": "test 9", "Number of Questions": 18, "time": 90, "students": 180 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },
        { "name": "test 10", "Number of Questions": 20, "time": 100, "students": 200 },

        // Thêm các test khác nếu cần
    ],
    sotrang: 2, // Tổng số trang
};

export default function Tests() {
    const itemsPerPage = 20; // Số item mỗi trang
    const [listTest, setListTest] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [totalPages, setTotalPages] = useState(1);
    const [searchTerm, setSearchTerm] = useState('');
    const filteredList = listTest.filter(test => 
        test.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
    useEffect(() => {
        setListTest(tests.ltest);
        setTotalPages(Math.ceil(filteredList.length / itemsPerPage));
    }, [filteredList]);

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber);
    };

    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const currentItems = filteredList.slice(startIndex, endIndex);
    const handlefind = () => {

    }

    
    const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
        setCurrentPage(1); // Reset trang về 1 khi tìm kiếm
    };
    return (
        <div className="container">
            <div className="flex items-center justify-center">
                <input type="text" className="border rounded-tl-full rounded-bl-full w-1/3 p-2 focus:outline-none pl-4" placeholder="Type here..." onChange={handleSearchChange} />
                <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full " onClick={handlefind}>
                    <FaMagnifyingGlass />
                </button>
            </div>
            <div>
                <ul className="m-5 grid grid-cols-5 gap-4">
                    {currentItems.map((test, index) => (
                        <li key={index} className="border border-inherit rounded-md h-fit">
                            <div className="mx-5 mt-3 mb-5">
                                <div>
                                    <h2 className="text-xl">{test.name}</h2>
                                </div>
                                <div className="mb-2">
                                    <div>{test.time} phút | {test["Number of Questions"]} câu hỏi | {test.students} học sinh</div>
                                </div>
                                <div className="h-2/5 flex justify-center items-center">
                                    <div className="bg-white px-10 py-2 border border-main-color rounded-lg">
                                        <a href="/#" className="">Làm bài</a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    ))}
                </ul>
                <div className="pagination-container flex justify-center mt-4">
                    <div
                        className={`pagination-nav ${currentPage === 1 ? 'disabled' : ''} cursor-pointer`}
                        onClick={() => handlePageChange(currentPage - 1)}
                    >
                        {"<<"}
                    </div>
                    {Array.from({ length: totalPages }, (_, index) => (
                        <div
                            key={index}
                            className={`page-item ${index + 1 === currentPage ? 'bg-blue-500 text-white' : 'bg-gray-200 text-black'} mx-1 px-3 py-1 rounded cursor-pointer`}
                            onClick={() => handlePageChange(index + 1)}
                        >
                            {index + 1}
                        </div>
                    ))}
                    <div
                        className={`pagination-nav ${currentPage === totalPages ? 'disabled' : ''} cursor-pointer`}
                        onClick={() => handlePageChange(currentPage + 1)}
                    >
                        {">>"}
                    </div>
                </div>
            </div>

        </div>
    );
}
