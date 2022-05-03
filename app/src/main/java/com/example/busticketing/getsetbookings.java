package com.example.busticketing;

public class getsetbookings {
    String tickets_id;
    public  getsetbookings()
    {

    }

    public getsetbookings(String tickets_id) {
        this.tickets_id = tickets_id;
    }

    public String getTickets_id() {
        return tickets_id;
    }

    public void setTickets_id(String tickets_id) {
        this.tickets_id = tickets_id;
    }
}
