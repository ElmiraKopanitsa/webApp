package kz.kopanitsa.repository;

import kz.kopanitsa.entity.Entertainment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface EntertainmentRepository extends
        JpaRepository<Entertainment, Long>,
        JpaSpecificationExecutor<Entertainment> {

    List<Entertainment> findByName (String name);

    List<Entertainment> findByDate(LocalDate date);

    List<Entertainment> findByCity(String city);

    List<Entertainment> findByPrice(Integer price);

    List<Entertainment> findByVenue(String venue);
}
