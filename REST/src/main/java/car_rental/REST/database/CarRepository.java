package car_rental.REST.database;

import car_rental.REST.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car getCarById(Integer id);
}
