package MainTask;

public class PhoneNumberException extends Exception{
    private String number;
    private String lastName;

    public PhoneNumberException(String number, String lastName){
        super("Номер: " + number + " или Фамилия: " + lastName + " введены некорректно");
        this.number = number;
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getLastName() {
        return lastName;
    }
}
