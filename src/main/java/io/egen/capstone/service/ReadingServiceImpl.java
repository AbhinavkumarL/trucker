package io.egen.capstone.service;

import io.egen.capstone.entity.Reading;
import io.egen.capstone.repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    private ReadingsRepository repository;

    @Override
    @Transactional
    public Reading create(Reading reading) {
        return repository.save(reading);
    }
}
