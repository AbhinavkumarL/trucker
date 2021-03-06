package io.egen.capstone.repository;

import io.egen.capstone.entity.Reading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingsRepository extends CrudRepository<Reading, Integer> {
}
