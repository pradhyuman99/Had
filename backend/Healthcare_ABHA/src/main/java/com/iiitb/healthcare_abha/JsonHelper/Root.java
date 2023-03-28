package com.iiitb.healthcare_abha.JsonHelper;

import lombok.Data;

import java.util.Date;


@Data
public class Root {

    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

    public String requestId;
    public Date timestamp;
    public Auth auth;
    public Object error;
    public Resp resp;

}
