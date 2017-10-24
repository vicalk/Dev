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
    public VehicleRegisterForm findByVehicleId(Long vehicleId){

       return VehicleConverter.buildVehicleForm(vehicleRepository.findByVehicleId(vehicleId));

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

        List<Vehicle> retrievedVehicles;

        switch (searchType) {

            case "AFM":

                retrievedVehicles =  vehicleRepository.findByUser_UserId((userRepository.findByAfm(searchText)).getUserId());

                break;
            case "PLATENO":

                retrievedVehicles =  vehicleRepository.findByPlateNo(searchText);

                break;
            default:
                retrievedVehicles = null ;
        }

        return retrievedVehicles
                .stream()
                .map(VehicleConverter::buildVehicleForm)
                .collect(Collectors.toList());
    }

    @Override
    public void editVehicle(VehicleRegisterForm vehicleRegisterForm) {

        Vehicle vehicle = VehicleConverter.buildVehicleObject(vehicleRegisterForm);

//        Vehicle persistVehicle = vehicleRepository.findByVehicleId(vehicle.getVehicleId());
//
////        vehicle.setUser(persistVehicle.getUser());

        vehicleRepository.save(vehicle);
        LOG.debug("Vehicle has been edited!");

    }

    @Override
    public void deleteById(Long vehicleId) {
        vehicleRepository.deleteByVehicleId(vehicleId);
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



