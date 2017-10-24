package com.repair.car.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class VehicleEditForm {

    private static final String PLATENO_PATTERN = "^[A-Z]{3}-[0-9]{4}$";

    private static final String NUMBERS_PATTERN = "^[0-9]*$";

    private static final int PLATENO_SIZE = 8;





    @NotEmpty(message = "{vehicleRegister.plateNo.empty}")
    @Pattern(regexp = PLATENO_PATTERN, message = "{vehicleRegister.plateNo.invalid}")
    @Size(min = PLATENO_SIZE, max = PLATENO_SIZE, message = "{vehicleRegister.plateNo.size}")
    private String plateNo;


    private String carModel;

    @Pattern(regexp = NUMBERS_PATTERN, message = "{vehicleRegister.year.invalid}")
    private String year;


    private String color;

    private Long vehicleId;

    public Long getVehicleId() { return vehicleId; }

    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public String getPlateNo() { return plateNo; }

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


}
