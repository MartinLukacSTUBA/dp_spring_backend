package com.example.dp_spring_backend.service;

import com.example.dp_spring_backend.domain.entity.ObdReading;
import com.example.dp_spring_backend.repository.ObdReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ObdReadingService {

    @Autowired
    private ObdReadingRepository obdReadingRepository;

    public ObdReading createReading(ObdReading reading) {
        return null;
//        return obdReadingRepository.save(reading);
    }

//    public ObdReading getReading(long id) {
//        return obdReadingRepository.findOne(id);
//    }

    public Page<ObdReading> getAllReadingsFromVin(String vin, Integer page, Integer size) {
        return obdReadingRepository.findAllByVin(vin, PageRequest.of(page, size));
    }

}
