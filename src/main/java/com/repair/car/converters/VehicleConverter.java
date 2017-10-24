package com.repair.car.converters;

import com.repair.car.domain.Vehicle;
import com.repair.car.model.VehicleDetails;
import com.repair.car.model.VehicleRegisterForm;


public class VehicleConverter {

    public static Vehicle buildVehicleObject(VehicleRegisterForm vehicleRegisterForm) {

        Vehicle vehicle = new Vehicle();

        vehicle.setPlateNo(vehicleRegisterForm.getPlateNo());
        vehicle.setCarModel(vehicleRegisterForm.getCarModel());
        vehicle.setColor(vehicleRegisterForm.getColor());
        vehicle.setYear(vehicleRegisterForm.getYear());

        return vehicle;
    }



        public static VehicleRegisterForm  buildVehicleForm(Vehicle vehicle) {

            VehicleRegisterForm vehicleRegisterForm = new VehicleRegisterForm();

            vehicleRegisterForm.setVehicleId(vehicle.getVehicleId());
            vehicleRegisterForm.setAfm(vehicle.getUser().getAfm());
            vehicleRegisterForm.setPlateNo(vehicle.getPlateNo());
            vehicleRegisterForm.setCarModel(vehicle.getCarModel());
            vehicleRegisterForm.setYear(vehicle.getYear());
            vehicleRegisterForm.setColor(vehicle.getColor());


            return vehicleRegisterForm;
        }

}




