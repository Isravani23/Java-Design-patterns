import model.Trip;
import model.User;
import service.BookingService;
import service.TripService;
import service.UserService;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static Map<String, Integer> userInvalidLoginAttempt = new HashMap<>();
    private static UserService userService = new UserService(users, userInvalidLoginAttempt);
    private static TripService tripService = new TripService();
    private static BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean running = true;

        while (running) {
            System.out.println("\nMenu Options:");
            System.out.println("1. New Admin model.User Registration");
            System.out.println("2. Login");
            System.out.println("3. Plan journey");
            System.out.println("4. Reschedule booking date");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    userService.regiterNewAdmin();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                System.out.println("\n--- Plan Journey ---");
                System.out.println("1. Add Trip");
                System.out.println("2. Search Trip");
                System.out.print("Choose option: ");
                int subChoice = Integer.parseInt(scanner.nextLine());
                if (subChoice == 1) {
                    tripService.addTrip();
                } else if (subChoice == 2) {
                    tripService.searchTrips();
                } else {
                    System.out.println("Invalid option!");
                }
                break;
                case 4:
                    System.out.print("Enter booking ID to reschedule: ");
                    int bookingId = scanner.nextInt();

                    System.out.print("Enter new source: ");
                    String newSrc = scanner.next();

                    System.out.print("Enter new destination: ");
                    String newDest = scanner.next();

                    System.out.print("Enter seat number for new trip: ");
                    int newSeat = scanner.nextInt();

                    // Search for new trip
                    List<Trip> possibleTrips = tripService.searchTrips(newSrc, newDest, LocalDate.now());
                    if (possibleTrips.isEmpty()) {
                        System.out.println(" No trips available for reschedule.");
                    } else {
                        Trip newTrip = possibleTrips.get(0); // pick first available trip
                        bookingService.rescheduleBooking(bookingId, newTrip, newSeat);
                    }
                case 5:
                    System.out.print("Enter booking ID to cancel: ");
                    int cancelId = scanner.nextInt();
                    bookingService.cancelBooking(cancelId);
                    break;
                case 6:
                    System.out.println(" Thank you for using Trip Travels ");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a correct option.");
                    break;
            }
        }
        scanner.close();
    }
}