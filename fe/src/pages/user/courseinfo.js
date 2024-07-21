const course = {
    id: 1,
    title: '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết',
    image: 'https://thuthuatnhanh.com/wp-content/uploads/2021/11/Hinh-anh-cuon-sach-mo-ra-dep-nhat.jpg',
    price: '699.000đ',
    originalPrice: '899.000đ',
    discount: '-22%'
}
export default function CourseInfo() {
    return (
        <div className="m-5">
            {course && (
                <div className="bg-center text-blue-400 mb-5" style={{ backgroundImage: `url(${course.image})` }}>
                    <p className="text-xl ml-3">{course.title}</p>
                    <button className="py-2 px-5 bg-blue-400 text-white ml-3">Đăng ký</button>
                    <p className="italic ml-3">Dành cho các bạn từ band 4.0 trở lên target 7.0+ IELTS Reading General Training</p>
                    <p className="italic ml-3">10 giờ học video bài giảng và 150h clip chữa đề chi tiết các bộ đề thi chuẩn format thi thật</p>
                    <p className="italic ml-3">Nắm trọn 3000 từ vựng có xác suất 99% sẽ xuất hiện trong phần thi IELTS Reading General Training tổng hợp từ đề thi thật</p>
                </div>
            )}
            <ul className="border mb-5">
                <li className="m-3">
                    <p className="text-lg font-medium">Bạn sẽ đặt được gì sau khóa học này?</p>
                    <p className="italic">Đạt mục tiêu tối thiểu 7.0 trong IELTS Reading General Training</p>
                    <p className="italic">Hiểu rõ phương pháp làm các dạng câu hỏi có trong IELTS Reading General Training</p>
                    <p className="italic">Nắm trọn 3000 từ vựng xuất hiện nhiều trong phần thi IELTS Reading General Training</p>
                    <p className="italic">Nắm vững ngữ cảnh sử dụng từ vựng học thuật, phục vụ cho IELTS Writing</p>
                </li>
            </ul>
            <ul className="mb-5">
                <li className="ml-3">
                    <p className="text-xl font-medium mb-3">Thông tin khóa học</p>
                    <div className="ml-3">
                        <p className="text-xl font-medium mb-2">Bạn sẽ học như thế nào?</p>
                        <p className="font-medium"> 1. Chiến lược làm bài và video chữa đề chi tiết</p>
                        <p className="italic">Khóa học cung cấp video bài giảng hướng dẫn chi tiết cách làm từng dạng câu hỏi trong IELTS Reading và hơn 150h clip chữa đề chi tiết tất cả các câu hỏi trong nhiều bộ đề.</p>
                        <p className="font-medium">2. Từ vựng IELTS General Training tổng hợp</p>
                        <p className="italic">Mỗi bài đọc đều có highlight từ mới kèm nghĩa. Ngoài ra khóa học cung cấp bộ flashcards kèm phiên âm, audio, câu ví dụ để dễ dàng ôn tập theo phương pháp spaced-repetition review (lặp lại ngắt quãng).</p>
                        <p className="font-medium">3. Thực hành từ vựng mỗi ngày</p>
                        <p className="italic">Bên cạnh việc học từ vựng với bộ flashcards, bạn có thể luyện tập với các bài tập mini-game như trắc nghiệm, tìm cặp, nghe điền từ, chính tả.</p>
                    </div>
                </li>
            </ul>
            <ul>
                <li className="ml-3">
                    <p className="text-xl font-medium   ">Chương trình học</p>
                    <p className="italic">Từ vựng</p>
                    <p className="italic">Ngữ pháp</p>
                    <p className="italic">Làm test</p>
                </li>
            </ul>
        </div>
    )
}