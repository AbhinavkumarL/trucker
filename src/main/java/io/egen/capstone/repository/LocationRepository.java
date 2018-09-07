package io.egen.capstone.repository;

import io.egen.capstone.entity.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

    @Query(value ="select l.* from Location l where vin = ?1 and created_at > ?2", nativeQuery = true)
    List<Location> findByVinLast30Mins(String vin, Date lastTime);
}
