import { useState, useEffect } from 'react'
import loginService from "./components/Services/crudService";
import AdminNotification from "./components/Admin_login/adminNotification";
import AdminLogin from "./components/Admin_login/adminLogin";
import Dashboard from "./components/dashboard/Dashboard";
import "./components/Admin_login/login.css";
import { BrowserRouter , Routes, Route } from 'react-router-dom';
import Home from "./Home";
import Read from "./components/Read/Read";
import Display from "./Display";
import Table from "./components/Read/Table";
import Remove from "./Remove";
import Delete from "./components/Delete/Delete";
import Update from "./components/Update/Update"

const App = () => {


    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />}>
                </Route>
                <Route path="/Dashboard" element={<Dashboard />}>
                </Route>
                <Route path="/Dashboard/Display" element={<Display />}>
                </Route>
                <Route path="/Dashboard/Display/Read" element={<Read />}>
                </Route>
                <Route path="/Dashboard/Display/Table" element={<Table />}>
                </Route>
                <Route path="/Dashboard/Remove" element={<Remove />}>
                </Route>
                <Route path="/Dashboard/Remove/Delete" element={<Delete />}>
                </Route>
                <Route path="/Dashboard/Update" element={<Update />}>
                </Route>
            </Routes>
        </BrowserRouter>



    )
}

export default App;

