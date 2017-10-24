package com.repair.car.converters;

import com.repair.car.domain.Vehicle;
import com.repair.car.model.VehicleDetails;
import com.repair.car.model.VehicleRegisterForm;
import com.repair.car.repositories.VehicleRepository;

public class VehicleConverter {

    public static Vehicle buildVehicleObject(VehicleRegisterForm vehicleRegisterForm) {
        Vehicle vehicle = new Vehicle();
         VehicleRepository vehicleRepository;

        vehicle.setPlateNo(vehicleRegisterForm.getPlateNo());
        vehicle.setCarModel(vehicleRegisterForm.getCarModel());
        vehicle.setColor(vehicleRegisterForm.getColor());
        vehicle.setYear(vehicleRegisterForm.getYear());



        return vehicle;
    }



        public static VehicleRegisterForm  buildVehicleForm(Vehicle vehicle) {

            VehicleRegisterForm vehicleRegisterForm = new VehicleRegisterForm();

            vehicleRegisterForm.setVehicleId(vehicle.getVehicleId());
            vehicleRegisterForm.setPlateNo(vehicle.getPlateNo());
            vehicleRegisterForm.setCarModel(vehicle.getCarModel());
            vehicleRegisterForm.setYear(vehicle.getYear());
            vehicleRegisterForm.setColor(vehicle.getColor());
            vehicleRegisterForm.setAfm(vehicle.getYear());

            return vehicleRegisterForm;
        }

}




