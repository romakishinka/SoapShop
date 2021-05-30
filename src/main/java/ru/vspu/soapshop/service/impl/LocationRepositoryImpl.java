package ru.vspu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vspu.soapshop.repository.LocationRepository;
import ru.vspu.soapshop.service.LocationService;
import ru.vspu.soapshop.model.Location;

/**
 * Created by Roman Kishinka on 26.05.2021.
 */
@Service
public class LocationRepositoryImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void saveLocation(Location location){
        locationRepository.saveAndFlush(location);
    }
}
