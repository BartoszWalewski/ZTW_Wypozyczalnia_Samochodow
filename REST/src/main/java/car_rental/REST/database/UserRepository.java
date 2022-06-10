package car_rental.REST.database;

import car_rental.REST.data.Client;
import car_rental.REST.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    void findUserByClient(Client client);

    void deleteUserByClient(Optional<Client> byId);

    User getUserById(int id);

    User getUserByUsernameAndPassword(String username, String password);
}
