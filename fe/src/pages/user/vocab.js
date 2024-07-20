export default function Vocab() {
    return (
        <div className="container">
            <div className="flex justify-center text-base mt-5">
                <div className="container flex flex-col justify-center items-center">
                    <div className="">
                        <p className="text-2xl underline">Chủ đề: giáo dục</p>
                    </div>
                    <ul className="w-2/3">
                        <li className="flex flex-col pb-2 relative after:absolute after:w-full after:bg-main-color after:h-0.5 after:bottom-0 after:left-0">
                            <p className="mr-3 text-3xl">vocabulary</p>
                            <p className="mr-3">/vəˈkæb.jə.lər.i/</p>
                            <p className="">noun</p>
                            <p className="">truong hoc</p>
                            <p>The English language is rich in vocabulary.</p>
                        </li>
                        <li className="flex flex-col pb-2 relative after:absolute after:w-full after:bg-main-color after:h-0.5 after:bottom-0 after:left-0">
                            <p className="mr-3 text-3xl">school</p>
                            <p className="mr-3">/skuːl/</p>
                            <p className="">noun</p>
                            <p className="">truong hoc</p>
                            <p>The behaviour of this school in public is sometimes not very good.
                            </p>
                        </li>
                        <li className="flex flex-col pb-2 relative after:absolute after:w-full after:bg-main-color after:h-0.5 after:bottom-0 after:left-0">
                            <p className="mr-3 text-3xl">teacher</p>
                            <p className="mr-3">/tˈiːt͡ʃɚ/</p>
                            <p className="">noun</p>
                            <p className="">giáo viên</p>
                            <p>The English language is rich in vocabulary.</p>
                        </li>
                        <li className="flex flex-col pb-2 relative after:absolute after:w-full after:bg-main-color after:h-0.5 after:bottom-0 after:left-0">
                            <p className="mr-3 text-3xl">student</p>
                            <p className="mr-3">/ˈstjuːdənt/</p>
                            <p className="">noun</p>
                            <p className="">hoc sinh</p>
                            <p>She is a student nurse/teacher</p>
                        </li>
                        <li className="flex flex-col pb-2 ">
                            <p className="mr-3 text-3xl">classmate</p>
                            <p className="mr-3">/klˈæsme͡ɪt/</p>
                            <p className="">noun</p>
                            <p className="">bạn cùng lớp</p>
                            <p>The two men were classmates back in the 1970s.</p>
                        </li>
                    </ul>
                    <div className="flex">
                        <div className="mr-1">{'<<'}</div>
                        <div className="mr-1">1</div>
                        <div className="mr-1">2</div>
                        <div className="mr-1">3</div>
                        <div >{'>>'}</div>
                    </div>
                </div>
            </div>
        </div>
    )
}