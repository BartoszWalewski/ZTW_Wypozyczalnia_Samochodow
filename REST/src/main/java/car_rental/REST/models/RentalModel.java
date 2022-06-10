package car_rental.REST.models;


public class RentalModel {

    private Integer id;

    private Integer client_id;

    private Integer car_id;

    private String rentalStart;

    private String rentalEnd;

    private boolean ended;

    private double dailyPrice;

    private String carrr;

    public RentalModel(Integer id, Integer client_id, Integer car_id, String rentalStart, String rentalEnd, boolean ended, double dailyPrice, String carrr) {
        this.id = id;
        this.client_id = client_id;
        this.car_id = car_id;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.ended = ended;
        this.dailyPrice = dailyPrice;
        this.carrr = carrr;
    }

    public RentalModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
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

    public String getCarrr() {
        return carrr;
    }

    public void setCarrr(String carrr) {
        this.carrr = carrr;
    }
}
