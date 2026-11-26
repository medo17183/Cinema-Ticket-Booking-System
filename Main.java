

import java.util.Scanner;

public class Main {

    static char[][] seats = new char[5][6];

    static String[] movieNames = {
            "Superman", "Avatar", "Minecraft", "Inside Out", "F1"
    };

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // make all seats avalable
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                seats[i][j] = 'O';
            }
        }

        int choice;

        do {

            System.out.println("\n===== CINEMA MENU =====");
            System.out.println("1. Display Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show all movies");
            System.out.println("5. Show available and booked seats");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    displaySeats();
                    break;

                case 2:
                    bookSeat(input);
                    break;

                case 3:
                    cancelBooking(input);
                    break;

                case 4:
                    showMovies();
                    break;

                case 5:
                    showSeatCount();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        input.close();
    }

    // display all seats
    public static void displaySeats() {

        System.out.println("\nCinema Seats:");

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 6; j++) {
                System.out.print(seats[i][j] + " ");
            }

            System.out.println();
        }
    }

    // book a seat
    public static void bookSeat(Scanner input) {

        System.out.print("Enter seat number (Example: 12): ");
        int seatNumber = input.nextInt();

        int row = seatNumber / 10;
        int col = seatNumber % 10;

        if (row < 1 || row > 5 || col < 1 || col > 6) {

            System.out.println("Invalid Seat.");

        } else if (seats[row - 1][col - 1] == 'X') {

            System.out.println("Seat already booked!");

        } else {

            seats[row - 1][col - 1] = 'X';

            System.out.println("Seat booked successfully!");
        }
    }

    // cancel a booking
    public static void cancelBooking(Scanner input) {

        System.out.print("Enter seat number (Example: 12): ");
        int seatNumber = input.nextInt();

        int row = seatNumber / 10;
        int col = seatNumber % 10;

        if (row < 1 || row > 5 || col < 1 || col > 6) {

            System.out.println("Invalid Seat.");

        } else if (seats[row - 1][col - 1] == 'O') {

            System.out.println("This seat is not booked!");

        } else {

            seats[row - 1][col - 1] = 'O';

            System.out.println("Booking cancelled successfully!");
        }
    }

    // Show all movies
    public static void showMovies() {

        System.out.println("\nAvailable Movies:");

        for (int i = 0; i < movieNames.length; i++) {

            System.out.println((i + 1) + ". " + movieNames[i]);
        }
    }

    // Count available and booked seats
    public static void showSeatCount() {

        int booked = 0;
        int available = 0;

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 6; j++) {

                if (seats[i][j] == 'X') {
                    booked++;
                } else {
                    available++;
                }
            }
        }

        System.out.println("Booked seats: " + booked);
        System.out.println("Available seats: " + available);

        double percentage = (booked * 100.0) / 30;

        if (percentage > 80) {
            System.out.println("Almost Full!");
        }
    }
}
