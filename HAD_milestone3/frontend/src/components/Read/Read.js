
//do a submit handle with emp id as arg to read/display

import React, {useState} from 'react';
import {useNavigate} from "react-router-dom"
import Display from "../../Display";

const Read = ({ startDisplay }) => {
    // States for tracking form input which are the email address and password
    const [ empid, setempid ] = useState('')

    const handleRead = (event) => {
        event.preventDefault()
        console.log("handling read")
        startDisplay(empid)
        setempid('')

    }

    return (
     <div className="header">
         <div className="d-flex flex-column">
             <h1>Enter the ID of the Employee to Display his/her Details</h1><br />
             <form  id='dash-form' className="login" onSubmit={handleRead} >
             <div className="login__field">

                 <input className="login__input"
                        value={empid}
                        onChange={event => setempid(event.target.value)}
                        type='text'
                        placeholder='ENTER EMPLOYEEID'
                        id='empid'
                        required
                 />
                 <div className="center">
                     <button type='submit' id='dsah-submit' className="login__submit">
                         <span className="button__text">Display</span>
                         <i className="button__icon fas fa-chevron-right"></i>
                     </button>
                 </div>
             </div>

         </form>
         </div>
     </div>
    )
};
export default Read;
