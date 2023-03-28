package com.iiitb.healthcare_abha.DAO;


import com.iiitb.healthcare_abha.Entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ValidateLogin extends JpaRepository<Registration,Long> {

    Registration findByUsernameAndPassword(String username,String password);




}
