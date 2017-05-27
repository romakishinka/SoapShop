package ru.vsu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.soapshop.model.Location;

/**
 * Created by Александр on 26.05.2017.
 */
public interface LocationRepository extends JpaRepository<Location,Long> {
}
