import java.io.Console;

public class LoginSystem {

    // Hardcoded credentials for simplicity
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.out.println("Console is not available. Please run the program from a terminal.");
            return;
        }

        int attempts = 3;

        while (attempts > 0) {
            System.out.println("Enter your credentials:");

            // Read username
            String username = console.readLine("Username: ");

            // Read password and mask with '*'
            char[] passwordChars = console.readPassword("Password: ");
            String password = new String(passwordChars);

            // Check credentials
            if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                System.out.println("Login successful!");
                return;
            } else {
                attempts--;
                System.out.println("Incorrect username or password. Attempts left: " + attempts);
            }

            // Wait a bit before next attempt (optional)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Maximum login attempts exceeded. Access denied.");
    }
}
