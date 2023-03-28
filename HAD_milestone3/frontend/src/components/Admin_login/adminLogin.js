import React, { useState } from 'react'
import "./login.css"
/*
  This component renders the Login Form with all its functionalities
  startLogin is the method that uses the axios service to submit login credentials to the backend
*/
const AdminLoginForm = ({ startLogin }) => {
    // States for tracking form input which are the email address and password
    const [ loginid, setloginid ] = useState('')
    const [ pswd, setpswd ] = useState('')
    //const [ loginType, setLoginType ] = useState('')

    // onSubmit event handler of this form
    const handleLogin = (event) => {
        // Preventing default submission of the form to the action attribute URL
        event.preventDefault()

        const credentials = {
            loginid, pswd
        }

        // Calling startLogin with the provided credentials that will make a call to the backend
        startLogin(credentials)

        // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
        //setAbha('')
        //setLoginType('')
        setloginid('')
        setpswd('')
    }
    //const options = ['Patient', 'Doctor', 'Front Desk', 'Admin'];
    //const onOptionChangeHandler = (event) => {
      //  console.log("User Selected Value - ", event.target.value)
       // setLoginType(event.target.value)
    //}
    // Typically keep id attributes on your HTML elements so that they can be styled using CSS
    return (

        <div className="container">
            <div className="screen">
                <div className="screen__content">
                    <form onSubmit={handleLogin} id='login-form' className="login">
                        <div className="login__field">
                            <i className="login__icon fas fa-user"></i>
                            <input className="login__input"
                                   type='text'
                                   placeholder='USERID'
                                   value={loginid}
                                   onChange={event => setloginid(event.target.value)}
                                   id='abha'
                                   required
                            />
                        </div>
                        <div className="login__field">
                            <i className="login__icon fas fa-user"></i>
                            <input className="login__input"
                                   type='password'
                                   placeholder='PASSWORD'
                                   value={pswd}
                                   onChange={event => setpswd(event.target.value)}
                                   id='abha'
                                   required
                            />
                        </div>

                        {/* Same as the above username input, except this one has the type password */}

                        <button type='submit' id='login-submit' className="button login__submit">
                            <span className="button__text">Log In Now</span>
                            <i className="button__icon fas fa-chevron-right"></i>
                        </button>
                        {/* Submit button for the form */}
                    </form>

                </div>
                <div className="screen__background">
                    <span className="screen__background__shape screen__background__shape4"></span>
                    <span className="screen__background__shape screen__background__shape3"></span>
                    <span className="screen__background__shape screen__background__shape2"></span>
                    <span className="screen__background__shape screen__background__shape1"></span>
                </div>
            </div>
        </div>
    )
}
export default AdminLoginForm;