package com.iiitb.healthcare_abha.NgrokJasonHelper;

import lombok.Data;

import java.util.Date;

@Data
public class Root2{
    public String requestId;
    public Date timestamp;
    public Auth2 auth;
    public Object error;
    public Resp2 resp;
}

