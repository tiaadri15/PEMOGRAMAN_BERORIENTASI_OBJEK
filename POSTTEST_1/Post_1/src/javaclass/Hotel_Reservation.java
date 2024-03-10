package javaclass;

import java.time.LocalDate;

public class Hotel_Reservation{
    int reservation_number;
    String customer_name;
    String customer_email;
    String room_type;
    LocalDate reservation_date;
    String check_in;
    String check_out;

    public Hotel_Reservation(int reservation_number, String customer_name, String customer_email, LocalDate reservation_date, String room_type,String check_in, String check_out){
        this.reservation_number = reservation_number;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.room_type = room_type;
        this.reservation_date = reservation_date;
        this.check_in = check_in; 
        this.check_out = check_out;
    }
}
