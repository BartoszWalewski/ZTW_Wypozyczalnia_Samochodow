package car_rental.REST.models;

public class ClientModel {
    private Integer user_id;
    private String username;
    private String password;
    private Integer client_id;
    private String name;
    private String surname;
    private String card;
    private String CVV;
    private String cardExpireDate;
    private String street;
    private String postalCode;
    private String city;
    private String country;

    public ClientModel(Integer user_id, String username, String password, Integer client_id, String name, String surname,
                       String card, String CVV, String cardExpireDate, String street, String postalCode, String city,
                       String country) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.client_id = client_id;
        this.name = name;
        this.surname = surname;
        this.card = card;
        this.CVV = CVV;
        this.cardExpireDate = cardExpireDate;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getCardExpireDate() {
        return cardExpireDate;
    }

    public void setCardExpireDate(String cardExpireDate) {
        this.cardExpireDate = cardExpireDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
