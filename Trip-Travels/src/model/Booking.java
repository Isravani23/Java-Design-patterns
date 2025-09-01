package model;

import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private User user;         // Who booked
    private Trip trip;         // Which trip
    private int seatNumber;
    private double amount;
    private LocalDateTime bookingTime;
    private String status;     // CONFIRMED, CANCELLED

    public Booking(int bookingId, User user, Trip trip, int seatNumber) {
        this.bookingId = bookingId;
        this.user = user;
        this.trip = trip;
        this.seatNumber = seatNumber;
        this.amount = trip.getFare();
        this.bookingTime = LocalDateTime.now();
        this.status = "CONFIRMED";

        // Reduce seat count in Trip
        if (!trip.bookSeat()) {
            this.status = "FAILED";
        }
    }

    // Getters & Setters
    public int getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public Trip getTrip() { return trip; }
    public int getSeatNumber() { return seatNumber; }
    public double getAmount() { return amount; }
    public LocalDateTime getBookingTime() { return bookingTime; }
    public String getStatus() { return status; }

    public void cancelBooking() {
        if (status.equals("CONFIRMED")) {
            status = "CANCELLED";
            trip.cancelSeat(); // release seat back to trip
        }
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId +
                ", user=" + user.getFirstName() +
                ", tripId=" + trip.getTripId() +
                ", from=" + trip.getSource() +
                ", to=" + trip.getDestination() +
                ", seatNumber=" + seatNumber +
                ", fare=" + amount +
                ", status=" + status +
                ", bookingTime=" + bookingTime + "]";
    }
}
