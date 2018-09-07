package io.egen.capstone.service;

import io.egen.capstone.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();
    Vehicle create(Vehicle vehicle);
    Vehicle update(String vin, Vehicle vehicle);
    void insertListVehicles(List<Vehicle> vehicleList);
    List<Vehicle> findHighAlertVehicles();
}
