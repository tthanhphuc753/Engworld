import React from 'react';
import ReactDOM from 'react-dom/client';
import './styles/tailwind.css'
import { BrowserRouter } from 'react-router-dom'
import App from './App'
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <App />
    {/* <RouterCustom/> */}
    {/* <MasterLayoutAdmin Children={<Vocab/>}/> */}
  </BrowserRouter>
);