
package com.repair.car.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name = "VEHICLES")
public class Vehicle implements Serializable {
    @Id
    @Column(name = "VEHICLE_ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    @Column(name = "PLATENO", nullable = false)
    private String plateNo;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @Column(name = "YEAR")
    private String year;

    @Column(name = "COLOR")
    private String color;


    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "vehicle", targetEntity = Repair.class , cascade=CascadeType.REMOVE)
    private List<Repair> repairs;


    public Vehicle(String plateNo, String carModel, String year, String color, String afm) {

        this.plateNo = plateNo;
        this.carModel = carModel;
        this.year = year;
        this.color = color;

    }

    public Vehicle() { }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Long getVehicleId() { return vehicleId; }

    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }





    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNo='" + plateNo + '\'' +
                ", carModel='" + carModel + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
