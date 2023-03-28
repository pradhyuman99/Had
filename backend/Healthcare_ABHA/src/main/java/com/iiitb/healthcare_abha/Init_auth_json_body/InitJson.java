package com.iiitb.healthcare_abha.Init_auth_json_body;


import lombok.Data;
import java.util.UUID;
import java.text.DateFormat;

@Data
public class InitJson {

    public String requestId;
    public String timestamp;
    public Query query;



}
