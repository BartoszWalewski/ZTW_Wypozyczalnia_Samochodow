package car_rental.REST.database;

import car_rental.REST.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client getClientById(int id);
}
