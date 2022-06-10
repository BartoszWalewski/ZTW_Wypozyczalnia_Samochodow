package car_rental.REST.models;

public class AuthenticateModel {
    private int id;
    private Boolean isAdmin;

    public AuthenticateModel(int id, Boolean role) {
        this.id = id;
        this.isAdmin = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
