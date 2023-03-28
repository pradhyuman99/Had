package com.iiitb.healthcare_abha.Init_auth_json_body;


import lombok.Data;

@Data
public class Query {

    public String id;
    public String purpose;
    public String authMode;
    public Requester requester;
}
