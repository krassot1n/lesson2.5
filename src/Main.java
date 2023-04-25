import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String[] args) {
        try {
            check("ad_min","Admin_","Admin_");
            System.out.println("Логин выполнен");;
        } catch (WrongLoginException e) {
            throw new IllegalStateException("Произошла ощибка входа");
        }
        catch (WrongPasswordException e){
            e.printStackTrace(System.err);
        }
    }

    private static void check(@NotNull String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Неверевно введен логин");
        }
        if (password.length() >= 20 || !password.equals(confirmPassword) || !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Введите другой пароль");
        }
    }
}