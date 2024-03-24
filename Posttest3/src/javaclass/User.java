package javaclass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User extends Account{
    static ArrayList<Hotel_Reservation> Reservations = new ArrayList<>();
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    static int reservation_number = 1000;
    private String role = "User";

    public User(String email, String username, String password, String role){
        super(email,username,password);
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void getche() throws IOException{
        System.out.println("Press any key to continue ...");
        br.readLine();
    }

    public static void Viewroom() throws IOException{
            Admin admin = new Admin();
            ArrayList<Room> rooms = admin.getRoomData();
            System.out.println("=====================================");
            System.out.println("      R  O  O  M      D  A  T  A     ");
            System.out.println("=====================================");
            System.out.println("                                     ");
            if (rooms.isEmpty()){
                System.out.println("The room data is empty");
                br.readLine();
            } else {
                for (int i = 0; i < rooms.size(); i++){
                    Room room_attributes = rooms.get(i);
                    System.out.println(   "Room number   : " + room_attributes.getRoom_number());
                    System.out.println(   "Room type     : " + room_attributes.getRoom_type());
                    System.out.println(   "Price         : " + room_attributes.getPrice());
                    System.out.println(   "Description   : " + room_attributes.getDescription());
                    System.out.println("=====================================");
                }

            }

    }

    public static void confim_rsv() throws IOException{
        System.out.println("");
        System.out.println("Do you want to make a reservation? (y/n) : ");
        String rsv = br.readLine();
        if (rsv.equals("y") || rsv.equals("Y")){
            add_menu();
        } else if (rsv.equals("n") || rsv.equals("N")){
            Reservation_menu();
        }
    }
    
    public static void Reservation_menu(){
        clearScreen();
        System.out.println("===================================");
        System.out.println("  KING THE LAND HOTEL RESERVATION  ");
        System.out.println("===================================");
        System.out.println("      1. MAKE A RESERVATION        ");
        System.out.println("      2. VIEW ROOM                 ");
        System.out.println("      3. VIEW RESERVATION PROOF    ");
        System.out.println("      4. EDIT RESERVATION          ");
        System.out.println("      5. DELETE RESERVATION        ");
        System.out.println("      0. BACK TO MAIN MENU         ");
        System.out.println("===================================");
        System.out.println("                                   ");
    }

    public static void add_menu() throws IOException{
        clearScreen();
        System.out.println("===================================================");
        System.out.println("          R E S E R V A T I O N   F O R M          ");
        System.out.println("===================================================");
        System.out.println("                                                   ");
        if (Admin.room_data.isEmpty()) {
            System.out.println("The rooms are empty, you cannot make a reservation.");
            getche();
        } else {
            System.out.print("Name                        : ");
            String customer_name = br.readLine();
            
            String customer_email = "";
            boolean validEmailFormat = false;
            while (!validEmailFormat) {
                System.out.print("Email                       : ");
                customer_email = br.readLine();
                if (customer_email.contains("@")) {
                    validEmailFormat = true;
                } else {
                    System.out.println("Invalid email format! Please enter a valid email address.");
                }
            }
            System.out.print("Room type                   : ");
            String room_type = br.readLine();
            LocalDate reservation_date = LocalDate.now();

            String check_in = "";
            boolean validCheckInFormat = false;
            while (!validCheckInFormat) {
                System.out.print("Check-in date (YYYY-MM-DD)  : ");
                check_in = br.readLine();
                if (check_in.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    validCheckInFormat = true;
                } else {
                    System.out.println("Invalid date format! Please enter the date in YYYY-MM-DD format.");
                }
            }

            String check_out = "";
            boolean validCheckOutFormat = false;
            while (!validCheckOutFormat) {
                System.out.print("Check-out date (YYYY-MM-DD) : ");
                check_out = br.readLine();
                if (check_out.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    validCheckOutFormat = true;
                } else {
                    System.out.println("Invalid date format! Please enter the date in YYYY-MM-DD format.");
                }
            }
            
            Hotel_Reservation reservation = new Hotel_Reservation();
            reservation.setReservation_number(reservation_number++);
            reservation.setCustomer_name(customer_name);
            reservation.setCustomer_email(customer_email);
            reservation.setRoom_type(room_type);
            reservation.setReservation_date(reservation_date);
            reservation.setCheck_in(check_in);
            reservation.setCheck_out(check_out);

            Reservations.add(reservation);

            System.out.println("");
            System.out.println("Reservation successful, please see the reservation proof.");
            getche();
            clearScreen();
        }
        
    }

    public static void read_menu()throws IOException{
        clearScreen();
        System.out.println("=====================================");
        System.out.println("  R E S E R V A T I O N   P R O O F  ");
        System.out.println("=====================================");
        System.out.println("                                     ");
        if (Reservations.size() == 0){
            System.out.println("No reservation data found, please make reservation to view");
            getche();
        } else {
            for (int i = 0; i < Reservations.size(); i++){
                Hotel_Reservation Reservation = Reservations.get(i);
                System.out.println(   "Reservation number : " + Reservation.getReservation_number());
                System.out.println(   "Customer name      : " + Reservation.getCustomer_name());
                System.out.println(   "Customer email     : " + Reservation.getCustomer_email());
                System.out.println(   "Room type          : " + Reservation.getRoom_type());
                System.out.println(   "Reservation date   : " + Reservation.getReservation_date());
                System.out.println(   "Check in           : " + Reservation.getCheck_in());
                System.out.println(   "Check out          : " + Reservation.getCheck_out());
                System.out.println("=====================================");
            }
        }
        getche();
    }

    public static void edit_menu() throws IOException{
        clearScreen();
        System.out.println("=========================================");
        System.out.println("     E D I T    R E S E R V A T I O N    ");
        System.out.println("=========================================");
        System.out.println("                                         ");
        if (Reservations.size() == 0){
            System.out.println("No reservation data found, please make reservation to view");
            getche();
        }
        else {
            System.out.print(  "Enter customer name : ");
            String editName = br.readLine();
            boolean found = false;

            for (int i = 0; i < Reservations.size(); i++){
                Hotel_Reservation reservation = Reservations.get(i);
                if (reservation.getCustomer_name().equals(editName)){ 
                    found = true;

                    clearScreen();
                    System.out.println("");
                    System.out.println("=========================================");
                    System.out.println("     E D I T    R E S E R V A T I O N    ");
                    System.out.println("=========================================");
                    System.out.println("                                         ");
                    System.out.println(   "     Enter new data for customer " + editName);
                    System.out.println("");
                    
                    getche();
                    clearScreen();
                    System.out.println("===================================");
                    System.out.println("       EDIT RESERVATION MENU       ");
                    System.out.println("===================================");
                    System.out.println("      1. EDIT CUSTOMER EMAIL       ");
                    System.out.println("      2. EDIT ROOM TYPE            ");
                    System.out.println("      3. EDIT CHECK IN DATE        ");
                    System.out.println("      4. EDIT CHECK OUT DATE       ");
                    System.out.println("      0. BACK TO MAIN MENU         ");
                    System.out.println("===================================");
                    System.out.println("                                   ");
                    System.out.print  ("Enter your choice : ");
                    try {
                        int choice_edit = Integer.parseInt(br.readLine());
                        br.readLine();
                        System.out.println("");
                        switch(choice_edit){
                            case 1 -> {
                                System.out.print("Email                       : ");
                                String newEmail= br.readLine();
                                reservation.setCustomer_email(newEmail);
                                System.out.println("");
                                System.out.println("Email updated successfully!");
                                break;
                            }
                            case 2 ->{
                                System.out.print("Room type                   : ");
                                String new_RoomType = br.readLine();
                                reservation.setRoom_type(new_RoomType);
                                System.out.println("");
                                System.out.println("Room type updated successfully!");
                                break;
                            }
                            case 3 -> {
                                System.out.print("Check-in date (YYYY-MM-DD)  : ");
                                String new_CheckInDate = br.readLine();
                                reservation.setCheck_in(new_CheckInDate);
                                System.out.println("");
                                System.out.println("Check-in date updated successfully!");
                                break;
                            }
                            case 4->{
                                System.out.print("Check-out date (YYYY-MM-DD) : ");
                                String new_CheckOutDate = br.readLine();
                                reservation.setCheck_out(new_CheckOutDate);
                                System.out.println("");
                                System.out.println("Check-out date updated successfully!");
                                break;
                            }
                            case 0 -> {
                                Reservation_menu();
                                break;
                            }
                            default -> {
                                System.out.println("Your choice is not valid, please try again!");
                                getche();
                            }
                        }
                    } catch (InputMismatchException e){
                        br.readLine(); 
                        System.out.println("");
                        System.out.println("That was not a number!!! Please try again.");
                        getche();
                        edit_menu();
                        br.readLine();
                    }
                }
            }
            if (!found) {
                System.out.println("");
                System.out.println("Reservation with name " + editName + " not found.");
            }
            getche();
            } 
    }

    public static void del_menu() throws IOException{
        clearScreen();
        System.out.println("=========================================");
        System.out.println("   D E L E T E    R E S E R V A T I O N  ");
        System.out.println("=========================================");
        System.out.println("                                         ");

        if (Reservations.size() == 0){
            System.out.println("No reservation data found, please make reservation to view");
            getche();
        } else {
            System.out.print(  "Enter customer name : ");
            String delName = br.readLine();
            boolean foundName = false;

            for (int i = 0; i < Reservations.size(); i++){
                Hotel_Reservation reservation = Reservations.get(i);
                if (reservation.getCustomer_name().equals(delName)){ 
                    foundName = true;
                    Reservations.remove(i);
                    System.out.println("");
                    System.out.println("Reservation with name " + delName + " deleted successfully!");
                    break;
                }
            }
            if (!foundName) {
                System.out.println("");
                System.out.println("Reservation with name " + delName + " not found.");
            }
            getche();
        }
        
    }

    public static void menu() throws IOException{
        clearScreen();

        while(true){
            Reservation_menu();
            System.out.print  ("Enter your choice : ");
            
            try{
                int choice = Integer.parseInt(br.readLine());
                br.readLine();
                switch(choice){
                    case 1 -> {
                        add_menu();
                        break;
                    }
                    case 2 -> {
                        Admin.ViewRoom();
                        break;
                    }
                    case 3 -> {
                        read_menu();
                        break;
                    }
                    case 4 -> {
                        edit_menu();
                        break;
                    }
                    case 5 -> {
                        del_menu();
                        break;
                    }
                    case 0 -> {
                        App.mainMenu();
                        break;
                    }
                    default -> {
                        System.out.println("");
                        System.out.println("Your choice is not valid, please try again!");
                        getche();
                    }
                }
            } catch (InputMismatchException e){
                br.readLine(); // fungsinya mirip getche di c++, ini saya ngide aja bang biar bisa tampil pesan errornya
                System.out.println("");
                System.out.println("That was not a number!!! Please try again.");
                br.readLine(); // buat buffer
            }
            
        }
    }
    
}
