package com.iiitb.healthcare_abha.model;

import jakarta.persistence.*;
@Entity
@Table()
public class Employee {
    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;
    @Column()
    private long abhaid;
    @Column()
    private String name;
    @Column()

    private long mobileno;
    @Column()
    private String email;
    @Column()
    private  String  address;
    @Column()

    private  String EmployeeType;
    @Column()

    private  String  password;
    @Column()
    private  String  DOB;
    @Column()
    private int age;
    @Column()
    private  String  gender;
    @Column()
    private  String  Bloodgroup;
    @Column()
    private  String JoiningDate;

    public Employee() {
    }

    public Employee(long abhaid,String name, long mobileno, String email, String address, String employeeType, String password, String DOB, int age, String gender, String bloodgroup, String joiningDate) {
        this.name = name;
        this.abhaid=abhaid;
        this.mobileno = mobileno;
        this.email = email;
        this.address = address;
        this.EmployeeType = EmployeeType;
        this.password = password;
        this.DOB = DOB;
        this.age = age;
        this.gender = gender;
        this.Bloodgroup= Bloodgroup;
        this.JoiningDate = JoiningDate;
    }

    public long getAbhaid() {
        return abhaid;
    }

    public void setAbhaid(long abhaid) {
        this.abhaid = abhaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String EmployeeType) {
        this.EmployeeType = EmployeeType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodgroup() {
        return Bloodgroup;
    }

    public void setBloodgroup(String Bloodgroup) {
        this.Bloodgroup = Bloodgroup;
    }

    public String getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(String JoiningDate) {
        this.JoiningDate = JoiningDate;
    }



}
