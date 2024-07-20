export default function CourseInfo() {
    return (
        <div className="flex flex-row container">
            <div className="mx-10 min-h- basis-2/3">
                <ul className="mb-3">
                    <li className="text-2xl font-bold">Toic 600: Từ Vựng + ngữ pháp + chiến lược làm bài</li>
                    <li className="italic">111 học viên</li>
                </ul>
                <div className="border mb-3">
                    <ul className="m-3">
                        <li className="text-xl mb-3 font-bold">Bạn sẽ đạt được gì?</li>
                        <li className="italic">Đạt mục tiêu tối thiểu 7.0 trong IELTS Reading General Training</li>
                        <li className="italic">Hiểu rõ phương pháp làm các dạng câu hỏi có trong IELTS Reading General Training</li>
                        <li className="italic">Nắm trọn 3000 từ vựng xuất hiện nhiều trong phần thi IELTS Reading General Training</li>
                        <li className="italic">Nắm vững ngữ cảnh sử dụng từ vựng học thuật, phục vụ cho IELTS Writing</li>
                    </ul>
                </div>
                <ul className="mb-3">
                    <li className="text-xl font-bold mb-3">Thông tin khóa học</li>
                    <li className="border">
                        <ul className="m-3">
                            <li className="text-lg font-bold ">
                                Bạn sẽ học như thế nào?
                            </li>
                            <li className="font-medium">
                                1. Chiến lược làm bài và video chữa đề chi tiết
                            </li>
                            <li className="italic">
                                Khóa học cung cấp video bài giảng hướng dẫn chi tiết cách làm từng dạng câu hỏi trong IELTS Reading và hơn 150h clip chữa đề chi tiết tất cả các câu hỏi trong nhiều bộ đề.
                            </li>
                            <li className="font-medium">
                                2. Từ vựng IELTS General Training tổng hợp
                            </li>
                            <li className="italic">
                                Mỗi bài đọc đều có highlight từ mới kèm nghĩa. Ngoài ra khóa học cung cấp bộ flashcards kèm phiên âm, audio, câu ví dụ để dễ dàng ôn tập theo phương pháp spaced-repetition review (lặp lại ngắt quãng).
                            </li>
                            <li className="font-medium">
                                3. Thực hành từ vựng mỗi ngày
                            </li>
                            <li className="italic">
                                Bên cạnh việc học từ vựng với bộ flashcards, bạn có thể luyện tập với các bài tập mini-game như trắc nghiệm, tìm cặp, nghe điền từ, chính tả.
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul>
                    <li className="text-xl mb-3 font-bold">Chương trình học</li>
                    <ul className="ml-3">
                        <li className="italic">Từ vựng</li>
                        <li className="italic">Ngữ pháp</li>
                        <li className="italic">Luyện đề</li>
                    </ul>
                </ul>
            </div>
            <div className="basis-1/3 max-w-80">
                <ul className=" max-w-80 border rounded-lg">
                    <li className="max-h-40 overflow-hidden flex justify-center items-center">
                    <img className="w-full h-full rounded-md" src="https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg" alt="art" />
                    </li>
                    <li>
                        <p className="mx-3">Toic 600: Từ vựng + ngữ pháp + chiến lược làm bài</p>
                    </li>
                    <li>
                        <p className="mx-3">
                            600.000đ
                        </p>
                    </li>
                    <li className="flex justify-center">
                        <button className="w-60 py-2 bg-main-color text-white border rounded-lg">Đăng ký</button>
                    </li>
                    <li>
                        <p className="mx-3 italic">
                            111 học viên
                        </p>
                    </li>
                </ul>
            </div>
        </div>
    )
}