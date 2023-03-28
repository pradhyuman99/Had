import { useState, useEffect } from 'react'
import loginService from "./components/Services/crudService";
import AdminNotification from "./components/Admin_login/adminNotification";
import AdminLogin from "./components/Admin_login/adminLogin";
import Dashboard from "./components/dashboard/Dashboard";
import "./components/Admin_login/login.css";


const Home = () => {
    // user state will store the logged in user object, if no login has been done yet then it will be null
    const [ loginStatus, setLoginStatus ] = useState(null)
    //const [ otpStatus, setOtpStatus] = useState(null)
    // These states are used to control the notifications that show up at the top of the screen for events like
    // login, signup, watchlist creation, etc.
    const [ notification, setNotification ] = useState(null)
    const [ notificationType, setNotificationType ] = useState(null)

    // Create a notification at the top of the screen with given message for 10 seconds
    // Notifications are of two types, "error" and "success"
    // The appearance of these two notifications can be adjusted via the index.css file
    const notificationHandler = (message, type) => {
        setNotification(message)
        setNotificationType(type)

        setTimeout(() => {
            setNotificationType(null)
            setNotification(null)
        }, 3000)
    }


    // Function that handles login of users
    const handleLogin = async (credentials) => {
        try {
            setLoginStatus(null)
            const userObject = await loginService.adminLogin(credentials)
            notificationHandler("Success", 'success')
            setLoginStatus(userObject)
        }
        catch (exception) {
            notificationHandler(`Invalid UserID and Password`, 'error')
            setLoginStatus(null)
        }
    }
    // Effect Hook that parses the local storage for 'loggedInUser' and sets the "user" state if a valid match is found
    // This enables user to login automatically without having to type in the credentials. Caching the login if you will.
    //useEffect(() => {
    // const loggedInUser = window.localStorage.getItem('loggedInUser')
    // if (loggedInUser){
    //  setLoginStatus(JSON.parse(loggedInUser))
    //}
    //}, [])

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

            {/* Notification component that will render only when the notification state is not null */}
            <AdminNotification notification={notification} type={notificationType} />

            {
                /* Show Login form when no login has happened */
                  loginStatus === null &&
                   <AdminLogin startLogin={handleLogin}/>
               }

        </div>
    )
}

export default Home;

