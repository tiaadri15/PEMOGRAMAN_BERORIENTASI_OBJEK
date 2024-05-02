package javaclass;

import java.time.LocalDate;

// access modifier public
public class Hotel_Reservation{
    //access modifier private
    private int reservation_number;
    private String customer_name;
    private String customer_email;
    private String room_type;
    private LocalDate reservation_date;
    private String check_in;
    private String check_out;
    private double price;
    

    public Hotel_Reservation(){}

    public Hotel_Reservation(int reservation_number, String customer_name, String customer_email, LocalDate reservation_date, String room_type,String check_in, String check_out, double price){
        this.reservation_number = reservation_number;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.room_type = room_type;
        this.reservation_date = reservation_date;
        this.check_in = check_in; 
        this.check_out = check_out;
        this.price = price;
    }

    //getter setter
    public int getReservation_number() {
        return reservation_number;
    }

    public void setReservation_number(int reservation_number) {
        this.reservation_number = reservation_number++;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public LocalDate getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(LocalDate reservation_date) {
        this.reservation_date = reservation_date;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

