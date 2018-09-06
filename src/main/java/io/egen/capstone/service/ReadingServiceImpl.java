package io.egen.capstone.service;

import io.egen.capstone.entity.*;
import io.egen.capstone.repository.AlertRepository;
import io.egen.capstone.repository.LocationRepository;
import io.egen.capstone.repository.ReadingsRepository;
import io.egen.capstone.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    private ReadingsRepository readingsRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private AlertRepository alertRepository;


    @Override
    @Transactional
    public Reading create(ReadingRawData readingRawData){
        Location location = new Location(readingRawData.getVin(), readingRawData.getLatitude(), readingRawData.getLongitude(), readingRawData.getTimestamp());
        insertLocation(location);

        Tire tire = new Tire(readingRawData.getTires().getFrontLeft(), readingRawData.getTires().getFrontLeft(), readingRawData.getTires().getRearLeft(), readingRawData.getTires().getRearRight());
        Reading reading = new Reading(readingRawData.getVin(), readingRawData.getFuelVolume(), readingRawData.getSpeed(), readingRawData.getEngineHp(),
                                        readingRawData.getCheckEngineLightOn(), readingRawData.getEngineCoolantLow(), readingRawData.getCruiseControlOn(), readingRawData.getEngineRpm());
        reading.setTire(tire);
        tire.setReading(reading);

        // Check for all alert that needs to be triggered
        checkAlert(reading);

        return readingsRepository.save(reading);
    }

    public Location insertLocation(Location location){
        return locationRepository.save(location);
    }

    public void checkAlert(Reading reading) {
        Optional<Vehicle> vehicleExists = vehicleRepository.findById(reading.getVin());

        if( vehicleExists.isPresent()){
            Vehicle vehicle = vehicleExists.get();
            if( reading.getEngineRpm() > vehicle.getRedlineRpm() ){
                Alert alert = new Alert("HIGH", "EngineRPM", vehicle);
                alertRepository.save(alert);
            }

            if ( reading.getFuelVolume() < (vehicle.getMaxFuelVolume()*0.10) ){
                Alert alert = new Alert("MEDIUM", "LowFuel", vehicle);
                alertRepository.save(alert);
            }

            if(reading.getEngineCoolantLow() || reading.getCheckEngineLightOn()) {
                Alert alert = new Alert("LOW", "Engine Light/Coolant", vehicle);
                alertRepository.save(alert);
            }

            if(checkTirePressure(reading.getTire())){
                Alert alert = new Alert("LOW", "TirePressure",vehicle);
                alertRepository.save(alert);
            }
        }
    }

    private Boolean checkTirePressure(Tire tire){
        if(tire.getFrontLeft() <32 || tire.getFrontLeft() >36 ||
            tire.getFrontRight() <32 || tire.getFrontRight() >36 ||
            tire.getRearLeft() <32 || tire.getRearLeft() >36 ||
            tire.getRearRight() < 32 || tire.getRearRight() > 36){
            return true;
        }else {
            return false;
        }
    }
}
