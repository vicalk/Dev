package com.repair.car.services;


import com.repair.car.domain.User;
import com.repair.car.domain.Vehicle;
import com.repair.car.model.UserRegisterForm;
import com.repair.car.model.VehicleDetails;
import com.repair.car.model.VehicleRegisterForm;

import java.util.List;


public interface VehicleService {


    void vehicleRegister(VehicleRegisterForm vehicleRegisterForm) throws Exception;

    List<VehicleRegisterForm> vehicleSearch(String SearchText, String SearchType);

    List<VehicleRegisterForm> findAllVehicles();


}
