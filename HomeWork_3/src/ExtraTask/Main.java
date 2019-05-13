package ExtraTask;

public class Main {
    public static void main(String[] args) {

        try {
            PasswordCheck.checkPassword("sCwfggf1#gf23");
        } catch (PasswordCheckException e) {
            e.printStackTrace();
        }
    }
}
