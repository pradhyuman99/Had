package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="patient_registration")
public class Registration {


    @Column(name = "Registration_abha_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long Registration_abha_id;
    @Column(name = "patient_username")
    int username;
    @Column(name = "patient_password")
    int password;



}
