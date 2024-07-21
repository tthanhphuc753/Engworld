import { useState, useEffect } from "react";
import Cookies from "universal-cookie";
const ltests = [
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
]

const lcourses = [
  {
    id: 1,
    title: '1[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '2[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '2[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
  },
  // Thêm nhiều khóa học khác ở đây
  // ...
];
export default function Home() {
  const cookies = new Cookies()
  const { token, setToken } = useState("aaa");
  const [soluongkhoahoc, setSoluongkhoahoc] = useState(1)
  const [soLuongDeDaLuyen, setSoLuongDeDaLuyen] = useState(1)
  const [courses, setCourses] = useState([])
  const [tests, setTests] = useState([])
  useEffect(() => {
    setCourses(lcourses.slice(0, 3))
    setTests(ltests.slice(0, 8))
  }, [])
  return (
    <div className="max-w-full text-base mx-auto">
      <div className="flex flex-col items-center">
        {token ? <div className="container mx-5">
          <div>
            <p className="text-3xl text-main-color font-medium">
              Xin chào {cookies.get('username')}
            </p>
          </div>
          <div>
            <p className="text-main-color text-xl font-medium">
              Các khóa học của bạn
            </p>
            {soluongkhoahoc > 0 ? (<ul className="m-5 flex flex-row justify-between">

              <li className="flex flex-col w-56 bg-white text-main-color rounded-md cursor-pointer">
                <div className="">
                  <img className="w-full h-full rounded-md" src="https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg" alt="art" />
                </div>
                <div className=" text-sm">
                  <p>
                    [IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết
                  </p>
                </div>
                <div className="course-prices  text-sm text-orange-600">
                  <span className="course-price">699.000đ</span>
                  <span className="ml-1 course-listing-price"><s className="decoration-black">899.000đ</s></span>
                  <span className="ml-2 badge badge-danger badge-lg text-red-600">-22%</span>
                </div>
              </li>
              <li className="flex flex-col w-56 bg-white text-main-color rounded-md cursor-pointer">
                <div className="">
                  <img className="w-full h-full rounded-md" src="https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg" alt="art" />
                </div>
                <div className=" text-sm">
                  <p>
                    [IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết
                  </p>
                </div>
                <div className="course-prices  text-sm text-orange-600">
                  <span className="course-price">699.000đ</span>
                  <span className="ml-1 course-listing-price"><s className="decoration-black">899.000đ</s></span>
                  <span className="ml-2 badge badge-danger badge-lg text-red-600">-22%</span>
                </div>
              </li>
              <li className="flex flex-col w-56 bg-white text-main-color rounded-md cursor-pointer">
                <div className="">
                  <img className="w-full h-full rounded-md" src="https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg" alt="art" />
                </div>
                <div className=" text-sm">
                  <p>
                    [IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết
                  </p>
                </div>
                <div className="course-prices  text-sm text-orange-600">
                  <span className="course-price">699.000đ</span>
                  <span className="ml-1 course-listing-price"><s className="decoration-black">899.000đ</s></span>
                  <span className="ml-2 badge badge-danger badge-lg text-red-600">-22%</span>
                </div>
              </li>
              <li className="flex flex-col w-56 bg-white text-main-color rounded-md cursor-pointer">
                <div className="">
                  <img className="w-full h-full rounded-md" src="https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg" alt="art" />
                </div>
                <div className=" text-sm">
                  <p>
                    [IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết
                  </p>
                </div>
                <div className="course-prices  text-sm text-orange-600">
                  <span className="course-price">699.000đ</span>
                  <span className="ml-1 course-listing-price"><s className="decoration-black">899.000đ</s></span>
                  <span className="ml-2 badge badge-danger badge-lg text-red-600">-22%</span>
                </div>
              </li>
            </ul>) : <div className="m-5">Ban chua dang ky khoa hoc nao</div>}
          </div>
          <div>
            <p className="text-main-color text-xl font-medium">
              Kết quả luyện thi
            </p>
            {soLuongDeDaLuyen > 0 ? (<ul className="m-5 flex flex-row justify-between">
              <li className="border border-inherit rounded-md max-w-60">
                <div className="m-3">
                  <div className="text-center text-lg font-medium">Đề 1</div>
                  <div>Ngày làm bài: 16/07/2024</div>
                  <div>Thời gian hoàn thành: 0:40:00</div>
                  <div>Kết quả: 40/40</div>
                  <a href="/#">Xem chi tiết</a>
                </div>
              </li>
              <li className="border border-inherit rounded-md max-w-60">
                <div className="m-3">
                  <div className="text-center text-lg font-medium">Đề 2</div>
                  <div>Ngày làm bài: 17/07/2024</div>
                  <div>Thời gian hoàn thành: 0:40:00</div>
                  <div>Kết quả: 40/40</div>
                  <a href="/#">Xem chi tiết</a>
                </div>
              </li>
              <li className="border border-inherit rounded-md max-w-60">
                <div className="m-3">
                  <div className="text-center text-lg font-medium">Đề 3</div>
                  <div>Ngày làm bài: 18/07/2024</div>
                  <div>Thời gian hoàn thành: 0:40:00</div>
                  <div>Kết quả: 40/40</div>
                  <a href="/#">Xem chi tiết</a>
                </div>
              </li>
              <li className="border border-inherit rounded-md max-w-60">
                <div className="m-3">
                  <div className="text-center text-lg font-medium">Đề 4</div>
                  <div>Ngày làm bài: 19/07/2024</div>
                  <div>Thời gian hoàn thành: 0:40:00</div>
                  <div>Kết quả: 40/40</div>
                  <a href="/#">Xem chi tiết</a>
                </div>
              </li>
            </ul>) : <div className="m-3">Bạn chưa luyện đề</div>}
            {soLuongDeDaLuyen > 4 ? (<a href="/#">tat ca</a>) : null}

          </div>
        </div> : null}
        {/* ----------------------------------------------------------------------------------------------------------------------------------------------- */}
        <div className="khoahoc w-full bg-white h-96 flex flex-col text-main-color">
          <p className=" text-xl basis-1/6 flex justify-center items-center">
            Các khóa học nổi bật
          </p>
          <ul className="flex flex-row basis-5/6 justify-center">
            {courses.map((course, index) => (
              <li key={index} className="flex flex-col w-56 mr-5 bg-white text-main-color rounded-md cursor-pointer">
                <div className="">
                  <img className="w-full h-full rounded-md" src={course.image} alt="art" />
                </div>
                <div className=" text-sm">
                  <p>
                    {course.title}
                    {/* [IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết */}
                  </p>
                </div>
                <div className="course-prices  text-sm text-orange-600">
                  <span className="course-price">{course.price}</span>
                  <span className="ml-1 course-listing-price"><s className="decoration-black">{course.originalPrice}</s></span>
                  <span className="ml-2 badge badge-danger badge-lg text-red-600">{course.discount}</span>
                </div>
              </li>
            ))}
          </ul>
        </div>
        {/* ----------------------------------------------------------------------------------------------------------------------------------------- */}
        <div className="dethi w-full bg-white h-96 flex flex-col text-main-color items-center mb-5">
          <p className="text-xl basis-1/6 flex justify-center items-center">Đề thi mới nhất</p>
          <ul className="grid grid-rows-2 grid-flow-col gap-4 basis-5/6">
          {tests.map((test,index)=>(
            <li key={index} className="border border-inherit rounded-md">
            <div className=" mx-5 mt-3 mb-5">
              <div className="">
                <h2 className="">
                  {test.name}
                  {/* IELTS Simulation Listening test 1 */}
                </h2>
              </div>
              <div className="">
                <div>{test.time} phút | {test["Number of Question"]} câu hỏi | {test.students}</div>
              </div>
            </div>
            <div className="h-2/5 flex justify-center items-center">
              <div className="bg-white px-10 py-2 border border-main-color rounded-lg">

                <a href="/#" className="">Làm bài</a>
              </div>
            </div>
          </li>
          ))}
          </ul>
        </div>
        {/* -------------------------------------------------------------------------------------------------------------------- */}
        {/* <div className="topic h-52 text-main-color flex flex-col items-center">
          <div className="text-xl basis-2/6 flex justify-center items-center">
            Học từ vựng theo từng chủ đề
          </div>
          <ul className="grid grid-rows-2 grid-flow-col gap-4 basis-4/6">
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">
                Gia đình
              </a>
            </li>
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">

                nghề nghiệp
              </a>
            </li>
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">

                Văn hóa
              </a>
            </li>
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">

                Ẩm thực
              </a>
            </li>
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">

                Sức khỏe
              </a>
            </li>
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">

                Công nghệ
              </a>
            </li>
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">

                Thời trang
              </a>
            </li>
            <li className="w-28 border border-main-color rounded-md flex justify-center items-center ">
              <a href="/#">

                Giá dục
              </a>
            </li>
          </ul>
        </div> */}
        {/* ---------------------------------------------------------------------------------------------------------------- */}
      </div>

    </div>
  )
}

