package com.iiitb.healthcare_abha.OnConform_body;


import lombok.Data;

@Data
public class OnConfirmBody{
        public String requestId;
        public String timestamp;
        public String transactionId;
        public Credential credential;
    }


