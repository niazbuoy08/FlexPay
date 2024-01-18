import java.util.Scanner;


public class AdminAuthentication {
    private final Admin admin;

    public AdminAuthentication(Admin admin) {
        this.admin = admin;
    }

    public boolean authenticate(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        return admin.login(username, password);
    }
}
