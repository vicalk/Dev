package com.repair.car.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name = "USERS")
public class User implements Serializable {
    @Id
    @Column(name = "USER_ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column (name = "AFM")
    private String afm;

    @Column (name = "LASTNAME")
    private String lastname;

    @Column (name = "FIRSTNAME")
    private String firstname;

    @Column (name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL",nullable = false)
    private String email;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @Column(name = "USER_TYPE",nullable = false)
    private String userType;

    @OneToMany(mappedBy = "user", targetEntity = Vehicle.class , cascade=CascadeType.REMOVE)
    private List<Vehicle> vehicles;


    public User(String afm, String lastname, String firstname, String address, String email, String password, String userType) {

        this.afm = afm;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public User(){}

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "afm=" + afm +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}


