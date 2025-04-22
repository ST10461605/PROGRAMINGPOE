import java.util.Scanner;

/**
 * Main class to handle user interaction for registration and login.
 * Developed using Java and regex patterns designed with guidance from ChatGPT (OpenAI, 2025).
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Registration
        System.out.println("=== Registration ===");

        System.out.print("Enter your username (must contain an underscore and be no more than 5 characters): ");
        String username = input.nextLine();

        if (Login.checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        System.out.print("Enter your password (must be at least 8 characters, contain a capital letter, a number, and a special character): ");
        String password = input.nextLine();

        if (Login.checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        System.out.print("Enter your cellphone number (must start with +27 followed by 9 digits): ");
        String cellphone = input.nextLine();

        String registrationResult = Login.registerUser(username, password, cellphone);
        System.out.println(registrationResult);

        if (registrationResult.equals("Registration successful!")) {
            System.out.println("\n===== User Login =====");

            System.out.print("Enter first name: ");
            String firstName = input.nextLine();

            System.out.print("Enter last name: ");
            String lastName = input.nextLine();

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            Login userLogin = new Login(username, password, cellphone);

            String loginStatus = userLogin.returnLoginStatus(loginUsername, loginPassword, firstName, lastName);
            System.out.println(loginStatus);
        }

        input.close();
    }
}
