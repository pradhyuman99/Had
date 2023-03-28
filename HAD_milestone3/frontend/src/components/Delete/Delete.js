import React, {useState} from 'react';
import {useNavigate} from "react-router-dom"
//import Remove from "../../Display";

const Delete = ( {startDelete} ) => {
    // States for tracking form input which are the email address and password
    const [ empid, setempid ] = useState('')

    const handleDelete = (event) => {
        event.preventDefault()
        console.log("handling delete")
        startDelete(empid)
        setempid('')
    }

    return (
        <div className="header">
            <div className="d-flex flex-column">
                <h1>Enter the ID of the Employee to Delete his/her Details</h1><br />
                <form  id='dash-form' className="login" onSubmit={handleDelete} >
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
                                <span className="button__text">Delete</span>
                                <i className="button__icon fas fa-chevron-right"></i>
                            </button>
                        </div>
                    </div>

                </form>
            </div>

        </div>
    )
};
export default Delete;
