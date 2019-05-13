package ExtraTask;

public class PasswordCheckException extends Exception {
    private String password;

    public PasswordCheckException(String password){
        super("Пароль: " + password + " введен некорректно");
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
