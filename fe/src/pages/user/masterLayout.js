import Header from "./header";
import Footer from "./footer"
import React from 'react';
export default function MasterLayout({ children, ...props }) {
    return (
        <div {...props} className="flex flex-col justify-center items-center">
            <Header />
            <div className="container">

                {children}
            </div>
            <Footer />
        </div>
    )
}