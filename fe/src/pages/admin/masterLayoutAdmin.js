import { Routes, Route } from "react-router-dom";
import Nav from "./nav";
import Dashboard from "./dashboard";
import Account from "./account"
import Sidebar from "./sidebar";
import Courses from "./courses";
import Vocab from "./vocab";
import Question from "./question"
export default function MasterLayoutAdmin() {
    return (
        <div className="flex ">
            <div className="basis-1/6">
                <Nav />
            </div>
            <div className="basis-5/6">
                <Sidebar />
                <Routes>
                    <Route path="/" element={<Dashboard />} />
                    <Route path="/dashboard" element={<Dashboard />} />
                    <Route path="/accounts" element={<Account />} />
                    <Route path="/questions" element={<Question />} />
                    <Route path="/courses" element={<Courses />} />
                    <Route path="/vocabulary" element={<Vocab />} />
                </Routes>
            </div>
        </div>
    )
}