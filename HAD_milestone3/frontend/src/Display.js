import readService from "./components/Services/crudService";
import Read from "./components/Read/Read";
import { useState, useEffect } from 'react'
import AdminNotification from "./components/Admin_login/adminNotification";
import AdminLogin from "./components/Admin_login/adminLogin";
import Dashboard from "./components/dashboard/Dashboard";
import "./components/Admin_login/login.css";
import {useNavigate} from "react-router-dom";
import Table from "./components/Read/Table";


const Display = () => {
    const [ readStatus, setreadStatus ] = useState(null)
    //const readStat = {}
    const navigate = useNavigate();
    const handleRead = async (empid) => {
        try{
            setreadStatus(null)
            const readObject = await readService.readService(empid)
            setreadStatus(readObject)
            window.localStorage.setItem('loggedInUser', JSON.stringify(readObject))
        }
        catch (exception){
            setreadStatus(null)
        }

    }
    return (
        <div>
            {/* Header of the page */}
            <div className='text-center page-header p-1 regular-text-shadow no-border'>
                <div className='text-center center hshow font-weight-bold center' >
                    <div className='header'>
                        <h2>Hospital Management System</h2>
                    </div>
                </div>
            </div>
            <br></br>
            {
                readStatus==null &&
                <Read startDisplay={handleRead}/>
            }
            {
                /* Show Details of the Patient when login has happened */
                readStatus !== null &&
                <
                    Table Root={readStatus}
                />
            }

        </div>
    )
}

export default Display;