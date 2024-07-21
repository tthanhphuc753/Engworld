import Nav from "./nav"
import Sidebar from "./sidebar"
import { Routes, Route } from "react-router-dom"
import Dashboard from "./dashboard"
import Accounts from "./accounts"
import Questions from "./questions"
import Courses from "./courses"
import Vocabulary from "./vocab"
export default function MasterLayoutAdmin() {
    return (
        <div className="flex">
            <div className="basis-1/6">

                <Nav />
            </div>
            <div className="basis-5/6">
                <Sidebar />
                <Routes>
                    <Route path="/" element={<Dashboard />} />
                    <Route path="/dashboard" element={<Dashboard/>}/>
                    <Route path="/accounts" element ={<Accounts/>} />
                    <Route path="/questions" element={<Questions/>} />
                    <Route path="/courses" element={<Courses/>} />
                    <Route path="/vocabulary" element={<Vocabulary/>} />
                </Routes>
            </div>
        </div>
    )
}