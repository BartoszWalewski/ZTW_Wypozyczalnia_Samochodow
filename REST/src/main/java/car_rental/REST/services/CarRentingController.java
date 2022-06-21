package car_rental.REST.services;

import car_rental.REST.data.Car;
import car_rental.REST.data.Client;
import car_rental.REST.data.Rental;
import car_rental.REST.data.User;
import car_rental.REST.models.ClientModel;
import car_rental.REST.models.RentalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CarRentingController {
    @Autowired
    ICarRentingService carService;


    @RequestMapping("/")
    public String run() {
        return "REST is active, now you can do requests :)";
    }



    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        try {
            carService.insertCar(car);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCars() {
        try {
            return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/car/{id}")
    public ResponseEntity<Object> getCar(@PathVariable int id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/car/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping(path = "/car")
    public ResponseEntity<Object> updateCar(@RequestBody Car car) {

        //TODO ogarnąć to inaczej może oraz zadbać, żeby brak nie był 0 czy tam ""
        carService.updateCar(car.getId(), car.getModel(), car.getBrand(), car.getRegistrationNumber(), car.getVIN(), car.getProductionYear());
        return new ResponseEntity<>(carService.getCarById(car.getId()), HttpStatus.OK);
    }


    @PostMapping(path = "/client")
    public ResponseEntity<Object> insertClient(@RequestBody ClientModel clientModel)
    {
        carService.insertClient(clientModel.getUser_id(), clientModel.getUsername(), clientModel.getPassword(), clientModel.getName(),
                clientModel.getSurname(), clientModel.getCard(), clientModel.getCVV(), clientModel.getCardExpireDate(),
                clientModel.getStreet(), clientModel.getPostalCode(), clientModel.getCity(), clientModel.getCountry());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/client/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable int id) {
        return new ResponseEntity<>(carService.getClient(id), HttpStatus.OK);
    }

    @GetMapping(path = "/client")
    public ResponseEntity<Object> getClientById() {
        return new ResponseEntity<>(carService.getAllClients(), HttpStatus.OK);
    }


    @DeleteMapping(path = "/client/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable int id) {
        carService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(carService.getUser(id), HttpStatus.OK);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<Object> getUserById() {
        return new ResponseEntity<>(carService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(path = "/user/authenticate/{user}/{pass}")
    public ResponseEntity<Object> authenticateUser(@PathVariable String user, @PathVariable String pass) {
        return new ResponseEntity<>(carService.authenticateUser(user, pass), HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Object> insertUser(@RequestBody User user) {
        carService.insertUser(user.getId(), user.getUsername(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/rental/{id}")
    public ResponseEntity<Object> getRental(@PathVariable int id) {
        return new ResponseEntity<>(carService.getRental(id), HttpStatus.OK);
    }

    @GetMapping(value = "/rental")
    public ResponseEntity<Object> GetAllRentals() {
        return new ResponseEntity<>(carService.getRentals(), HttpStatus.OK);
    }

    @GetMapping(value = "/rental/client/{id}")
    public ResponseEntity<Object> getClientRentals(@PathVariable int id) {
        List<RentalModel> list = carService.getUserRentals(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/rental")
    public ResponseEntity<Object> insertRental(@RequestBody RentalModel rentalModel) {
        carService.insertRental(rentalModel.getId(), rentalModel.getClient_id(), rentalModel.getCar_id(),
                rentalModel.getRentalStart(), rentalModel.getRentalEnd(), rentalModel.isEnded(),
                rentalModel.getDailyPrice());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/rental/{id}")
    public ResponseEntity<Object> deleteRental(@PathVariable int id) {
        carService.deleteRental(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}