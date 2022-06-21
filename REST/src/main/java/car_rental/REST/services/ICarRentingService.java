package car_rental.REST.services;

import car_rental.REST.data.Car;
import car_rental.REST.data.Client;
import car_rental.REST.data.Rental;
import car_rental.REST.data.User;
import car_rental.REST.models.AuthenticateModel;
import car_rental.REST.models.RentalModel;

import java.util.List;

public interface ICarRentingService {

    /*
                CARS
     */

    public List<Car> getAllCars();
    public Car getCarById(Integer id);

    public void insertCar(Car car);

    public abstract void deleteCar(int id);

    public abstract void updateCar(int id, String brand, String name, String registrationNumber, String VIN, int productionYear);

    /*
                CLIENTS
     */


    public List<Client> getAllClients();

    public abstract void insertClient(int id, String username, String password, String name, String surname,
                                      String card, String CVV, String cardExpireDate, String street, String postalCode,
                                      String city, String country);

    public abstract Client getClient(int id);

    public abstract void updateClient(int id, String username, String password, String name, String surname,
                                       String card, String CVV, String cardExpireDate, String street, String postalCode,
                                       String city, String country);

    public abstract void deleteClient(int id);


    /*
                USERS
     */

    public abstract User getUser(int id);

    public abstract List<User> getAllUsers();

    public abstract AuthenticateModel authenticateUser(String username, String password);

    public abstract void insertUser(int id, String username, String password);


    /*
                RENTAL
     */

    public abstract List<RentalModel> getRentals();

    public abstract List<RentalModel> getUserRentals(int client_id);

    public abstract Rental getRental(int id);

    public abstract void insertRental(int id, int clientId, int carId, String rentalStart, String rentalEnd, boolean ended, double dailyPrice);

    public abstract void deleteRental(int id);
}
