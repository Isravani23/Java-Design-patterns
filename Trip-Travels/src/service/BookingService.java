package service;

import model.Booking;
import model.Trip;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private int bookingCounter = 1;

    // Create a booking
    public Booking createBooking(User user, Trip trip, int seatNumber) {
        Booking booking = new Booking(bookingCounter++, user, trip, seatNumber);
        if (!booking.getStatus().equals("FAILED")) {
            bookings.add(booking);
            System.out.println(" Booking successful: " + booking);
        } else {
            System.out.println(" Booking failed. No seats available.");
        }
        return booking;
    }

    // Cancel booking
    public void cancelBooking(int bookingId) {
        Optional<Booking> bookingOpt = bookings.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst();

        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.cancelBooking();
            System.out.println(" Booking cancelled: " + booking);
        } else {
            System.out.println(" Booking not found with ID: " + bookingId);
        }
    }

    // List all bookings
    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println(" No bookings found.");
        } else {
            bookings.forEach(System.out::println);
        }
    }
  //reschedule booking
    public void rescheduleBooking(int bookingId, Trip newTrip, int newSeatNumber) {
        Optional<Booking> bookingOpt = bookings.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst();

        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();

            if (booking.getStatus().equals("CONFIRMED")) {
                // Cancel old booking
                booking.cancelBooking();

                // Create new booking with same user
                Booking newBooking = new Booking(bookingCounter++, booking.getUser(), newTrip, newSeatNumber);

                if (!newBooking.getStatus().equals("FAILED")) {
                    bookings.add(newBooking);
                    System.out.println(" Booking rescheduled successfully: " + newBooking);
                } else {
                    System.out.println(" Reschedule failed. No seats available in new trip.");
                }
            } else {
                System.out.println(" Cannot reschedule. Booking is not active.");
            }
        } else {
            System.out.println(" Booking not found with ID: " + bookingId);
        }
    }
    public void viewBookingsForUser(User user) {
        System.out.println("\n Your Bookings:");
        bookings.stream()
                .filter(b -> b.getUser().equals(user))
                .forEach(System.out::println);
    }

}
