package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;

public class IOLibrary {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            return "";
        }
    }


    public static InetAddress getIPAddress() {
        do {
            try {
                String input = reader.readLine();
                
                // Validate input to ensure it's a valid IP address
                if (isValidIPAddress(input)) {
                    String[] chunks = input.split("\\.");
                    byte[] data = {
                            Byte.parseByte(chunks[0]),
                            Byte.parseByte(chunks[1]),
                            Byte.parseByte(chunks[2]),
                            Byte.parseByte(chunks[3])
                    };
                    return Inet4Address.getByAddress(data);
                } else {
                    System.err.println("Invalid IP address format. Please enter a valid IP address.");
                }
            } catch (IOException e) {
                // Handle the exception appropriately, e.g., log the error
                System.err.println("Error reading input: " + e.getMessage());
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
                // Handle specific exceptions appropriately, e.g., log the error
                System.err.println("Invalid IP address format: " + e.getMessage());
            } catch (Exception e) {
                // Catch any other unexpected exceptions and handle appropriately
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        } while (true);
    }

    private static boolean isValidIPAddress(String input) {
        // Implement a method to validate the input string as a valid IP address
        // You may use regular expressions or a more robust IP address validation method
        // For simplicity, you can assume that the input is valid if it contains four parts separated by dots.
        String[] parts = input.split("\\.");
        return parts.length == 4;
    }
}
