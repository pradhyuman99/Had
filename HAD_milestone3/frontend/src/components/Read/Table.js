import React from 'react'
import './hisPatientDetails.css'
import Display from "../../Display";
import readStat from "../../Display"
import Read from "./Read";
const Table = ( {Root} ) => {
    return (
        <div className="student-profile py-4">
            <div className="container">
                <div className="row">
                    <div className="col-lg-8">
                        <div className="card shadow-sm">
                            <div className="card-header bg-transparent border-0">
                                <h3 className="mb-0"><i className="far fa-clone pr-1"></i>General Information</h3>
                            </div>
                            <div className="card-body pt-0">
                                <table className="table table-bordered">
                                    <tr>
                                        <th width="30%">ID</th>
                                        <td width="2%">:</td>
                                        <td>{Root.eid}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Name</th>
                                        <td width="2%">:</td>
                                        <td>{Root.name}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Gender</th>
                                        <td width="2%">:</td>
                                        <td>{Root.gender}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Year of Birth</th>
                                        <td width="2%">:</td>
                                        <td>{Root.email}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Month of Birth</th>
                                        <td width="2%">:</td>
                                        <td>{Root.dob}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%">Date of Birth</th>
                                        <td width="2%">:</td>
                                        <td>{Root.address}</td>
                                    </tr>
                                    <tr>
                                        <th width="30%">District</th>
                                        <td width="2%">:</td>
                                        <td>{Root.mobileno}</td>
                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )


}
export default Table