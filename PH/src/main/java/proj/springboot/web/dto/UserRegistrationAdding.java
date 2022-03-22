package proj.springboot.web.dto;

public class UserRegistrationAdding {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String uNum;
    private String street;
    private String city;
    private Integer AvailableSlots;

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    private String ZipCode;
    public UserRegistrationAdding(){

    }

    public UserRegistrationAdding(String firstName, String lastName, String email, String password, String uNum, String street, String city) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.uNum = uNum;
        this.street = street;
        this.city = city;
        this.ZipCode =ZipCode;
        this.AvailableSlots =AvailableSlots;

    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
