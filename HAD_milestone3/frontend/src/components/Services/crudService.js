import axios from 'axios'

const adminLogin = async (credentials) => {
    const loginBaseUrl = `http://localhost:13962`
    console.log(credentials)
    const response = await axios.post(loginBaseUrl, credentials)
    return response.data
}

const readService = async (emp_id) => {
    console.log(emp_id)
    //console.log(loginBaseUrl, empid)
    const response = await axios.get(`http://localhost:13962/api/v1/employees/${emp_id}`)
    //const response = await axios.get(`http://localhost:13962/api/v1/employees/${emp_id}`)
    console.log(response.data.login)
    console.log(response.data.id)
    console.log(response.data.node_id)
    return response.data
}

const deleteService = async (emp_id) => {
    console.log(emp_id)
    const response = await axios.delete(`http://localhost:13962/api/v1/employees/${emp_id}`)
    console.log("deleted")
    console.log(response.data)
    return response.data
}

// Export the method as an object so that it can be accessible outside this file as a service
const exportObject = { adminLogin , readService , deleteService }
export default exportObject