package car_rental.REST.database;

import car_rental.REST.data.Client;
import car_rental.REST.data.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    Rental findRentalById(int id);

}
