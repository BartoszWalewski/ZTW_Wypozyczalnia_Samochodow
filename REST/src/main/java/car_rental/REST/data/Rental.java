package car_rental.REST.data;

import javax.persistence.*;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    private String rentalStart;

    private String rentalEnd;

    private boolean ended;

    private double dailyPrice;

    public Rental(int id, Client user, Car car, String rentalStart, String rentalEnd, boolean ended, double dailyPrice) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.ended = ended;
        this.dailyPrice = dailyPrice;
    }

    public Rental() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(String rentalStart) {
        this.rentalStart = rentalStart;
    }

    public String getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(String rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public Client getClient() {
        return user;
    }

    public void setClient(Client user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
