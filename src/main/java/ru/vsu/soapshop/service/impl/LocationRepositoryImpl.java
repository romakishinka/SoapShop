package ru.vsu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.soapshop.model.Location;
import ru.vsu.soapshop.repository.LocationRepository;
import ru.vsu.soapshop.service.LocationService;

/**
 * Created by Александр on 26.05.2017.
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
