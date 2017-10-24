
package com.repair.car.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table (name = "REPAIRS")

public class Repair implements Serializable {
    @Id
    @Column(name = "REPAIR_ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long repairId;

    @Column(name = "REPAIR_DATE", nullable = false)
    private Date repairDate;

    @Column(name = "REPAIR_STATUS")
    private String repairStatus;

    @Column(name = "REPAIR_TYPE")
    private String repairType;

    @Column(name = "REPAIR_COST")
    private int repairCost;

    @Column(name = "REPAIR_DESCRIPTION")
    private String repairDescription;

    @ManyToOne(optional = false)
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "VEHICLE_ID")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "repair", targetEntity = Part.class , cascade=CascadeType.REMOVE)
    private List<Part> parts;


    public Repair() { }

    public Repair(Date date, String repairStatus, String repairType, int repairCost, String repairDescription, Long vehicleId) {
        this.repairDate = date;
        this.repairStatus = repairStatus;
        this.repairType = repairType;
        this.repairCost = repairCost;
        this.repairDescription = repairDescription;
    }

    public Date getDate() {
        return repairDate;
    }

    public void setDate(Date date) {
        this.repairDate = date;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "date='" + repairDate + '\'' +
                ", repairStatus='" + repairStatus + '\'' +
                ", repairType='" + repairType + '\'' +
                ", repairCost='" + repairCost + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                '}';
    }
}



