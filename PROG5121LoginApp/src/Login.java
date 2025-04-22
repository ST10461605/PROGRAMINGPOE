import java.util.regex.*;

/**
 * The Login class handles user registration and login validation.
 * RegEx patterns were developed using ChatGPT (OpenAI, 2025).
 */
public class Login {
    private String username;
    private String password;
    private String cellphone;

    // Password regex: At least 8 characters, 1 uppercase, 1 digit, 1 special char
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
        "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"
    ); // Reference: ChatGPT, OpenAI (2025)

    // South African cellphone regex: starts with +27 and followed by 9 digits
    private static final Pattern CELL_PATTERN = Pattern.compile("^\\+27\\d{9}$"); // Reference: ChatGPT, OpenAI (2025)

    public Login(String username, String password, String cellphone) {
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
    }

    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static boolean checkCellPhoneNumber(String cellphone) {
        return CELL_PATTERN.matcher(cellphone).matches();
    }

    public static String registerUser(String username, String password, String cellphone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellphone)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        return "Registration successful!";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public String returnLoginStatus(String inputUsername, String inputPassword, String firstName, String lastName) {
        if (loginUser(inputUsername, inputPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
