import deleteService from "./components/Services/crudService";
import Read from "./components/Read/Read";
import { useState, useEffect } from 'react'
import Delete from "./components/Delete/Delete";
import AdminNotification from "./components/Admin_login/adminNotification";
import AdminLogin from "./components/Admin_login/adminLogin";
import Dashboard from "./components/dashboard/Dashboard";
import "./components/Admin_login/login.css";
import {useNavigate} from "react-router-dom";
import Table from "./components/Read/Table";
const Display = () => {
    const [ deleteStatus, setdeleteStatus ] = useState(null)
    const readStat = {}
    const navigate = useNavigate();
    const handleDelete = async (empid) => {
        try{
            setdeleteStatus(null)
            const deleteObject = await deleteService.deleteService(empid)
            //console.log(deleteObject)
            setdeleteStatus(deleteObject)
            window.localStorage.setItem('deleteUser', JSON.stringify(deleteObject))
        }
        catch (exception){
            setdeleteStatus(null)
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
                deleteStatus==null &&
                <Delete startDelete={handleDelete}/>
            }
            {
                deleteStatus != null &&
               <div>
                   <h1>Employee Details Deleted Successfully!!!</h1>
               </div>
            }

        </div>
    )
}

export default Display;