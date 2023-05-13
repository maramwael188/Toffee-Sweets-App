package org.example;

import java.io.*;
import java.util.Scanner;

public class Admin {
    private String Name;
    private String email;
    private int phone;
    private String password;

    public Admin(){
        this.phone = 0;
        this.password = "";
        this.email = "";
        this.Name = "";
    }

    public void ViewOrders(){
                String fileName = "orders.txt";
                try {
                    File file = new File(fileName);
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
    }
}
