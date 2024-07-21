import { FaMagnifyingGlass } from "react-icons/fa6";
import { useState, useEffect } from "react";
import { getAllCourses, deleteCourse, uploadCoursesFile } from "../../service";
// const courses = [
//     {
//         id: 1,
//         title: '1[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '2[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '2[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     {
//         id: 1,
//         title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
//         image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
//         price: '699.000đ',
//         originalPrice: '899.000đ',
//         discount: '-22%'
//     },
//     // Thêm nhiều khóa học khác ở đây
//     // ...
// ];
export default function Courses() {
  const [courses, setCourses] = useState([]);
  const [filteredCourses, setFilteredCourses] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [showForm, setShowForm] = useState(false); // State để điều khiển hiển thị form
  const [selectedFile, setSelectedFile] = useState(null); // State để lưu file Excel được chọn

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getAllCourses();
        setCourses(response.data.content);
        setFilteredCourses(response.data.content);
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
    const filtered = courses.filter(item =>
      item.vocabWord.toLowerCase().includes(searchTerm.toLowerCase()) ||
      item.topicName.toLowerCase().includes(searchTerm.toLowerCase()) ||
      item.vocabMeaning.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setFilteredCourses(filtered);
  };

  const handleDelete = async (id) => {
    try {
      const response = await deleteCourse(id);
      if (response.status === 200) {
        console.log('Delete successful');
        const updatedVocabulary = courses.filter(item => item.vocabId !== id);
        setCourses(updatedVocabulary);
        setFilteredCourses(updatedVocabulary);
      } else {
        console.log('Delete failed:', response.statusText);
      }
    } catch (error) {
      console.error('Error deleting vocabulary:', error);
    }
  };

  const handleAdd = () => {
    setShowForm(true); // Hiển thị form khi nhấn nút Add
  };

  const handleCloseForm = () => {
    setShowForm(false); // Đóng form
  };

  const handleSubmitForm = (formData) => {
    console.log('Form data:', formData);
    // Xử lý logic thêm từ vựng từ formData
    setShowForm(false); // Đóng form sau khi thêm thành công
  };

  const handleFileChange = (e) => {
    setSelectedFile(e.target.files[0]); // Lưu file Excel được chọn vào state
  };

  const handleUploadFile = async () => {
    if (!selectedFile) {
      console.log('Please select a file.');
      return;
    }

    try {
      const formData = new FormData();
      formData.append('file', selectedFile);

      const response = await uploadCoursesFile(formData);
      console.log('Upload successful:', response.data);

      // Sau khi upload thành công, có thể cập nhật lại danh sách từ vựng
      // Ví dụ:
      // const updatedVocabulary = [...vocabulary, ...response.data];
      // setVocabulary(updatedVocabulary);
      // setFilteredVocabulary(updatedVocabulary);

      setSelectedFile(null); // Đặt lại selectedFile về null sau khi hoàn thành
    } catch (error) {
      console.error('Error uploading file:', error);
    }
  };

  return (
    <div>
      <div className="flex flex-col justify-center items-center m-5">
        <div className="flex items-center justify-center w-full mb-5">
          <input type="text" className="border border-e-0 rounded-tl-full rounded-bl-full w-1/3 p-2 focus:outline-none pl-4" placeholder="Type here..." onChange={handleSearchChange} />
          <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full " onClick={handleFind}>
            <FaMagnifyingGlass />
          </button>
          <button className="bg-blue-500 text-white py-2 px-10 border rounded-full" onClick={handleAdd}>
            Add
          </button>
          {/* Upload file form */}
          <div className=" flex flex-row justify-center items-center">
            <input type="file" onChange={handleFileChange} />
            <button className="bg-blue-500 text-white py-2 px-4 rounded-full ml-2" onClick={handleUploadFile}>Upload File</button>
          </div>
        </div>
        <table className=" border">
          <thead>
            <tr>
              <th className="border">Name</th>
              <th className="border">image</th>
              <th className="border">price</th>
              <th className="border">originalPrice</th>
              <th className="border">discount</th>
              <th className="border">Path Video</th>
              <th className="border">Description</th>
              <th className="border">Level</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {filteredCourses.map((course, index) => (
              <tr key={index}>
                <td className="border">{course.courseName}</td>
                <td className="border">{course.image}</td>
                <td className="border">{course.price}</td>
                <td className="border">{course.originalPrice}</td>
                <td className="border">{course.discount}</td>
                <td className="border">Video path</td>
                <td className="border">{course.courseDes}</td>
                <td className="border">{course.courseLevel}</td>
                <td className="border">
                  <button className="bg-red-500 text-white mx-4 py-2 px-4 rounded-full" onClick={() => handleDelete(course.courseId)}>delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      {/* Form để thêm từ vựng */}
      {showForm && (
        <CourseForm onClose={handleCloseForm} onSubmit={handleSubmitForm} />
      )}

    </div>
  )
}


function CourseForm({ onClose, onSubmit }) {
  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = {
      courseName: e.target.elements.courseName.value,
      courseLevel: e.target.elements.courseLevel.value,
      CourseDes: e.target.elements.courseDes.value,
    };
    onSubmit(formData);
  };

  return (
    <div className="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-gray-300 bg-opacity-75 z-50">
      <div className="bg-white p-8 rounded-lg shadow-lg w-1/2">
        <h2 className="text-lg font-bold mb-4">Add Vocabulary</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="vocabWord">Course Name</label>
            <input className="border w-full p-2" type="text" id="courseName" name="courseName" required />
          </div>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="gern">Course Level</label>
            <input className="border w-full p-2" type="text" id="courseLevel" name="courseLevel" />
          </div>
          <div className="mb-4">
            <label className="block mb-1" htmlFor="vocabIPA">Course Description</label>
            <input className="border w-full p-2" type="text" id="courseDes" name="courseDes" />
          </div>
          <div className="flex justify-end">
            <button type="submit" className="bg-blue-500 text-white py-2 px-4 rounded mr-2">Add</button>
            <button type="button" className="bg-gray-400 text-white py-2 px-4 rounded" onClick={onClose}>Cancel</button>
          </div>
        </form>
      </div>
    </div>
  );
}