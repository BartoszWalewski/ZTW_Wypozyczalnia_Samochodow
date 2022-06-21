package car_rental.REST.services;

import car_rental.REST.data.Car;
import car_rental.REST.data.Client;
import car_rental.REST.data.Rental;
import car_rental.REST.data.User;
import car_rental.REST.database.CarRepository;
import car_rental.REST.database.ClientRepository;
import car_rental.REST.database.RentalRepository;
import car_rental.REST.database.UserRepository;
import car_rental.REST.models.AuthenticateModel;
import car_rental.REST.models.RentalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarRentingService implements ICarRentingService {

    @Autowired
    private CarRepository carDao;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private ClientRepository clientDao;

    @Autowired
    private RentalRepository rentalDao;

    @Override
    public List<Car> getAllCars() {
        return carDao.findAll();
    }

    @Override
    public Car getCarById(Integer id) {
        return carDao.getCarById(id);
    }

    @Override
    public void insertCar(Car car) {
        carDao.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carDao.deleteById(id);
    }


    @Override
    public void updateCar(int id, String brand, String name, String registrationNumber, String VIN, int productionYear) {
        Car car = carDao.getCarById(id);
        if (car != null)
        {
            car.setBrand(brand);
            car.setModel(name);
            car.setRegistrationNumber(registrationNumber);
            car.setVIN(VIN);
            car.setProductionYear(productionYear);
            carDao.save(car);
        }

    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }


    @Override
    public void insertClient(int id, String username, String password, String name, String surname, String card, String CVV,
                             String cardExpireDate, String street, String postalCode, String city, String country) {
        Client client = clientDao.save(new Client(id, name, surname, card, CVV, cardExpireDate, street, postalCode, city, country));
        userDao.save(new User(id, username, password, client));
    }

    @Override
    public Client getClient(int id) {
        return clientDao.getClientById(id);
    }

    @Override
    public void updateClient(int id, String username, String password, String name, String surname, String card,
                             String CVV, String cardExpireDate, String street, String postalCode, String city, String country) {
        User user = userDao.getUserById(id);
        Client client = user.getClient();
        user.setUsername(username);
        user.setPassword(password);
        client.setName(name);
        client.setSurname(surname);
        client.setCard(card);
        client.setCVV(CVV);
        client.setCardExpireDate(cardExpireDate);
        client.setStreet(street);
        client.setPostalCode(postalCode);
        client.setCity(city);
        client.setCountry(country);
        clientDao.save(client);
        userDao.save(user);
    }

    @Override
    public void deleteClient(int id) {
        userDao.deleteUserByClient(clientDao.findById(id));
        clientDao.deleteById(id);
    }

    @Override
    public User getUser(int id) {
        User user = userDao.getUserById(id);
        if (user.getClient() == null){
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public AuthenticateModel authenticateUser(String username, String password) {
        User currentUser = userDao.getUserByUsernameAndPassword(username, password);
        if (currentUser != null){
            boolean isAdmin;
            int id;
            if (currentUser.getClient() == null){
                isAdmin = true;
                id = 7;
            }
            else {
                isAdmin = false;
                id = currentUser.getClient().getId();
            }
            return new AuthenticateModel(id, isAdmin);
        }
        return null;
    }

    @Override
    public void insertUser(int id, String username, String password) {
        userDao.save(new User(id, username, password, null));
    }

    @Override
    public List<RentalModel> getRentals() {
        List<Rental> rentals = rentalDao.findAll();
        List<RentalModel> rentalModels = new ArrayList<>();
        for (Rental rent:rentals) {

            rentalModels.add(new RentalModel(rent.getId(), rent.getClient().getId(), rent.getCar().getId(),
                    rent.getRentalStart(), rent.getRentalEnd(), rent.isEnded(), rent.getDailyPrice(),
                    rent.getCar().getBrand() + " " + rent.getCar().getModel()));

        }
        return rentalModels;
    }

    @Override
    public List<RentalModel> getUserRentals(int client_id) {
        List<Rental> list = rentalDao.findAll();
        List<RentalModel> returnList = new ArrayList<>();
        Client client = clientDao.getClientById(client_id);
        for (Rental rent:list) {
            if (rent.getClient() == client)
            {
                returnList.add(new RentalModel(rent.getId(), rent.getClient().getId(), rent.getCar().getId(),
                rent.getRentalStart(), rent.getRentalEnd(), rent.isEnded(), rent.getDailyPrice(),
                        rent.getCar().getBrand() + " " + rent.getCar().getModel()));
            }
        }
        return returnList;
    }


    @Override
    public Rental getRental(int id) {
        return rentalDao.findRentalById(id);
    }

    @Override
    public void insertRental(int id, int clientId, int carId, String rentalStart, String rentalEnd, boolean ended, double dailyPrice) {
        if (clientDao.getClientById(clientId) != null){
            System.out.println("Znalazłem klienta");
            if (carDao.getCarById(carId) != null){
                System.out.println("Znalazłem auto");
                rentalDao.save(new Rental(id, clientDao.getClientById(clientId), carDao.getCarById(carId), rentalStart,
                        rentalEnd, ended, dailyPrice));
            }
        }
    }

    @Override
    public void deleteRental(int id) {
        rentalDao.deleteById(id);
    }


//    /*
//                CLIENTS
//     */
//
//    private static ArrayList<User> usersRepo = new ArrayList();
//
//    static {
//        usersRepo.add(new User(0, "tadek123", "321kedat", new Client(0, "Tadek","Nowak",
//                "1111 1111 1111 1111", "111", "07/25", "Krakowska 52", "50-001",
//                "Wrocław", "Polska")));
//        usersRepo.add(new User(1, "radek123", "321kedar", new Client(1, "Radek","Nowacki",
//                "1111 1111 1111 1111", "111", "08/25", "Krakowska 87", "50-002",
//                "Wrocław", "Polska")));
//        usersRepo.add(new User(2, "barma", "haslo123", new Client(2, "Bartosz","Markowski",
//                "2222 2222 2222 2222", "147", "02/23", "Rynel 28/4", "45-001",
//                "Opole", "Polska")));
//    }
//
//    @Override
//    public Collection<User> getClients() {
//        return usersRepo;
//    }
//
//    @Override
//    public void insertClient(int id, String username, String password, String name,
//                             String surname, String card, String CVV, String cardExpireDate,
//                             String street, String postalCode, String city, String country) {
//        for (User user : usersRepo) {
//            if (user.getUser_id() == id)
//            {
//                return;
//            }
//        }
//        usersRepo.add(new User(id, username, password, new Client(id, name, surname, card, CVV, cardExpireDate, street,
//                postalCode, city, country)));
//    }
//
//    @Override
//    public User getClients(int id) {
//        for (User client : usersRepo) {
//            if (client.getUser_id() == id)
//            {
//                if (client.getClient() != null)
//                {
//                    return client;
//                }
//                return null;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void updateClient(int id, String username, String password, String role, String name,
//                              String surname, String card, String CVV, String cardExpireDate,
//                              String street, String postalCode, String city, String country) {
//        for (User client : usersRepo) {
//            if (client.getUser_id() == id)
//            {
//                if (client.getClient() != null)
//                {
//                    client.setUsername(username);
//                    client.setPassword(password);
//                    client.getClient().setName(name);
//                    client.getClient().setSurname(surname);
//                    client.getClient().setCard(card);
//                    client.getClient().setCVV(CVV);
//                    client.getClient().setCardExpireDate(cardExpireDate);
//                    client.getClient().setStreet(street);
//                    client.getClient().setPostalCode(postalCode);
//                    client.getClient().setCity(city);
//                    client.getClient().setCountry(country);
//                }
//                return;
//            }
//        }
//    }
//
//    @Override
//    public void deleteClient(int id) {
//        for (User client : usersRepo) {
//            if (client.getUser_id() == id)
//            {
//                if (client.getClient() != null)
//                {
//                    usersRepo.remove(id);
//                }
//                return;
//            }
//        }
//    }
//
//    /*
//                USERS
//     */
//
//    @Override
//    public User getUser(int id) {
//        for (User user : usersRepo) {
//            if (user.getUser_id() == id)
//            {
//                if (user.getClient() == null)
//                {
//                    return user;
//                }
//                return null;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean authenticateUser(String username, String password) {
//        for (User user : usersRepo) {
//            if (Objects.equals(user.getUsername(), username))
//            {
//                return Objects.equals(user.getPassword(), password);
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void insertUser(int id, String username, String password) {
//        for (User user : usersRepo) {
//            if (user.getUser_id() == id)
//            {
//                return;
//            }
//        }
//        usersRepo.add(new User(id, username, password, null));
//    }
//
//    /*
//                RENTALS
//     */
//
//    private static ArrayList<Rental> rentalsRepo = new ArrayList();
//    static {
//        rentalsRepo.add(new Rental(0, usersRepo.get(0), carsRepo.get(0), "05.01.2020", "05.02.2020", true, 200.0));
//        rentalsRepo.add(new Rental(0, usersRepo.get(1), carsRepo.get(1), "10.01.2020", "12.02.2020", true, 250.0));
//        rentalsRepo.add(new Rental(0, usersRepo.get(1), carsRepo.get(0), "17.10.2020", "22.11.2020", true, 100.0));
//    }
//
//    @Override
//    public Collection<Rental> getRentals() {
//        return rentalsRepo;
//    }
//
//    @Override
//    public Rental getRental(int id) {
//        for (Rental rental : rentalsRepo) {
//            if (rental.getId() == id)
//            {
//                return rental;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void insertRental(int id, int clientId, int carId, String rentalStart, String rentalEnd, boolean ended, double dailyPrice) {
//        for (Rental rental : rentalsRepo) {
//            if (rental.getId() == id)
//            {
//                return;
//            }
//        }
//        boolean isCar = false;
//        boolean isClient = false;
//        for (Car car : carsRepo) {
//            if (car.getId() == carId) {
//                isCar = true;
//                break;
//            }
//        }
//        for (User client : usersRepo) {
//            if (client.getUser_id() == id)
//            {
//                if (client.getClient() != null) {
//                    isClient = true;
//                    break;
//                }
//            }
//        }
//        if (!isCar || !isClient) {
//            return;
//        }
//        rentalsRepo.add(new Rental(id, usersRepo.get(clientId), carsRepo.get(carId), rentalStart, rentalEnd, ended, dailyPrice));
//    }
}
