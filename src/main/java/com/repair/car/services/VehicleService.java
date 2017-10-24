package com.repair.car.services;


import com.repair.car.domain.User;
import com.repair.car.domain.Vehicle;
import com.repair.car.model.UserRegisterForm;
import com.repair.car.model.VehicleDetails;
import com.repair.car.model.VehicleRegisterForm;

import java.util.List;


public interface VehicleService {


    void vehicleRegister(VehicleRegisterForm vehicleRegisterForm) throws Exception;

    VehicleRegisterForm findByVehicleId(Long vehicleId);

    List<VehicleRegisterForm> vehicleSearch(String SearchText, String SearchType);

    List<VehicleRegisterForm> findAllVehicles();

    void editVehicle(VehicleRegisterForm vehicleRegisterForm);

    void deleteById(Long vehicleId);

}



