package io.egen.capstone.service;

import io.egen.capstone.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    List<Location> findByVinLast30Mins(String vin);
}
