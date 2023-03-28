package com.iiitb.healthcare_abha.JasonTokenHelper;


import lombok.Data;

@Data
public class  AccessToken {
        public String accessToken;
        public float expiresIn;
        public float refreshExpiresIn;
        public String refreshToken;
        public String tokenType;


        // Getter Methods

    }

