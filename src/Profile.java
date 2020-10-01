public class Profile {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String emailPassword;

    public Profile(){
    }

    @Override
    public String toString() {
        return "Profile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", emailPassword='" + emailPassword + '\'' +
                '}';
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public String getEmailPassword(){
        return emailPassword;
    }

    public void setFirstName(String inputFirstName){
        this.firstName = inputFirstName;
    }

    public void setLastName(String inputLastName){
        this.lastName = inputLastName;
    }

    public void setEmailAddress(String inputEmailAddress){
        this.emailAddress = inputEmailAddress;
    }

    public void setEmailPassword(String inputEmailPassword){
        this.emailPassword = inputEmailPassword;
    }
}
