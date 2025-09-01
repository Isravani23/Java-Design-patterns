package service;

import model.Trip;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TripService {
    private List<Trip> trips = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a new Trip
    public void addTrip() {
        System.out.println("\n=== Add New Trip ===");
        System.out.print("Enter Source: ");
        String source = scanner.nextLine();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter Date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Trip trip = new Trip(source, destination, date, price);
        trips.add(trip);

        System.out.println("Trip added successfully: " + trip);
    }

    // Search for trips
    public void searchTrips() {
        System.out.println("\n=== Search Trips ===");
        System.out.print("Enter Source: ");
        String source = scanner.nextLine();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter Date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        boolean found = false;
        for (Trip trip : trips) {
            if (trip.getSource().equalsIgnoreCase(source) &&
                    trip.getDestination().equalsIgnoreCase(destination) &&
                    trip.getJourneyDate().equals(date)) {

                System.out.println(" Found Trip: " + trip);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" No trips found for given details!");
        }
    }
    //search by source, destination, date
    public List<Trip> searchTrips(String source, String destinagtion, LocalDate date){
        return trips.stream().filter(t->t.getSource().equalsIgnoreCase(source)
        &&t.getDestination().equalsIgnoreCase(destinagtion)&&t.getJourneyDate().equals(date))
                .collect(Collectors.toList());
    }
}
