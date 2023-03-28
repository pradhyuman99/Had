package com.iiitb.healthcare_abha.JsonHelper;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Patient{
    public String id;
    public String name;
    public String gender;
    public int yearOfBirth;
    public int monthOfBirth;
    public int dayOfBirth;
    public Address address;
    public ArrayList<Identifier> identifiers;
}
