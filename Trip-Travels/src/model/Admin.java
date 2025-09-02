package model;

public class Admin extends User{
    public Admin(int id, String firstName, String lastName, String mobileNumber, String gender, String email, String password) {
        super(id, firstName, lastName, mobileNumber, gender, email, password);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
