package ru.vspu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vspu.soapshop.model.Location;

/**
 * Created by Roman Kishinka on 11.05.2021.
 */
public interface LocationRepository extends JpaRepository<Location,Long> {
}
