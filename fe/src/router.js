import { Route, Routes } from "react-router-dom"
import { ROUTERS } from "./utils/router"
import MasterLayout from "./pages/user/masterLayout.js"
import Login from "./pages/user/login"
import Register from "./pages/user/register"
import CourseInfo from "./pages/user/courseinfo.js"
import Courses from "./pages/user/courses"
import Test from "./pages/user/test"
import MasterLayoutAdmin from "./pages/admin/masterLayoutAdmin"
import Tests from "./pages/user/tests"
import CourseLearn from "./pages/user/courseLearn.js"
import Exercises from "./pages/user/Exercises.js"
import Home from "./pages/user/home"
const renderRouter = ({ role }) => {

    const userRouters = [
        {
            path: ROUTERS.USER.HOME,
            element: <Home/>
        },
        {
            path: ROUTERS.USER.LOGIN,
            element: <Login />,
        },
        {
            path: ROUTERS.USER.REGISTER,
            element: <Register />
        },
        {
            path: ROUTERS.USER.COURSEINFO,
            element: <CourseInfo />
        },
        {
            path: ROUTERS.USER.COURSES,
            element: <Courses />
        },
        {
            path: ROUTERS.USER.EXERCISES,
            element: <Exercises />
        },
        {
            path: ROUTERS.USER.TEST,
            element: <Test />
        },
        {
            path: ROUTERS.USER.TESTS,
            element: <Tests />
        },
        {
            path: ROUTERS.USER.COURSELEARN,
            element: <CourseLearn/>
        }
    ]

    const adminRouters = [
        {
            path: ROUTERS.ADMIN.HOME,
            element: <MasterLayoutAdmin />,
        },
    ]

    return (
        <>
            {role === 'ADMIN' ? (
                <Routes>
                    {adminRouters.map((item, key) => (
                        <Route key={key} path={item.path} element={item.element} />
                    ))}
                </Routes>
            ) : (
                <MasterLayout>
                    <Routes>
                        {userRouters.map((item, key) => (
                            <Route key={key} path={item.path} element={item.element} />
                        ))}
                        
                        <Route path={ROUTERS.AUTHEN.LOGIN} element={<Login />} />
                        <Route path={ROUTERS.AUTHEN.REGISTER} element={<Register />} />
                    </Routes>
                </MasterLayout>

            )}
        </>
    );
};

const RouterCustom = ({ role }) => {
    return (
        renderRouter({ role })
    );
};

export default RouterCustom
