import React from 'react';
import { useState, useEffect } from 'react';
import { FaMagnifyingGlass } from "react-icons/fa6";
import { clientGetAllCourses } from '../../service';
import { Link } from 'react-router-dom';

export default function Courses() {
    const itemsPerPage = 20; // Số item mỗi trang
    const [listCourse, setListCourses] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [totalPages, setTotalPages] = useState(1);
    const [searchTerm, setSearchTerm] = useState('');
    const filteredList = listCourse.filter(course => 
        course.courseName.toLowerCase().includes(searchTerm.toLowerCase())
    );
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await clientGetAllCourses();
                setListCourses(response.data.content);
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        };

        fetchData();
        setTotalPages(Math.ceil(filteredList.length / itemsPerPage));
    }, []);

   

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber);
    };

    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = Math.min(startIndex + itemsPerPage, listCourse.length);
    const currentItems = filteredList.slice(startIndex, endIndex);

    const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
        setCurrentPage(1); // Reset trang về 1 khi tìm kiếm
    };
    return (
        <div>
            <div className="flex items-center justify-center">
                <input type="text" className="border rounded-tl-full rounded-bl-full w-1/3 p-2 focus:outline-none pl-4" placeholder="Type here..." onChange={handleSearchChange} />
                <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full " >
                    <FaMagnifyingGlass />
                </button>
            </div>
            <div>
                <ul className="m-5 grid grid-cols-5 gap-4">
                    {currentItems.map((course) => (
                        <li key={course.courseId} className="flex flex-col w-56 bg-white text-main-color rounded-md cursor-pointer">
                            <Link to={`/courseinfo/${course.courseId}`}>
                                <div className="">
                                    <img className="w-full h-full rounded-md" src={`https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg`} alt="course" />
                                </div>
                                <div className="text-sm">
                                    <p>{course.courseName}</p>
                                </div>
                                <div className="course-prices text-sm text-orange-600">
                                    <span className="course-price">{`699.000đ`}</span>
                                    <span className="ml-1 course-listing-price">
                                        <s className="decoration-black">{`899.000đ`}</s>
                                    </span>
                                    <span className="ml-2 badge badge-danger badge-lg text-red-600">{`-22%`}</span>
                                </div>
                            </Link>
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

