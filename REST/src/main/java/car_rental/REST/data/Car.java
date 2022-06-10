package car_rental.REST.data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String registrationNumber;

    @Column
    private String VIN;
    @Column
    private int productionYear;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    public Car(int id, String brand, String model, String registrationNumber, String VIN, int productionYear) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.VIN = VIN;
        this.productionYear = productionYear;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString()
    {
        return "Car: " + id + " brand: " + brand + " model: " + model + " registration: " + registrationNumber +
                " VIN: " + VIN + " prod year: " + productionYear;
    }
}
