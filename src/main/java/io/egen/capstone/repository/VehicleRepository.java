package io.egen.capstone.repository;

import io.egen.capstone.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
    @Query(value = "select v.* from Vehicle v , Alert a where v.vin = a.vin and a.created_at > ?1 and a.priority = 'HIGH'", nativeQuery = true)
     List<Vehicle> findHighAlertVehicles(Date paramCreatedAt);
}
