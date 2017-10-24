package com.repair.car.repositories;

import com.repair.car.domain.User;
import com.repair.car.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

   List<Vehicle> findAll();

 List<Vehicle> findByPlateNo(String plateNo);

    List<Vehicle> findByVehicleId(Long vehicleId);

    List<Vehicle> findByUser_UserId(Long userId);

    void deleteByVehicleId(Long vehicleId);

    Vehicle save(Vehicle vehicle);


}

