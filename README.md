# Toffee-Sweets-App

# Online Shopping System

This is a simple implementation of an Online Shopping System in Java.

## Project Structure

The project is organized into the following packages:

- `org.example`: Contains the main classes for the Online Shopping System.

## Class Descriptions

- `Admin`: Represents an administrator of the system. It provides functionality to view orders placed by users.

- `Payment`: Represents a payment made by a user. It handles the payment process and calculates change.

- `UserHandler`: Handles user registration and login. It manages the list of registered users and provides methods for user authentication.

- `User`: Represents a user of the system. It stores user information such as email, password, address, name, and phone number.

- `ShoppingCart`: Represents a shopping cart for a user. It allows users to add items to their cart, view the cart, and place orders.

- `catalog`: Represents the catalog of items available for purchase. It loads items from a file and provides methods to display and search for items.

- `items`: Represents an item available for purchase. It stores information such as name, brand, description, category, price, and quantity.

- `Order`: Represents an order placed by a user. It handles the order placement process and stores order details.

## Usage

To run the Online Shopping System, execute the `Main` class located in the `org.example` package.

Upon running the program, you will be presented with a menu of options to interact with the system. You can register as a new user, login with an existing user account, view the catalog of items, add items to your cart, view your cart, place an order, and view order history.

## Dependencies

This project does not have any external dependencies.

## Resources

The project uses the following resource files:

- `users.txt`: Stores user information.
- `catalog.txt`: Stores the catalog of items available for purchase.
- `orders.txt`: Stores the order history.

Make sure these files are present in the project directory when running the program.

## Contributing

Contributions to the project are welcome. If you find any issues or have suggestions for improvements, please submit a pull request or open an issue on the GitHub repository.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.
