import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String[] args) {
        try {
            check("ad_min", "Admin_", "Admin_");
            System.out.println("Логин выполнен");
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Неверевно введен логин");
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Неверно введен пароль");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля не должна превышать 20 символов");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина не должна превышать 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совподают");
        }
    }
}