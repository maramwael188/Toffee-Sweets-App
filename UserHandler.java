package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserHandler {
    private ArrayList<customer> users;

    public UserHandler() {
        users = new ArrayList<>();
    }

    // Register a new user and save their information to a file
    public boolean registerUser(String email, String password, String address) {
        for (customer user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Email is already registered");
                return false;
            }
        }
//        OTP o = new OTP();
        String otp1 = OTP.generateOTP();
        OTP.sendOTPByEmail(email, otp1);


        customer newUser = new customer(email, password, address);
        users.add(newUser);


        // Save user information to file
        try {
            File file = new File("users.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(email + "," + password + "," + address + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to save user information to file");
            e.printStackTrace();
            return false;
        }

        System.out.println("User registration successful");
        return true;

    }

    public boolean loginUser(String email, String password) {
        for (customer user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful");
                return true;
            }
        }

        System.out.println("Invalid email or password");
        return false;
    }

    // Load user information from file
    public void loadUsersFromFile() {
        try {
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String email = parts[0];
                    String password = parts[1];
                    String address = parts[2];
                    customer user = new customer(email, password, address);
                    users.add(user);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Failed to load user information from file");
            e.printStackTrace();
        }
    }
}
