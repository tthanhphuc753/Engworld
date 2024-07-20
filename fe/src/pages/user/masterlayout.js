
import { useState, useEffect } from "react";
import Cookies from "universal-cookie";
import { TokenProvider } from "../../tokenContext";
import { Route, Router, Routes } from "react-router-dom";
import App from "./home";
import Login from "./login";
import Header from "./header";
import Footer from "./footer";
export default function MasterLayout({ children, ...props }) {
  const [token, setToken] = useState()
  const cookies = new Cookies()
  useEffect(() => {
    const tokenExists = cookies.get('token');
    if (tokenExists) {
      setToken(tokenExists);
    }
  }, []);

  return (
    <div className="max-w-full text-base mx-auto" {...props}>

      <Header />
      <div className="flex justify-center min-h-full">
        <TokenProvider token={token}>

        {children}
        </TokenProvider>
      </div>
      <Footer/>
    </div>
  )
}