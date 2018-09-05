package io.egen.capstone.service;

import io.egen.capstone.entity.Vehicle;
import io.egen.capstone.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository repository;

    @Override
    public List<Vehicle> findAll(){
        return (List<Vehicle>) repository.findAll();
    }

    @Override
    public Vehicle create(Vehicle vehicle){
        boolean existing = repository.existsById(vehicle.getVin());
        if(existing) {
            update(vehicle.getVin(), vehicle);
        }
        return repository.save(vehicle);
    }

    @Override
    public Vehicle update(String vin, Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public void insertListVehicles(List<Vehicle> vehicleList) {
        vehicleList.forEach( (v) -> create(v));
    }
}
