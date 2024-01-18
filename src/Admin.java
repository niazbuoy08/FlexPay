
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin implements User{
    private static Map<String, String> adminCredentials = new HashMap<>();

    static {
        adminCredentials.put("admin", "admin123");
    }

    @Override
    public boolean login(String username, String password) {
        return adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password);
    }

    @Override
    public void signup(String username, String password) {
        adminCredentials.put(username, password);
        System.out.println("Admin account created successfully!");
    }
}



