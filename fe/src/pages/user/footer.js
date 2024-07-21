import { FaFacebook } from "react-icons/fa";
import { FaInstagramSquare } from "react-icons/fa";
import { FaSquareXTwitter } from "react-icons/fa6";
import { FaLinkedin } from "react-icons/fa";
import { FaTiktok } from "react-icons/fa";
export default function Footer() {
    return (
        <div className="">
            <ul className="flex w-full justify-between gap-16">
                <li>
                    <p className="text-2xl">E-Learning</p>
                    <div className="flex justify-center gap-1">
                        <FaFacebook />
                        <FaInstagramSquare />
                        <FaSquareXTwitter />
                        <FaLinkedin />
                        <FaTiktok />
                    </div>
                </li>
                <li>
                    <p className="font-medium">Chương trình học</p>
                    <p>IELTS</p>
                    <p>TOEIC</p>
                </li>
                <li>
                    <p className="font-medium">Tài nguyên</p>
                    <p>Thư viện đề thi</p>
                </li>
                <li>
                    <p className="font-medium">Hỗ trợ</p>
                    <p>Hướng dẫn sử dụng</p>
                    <p>Hướng dẫn mua hàng</p>
                    <p>Chăm sóc khách hàng</p>
                </li>
                <li>
                    <p className="font-medium text-xl">E-Learning</p>
                    <p>Về chúng tôi</p>
                    <p>Liên hệ</p>
                    <p>Điều khoản bảo mật</p>
                    <p>Điều khoản sử dụng</p>
                </li>

            </ul>
        </div>
    )
}