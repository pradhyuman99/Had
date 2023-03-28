package com.iiitb.healthcare_abha.Service;


import com.iiitb.healthcare_abha.DAO.ValidateLogin;
import com.iiitb.healthcare_abha.Entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private ValidateLogin validateLogin;

    public boolean ValidatingLogin(String username,String password){
        Registration registration= validateLogin.findByUsernameAndPassword(username,password);

        if(registration==null){
            return false;
        }
        else{
            return true;
        }
    }
}
