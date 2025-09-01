package model;

import java.time.LocalDate;

public class Trip {
    private int tripId;
    private String source;
    private String destination;
    private LocalDate journeyDate;
    private String busNumber;
    private int totalSeats;
    private int availableSeats;
    private double price;

    public Trip(int tripId, String source, String destination,
                LocalDate journeyDate, String busNumber,
                int totalSeats, double price) {
        this.tripId = tripId;
        this.source = source;
        this.destination = destination;
        this.journeyDate = journeyDate;
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // initially all seats are available
        this.price = price;
    }

    public Trip(String source, String destination, LocalDate date, double price) {
        this.source=source;
        this.destination=destination;
        this.price=price;
    }

    // Getters & Setters
    public int getTripId() { return tripId; }
    public void setTripId(int tripId) { this.tripId = tripId; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getJourneyDate() { return journeyDate; }
    public void setJourneyDate(LocalDate journeyDate) { this.journeyDate = journeyDate; }

    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    public double getFare() { return price; }
    public void setFare(double fare) { this.price = fare; }

    // Method to book a seat
    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    // Method to cancel a seat
    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    @Override
    public String toString() {
        return "Trip [tripId=" + tripId +
                ", source=" + source +
                ", destination=" + destination +
                ", date=" + journeyDate +
                ", busNumber=" + busNumber +
                ", price=" + price +
                ", availableSeats=" + availableSeats + "/" + totalSeats + "]";
    }
}
