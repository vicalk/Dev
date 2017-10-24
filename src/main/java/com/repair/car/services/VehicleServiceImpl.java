package com.repair.car.services;



        import com.repair.car.converters.UserConverter;
        import com.repair.car.converters.VehicleConverter;
        import com.repair.car.domain.User;
        import com.repair.car.domain.Vehicle;
        import com.repair.car.model.UserRegisterForm;
        import com.repair.car.model.VehicleDetails;
        import com.repair.car.model.VehicleRegisterForm;
        import com.repair.car.repositories.UserRepository;
        import com.repair.car.repositories.VehicleRepository;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;
        import java.util.stream.Collectors;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(com.repair.car.services.VehicleServiceImpl.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void vehicleRegister(VehicleRegisterForm vehicleRegisterForm) throws Exception {

        Vehicle vehicle = VehicleConverter.buildVehicleObject(vehicleRegisterForm);
        User user = userRepository.findByAfm(vehicleRegisterForm.getAfm());
        vehicle.setUser(user);
        vehicleRepository.save(vehicle);
        LOG.debug("Vehicle has been registered!");

    }

    @Override
    public List<VehicleRegisterForm> findAllVehicles() {


        List<Vehicle> retrievedVehicles = vehicleRepository.findAll();

        return retrievedVehicles
                .stream()
                .map(VehicleConverter::buildVehicleForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleRegisterForm> vehicleSearch(String searchText, String searchType)  {

        List<User> retrievedUsers;

        switch (searchType) {
            case "AFM":
                retrievedUsers =  java.util.Arrays.asList(vehicleRepository.findByAfm(searchText));
                break;
            case "PLATENO":
                retrievedUsers =  vehicleRepository.findByPlateNo(searchText);
                break;
            default:
                retrievedUsers = null ;
        }

        return retrievedUsers
                .stream()
                .map(UserConverter::buildUserForm)
                .collect(Collectors.toList());
    }

}












//
//
//public void insertVehicle(VehicleForm vehicleForm) {

//    public List<Vehicle> findVelicleByAfm(String afm){
//        List<Vehicle> vehicles= vehicleRepository.findByAfm(plateNo);
//        vehicles=(List)userService.findUserbyAFM(afm).getVehicle();
//
//        return vehicles;
//

//
//    @Override
//    public List<VehicleDetails> findByPlateNo(String plateNo) {
//        List<Vehicle> vehicles  = vehicleRepository.findByPlateNo(plateNo);
//        return vehicles
//                .stream()
//                .map(VehicleConverter::)
//                .collect(Collectors.toList());
//    }



