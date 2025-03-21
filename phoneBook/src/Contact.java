public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetAdress;
    
    public Contact(String firstName, String lastName, String phoneNumber, String streetAdress) {
        // set up fields for a contact object in the constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAdress = streetAdress;
    }
    
    // getters and setters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAdress() { return streetAdress; }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + streetAdress + ": " + phoneNumber;
    }
}