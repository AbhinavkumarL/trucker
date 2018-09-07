package io.egen.capstone.service;

import io.egen.capstone.entity.Location;
import io.egen.capstone.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;
    @Override
    public List<Location> findByVinLast30Mins(String vin) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -30);
        Date halfHourBack = cal.getTime();
        System.out.println("Two hours back time:"+ halfHourBack);

        return locationRepository.findByVinLast30Mins(vin, halfHourBack);
    }
}
