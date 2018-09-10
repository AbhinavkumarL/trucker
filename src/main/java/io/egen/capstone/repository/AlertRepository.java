package io.egen.capstone.repository;

import io.egen.capstone.entity.Alert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlertRepository extends CrudRepository<Alert, Integer> {
}
