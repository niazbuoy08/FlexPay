import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface User {
    boolean login(String username, String password);
    void signup(String username, String password);
}
