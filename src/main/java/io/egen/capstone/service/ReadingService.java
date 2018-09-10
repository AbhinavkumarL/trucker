package io.egen.capstone.service;

import io.egen.capstone.entity.Reading;
import io.egen.capstone.entity.ReadingRawData;

public interface ReadingService {

    Reading create(ReadingRawData reading);
}
