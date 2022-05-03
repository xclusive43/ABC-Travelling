package com.example.busticketing;

public class getandsettickets1 {

    String totalseats,remainingseats,bookedseats;

    public getandsettickets1() {
    }

    public getandsettickets1(String totalseats, String remainingseats, String bookedseats) {
        this.totalseats = totalseats;
        this.remainingseats = remainingseats;
        this.bookedseats = bookedseats;
    }

    public String getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(String totalseats) {
        this.totalseats = totalseats;
    }

    public String getRemainingseats() {
        return remainingseats;
    }

    public void setRemainingseats(String remainingseats) {
        this.remainingseats = remainingseats;
    }

    public String getBookedseats() {
        return bookedseats;
    }

    public void setBookedseats(String bookedseats) {
        this.bookedseats = bookedseats;
    }
}
