import { FaFacebook } from "react-icons/fa";
import { FaInstagramSquare } from "react-icons/fa";
import { FaTiktok } from "react-icons/fa";
import { BsTwitterX } from "react-icons/bs";
export default function Footer(){
    return (
        <footer className="text-main-color flex flex-col justify-center items-center mt-4 border border-t-2">
        <ul className="flex flex-row max-w-5xl justify-around w-full">
          <li>
            E-Learning
            <ul className="flex flex-row">
              <li>
                <FaFacebook />
              </li>
              <li>
                <FaInstagramSquare />
              </li>
              <li>
                <FaTiktok />
              </li>
              <li>
                <BsTwitterX />
              </li>
            </ul>
          </li>
          <li>
            KHóa học online
            <ul>

              <li>
                Khóa học 1
              </li>
              <li>
                Khóa học 2
              </li>
            </ul>
          </li>
          <li>
            Tài nguyên
            <ul>
              <li>
                Thư viện đề thi
              </li>
            </ul>
          </li>
          <li>
            Hỗ trợ
            <ul>
              <li>
                Hướng đãn sử dụng
              </li>
              <li>
                Hướng đãn mua hàng
              </li>
              <li>
                Chăm sóc khách hàng
              </li>
            </ul>
          </li>
          <li>
            e-learning
            <ul>
              <li>
                Liên hệ
              </li>
              <li>
                Điều khoản thanh toán
              </li>
            </ul>
          </li>
        </ul>
        <ul>
          <li>Thông tin doanh nghiệp</li>
        </ul>
      </footer>
    )
}