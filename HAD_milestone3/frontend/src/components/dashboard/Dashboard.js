import "./dashboard.css"
import React from "react";
import Read from "../Read/Read";
import Create from "../Create/Create"
import {BrowserRouter, Route, Routes,  Link, useNavigate} from 'react-router-dom';
import Home from "../../Home";

const Dashboard = ( ) => {
    const navigate = useNavigate();
    const handleClickCreate = () => {
        navigate('/Dashborad/Create');

    }

    const handleClickRead = () => {
        navigate('/Dashboard/Display');

    }

    const handleClickUpdate = () => {
            navigate('/Dashboard/Update');
    }
    const handleClickDelete = () => {
            navigate('/Dashboard/Remove');
    }

        return (
        <div className="header">
            <div className="d-flex flex-column">
                <br></br>
                <br></br>
            <div>
                <h1>WELCOME TO  ADMIN'S DASHBOARD</h1>
            </div>
                <br></br>
                <br></br>
                <br></br>
                <br></br>

            <div style={{
                justifyContent: "center",
                alignItems: "center",
            }}>
            <button type='submit' id='login-submit' className="button login__submit" onClick={handleClickCreate}>
                <span className="button__text">Register Employees Details</span>
                <i className="button__icon fas fa-chevron-right"></i>
            </button>
            <button type='submit' id='login-submit' className="button login__submit" onClick={handleClickRead}>
                <span className="button__text">Display Employee Details</span>
                <i className="button__icon fas fa-chevron-right"></i>
            </button>
            <button type='submit' id='login-submit' className="button login__submit"onClick={handleClickUpdate}>
                <span className="button__text">Update Employee Details</span>
                <i className="button__icon fas fa-chevron-right"></i>
            </button>

                <button type='submit' id='login-submit' className="button login__submit" onClick={handleClickDelete}>
                    <span className="button__text">Delete Employee Details</span>
                    <i className="button__icon fas fa-chevron-right"></i>
                </button>
            </div>
            </div>
        </div>
    );
};
export default Dashboard;
