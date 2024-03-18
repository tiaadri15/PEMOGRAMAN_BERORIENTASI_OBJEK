package javaclass;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class App {
    static ArrayList<Hotel_Reservation> Reservations = new ArrayList<>();
    static Scanner Rsv = new Scanner(System.in);
    static int reservation_number = 1000;


    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void getche(){
        System.out.println("Press any key to continue ...");
        Rsv.nextLine();
    }

    public static void confim_rsv(){
        System.out.println("");
        System.out.println("Do you want to make a reservation? (y/n) : ");
        String rsv = Rsv.nextLine();
        if (rsv.equals("y") || rsv.equals("Y")){
            add_menu();
        } else if (rsv.equals("n") || rsv.equals("N")){
            Reservation_menu();
        }
    }

    public static void Rooms(){
        clearScreen();
        System.out.println("===================================");
        System.out.println("        R O O M S    T Y P E       ");
        System.out.println("===================================");
        System.out.println("         1. SINGLE ROOM            ");
        System.out.println("         2. TWIN ROOM              ");
        System.out.println("         3. DOUBLE ROOM            ");
        System.out.println("         4. DELUXE ROOM            ");
        System.out.println("         5. SUITE ROOM             ");
        System.out.println("         6. PRESIDENTIAL ROOM      ");
        System.out.println("         0. BACK TO MAIN MENU      ");
        System.out.println("===================================");
        System.out.println("                                   ");
        System.out.print  ("Enter your choice : ");

        try {
            int choice_rooms = Rsv.nextInt();
            Rsv.nextLine();
            System.out.println("");
            switch(choice_rooms){
                case 1:
                    System.out.println("Price : Rp.1.400.000 per night");
                    System.out.println("Facility description : A Single Room typically includes just a bed, a sofa, and a bathroom. The facilities are more limited and it is suitable for one person. ");
                    confim_rsv();
                    break;
                case 2:
                    System.out.println("Price : Rp.2.100.000 per night");
                    System.out.println("Facility description : A Twin Room has two single beds that can be pushed together according to your preference. The rooms have more comprehensive facilities than a Single Room. ");
                    confim_rsv();
                    break;
                case 3:
                    System.out.println("Price : Rp.2.100.000 per night");
                    System.out.println("A Double Room has a large bed that is suitable for two people. ");
                    confim_rsv();
                    break;
                case 4:
                    System.out.println("Price : Rp.3.000.000 per night");
                    System.out.println("Facility description : A Deluxe Room is larger than a Twin Room, with more complete facilities, and some hotels offer a mini-fridge in them. ");
                    confim_rsv();
                    break;
                case 5:
                    System.out.println("Price : 4.200.000 per night");
                    System.out.println("Facility description : A Suite Room is larger than a Deluxe Room, with facilities that include a small living room and a bathroom with a bathtub. ");
                    confim_rsv();
                    break;
                case 6:
                    System.out.println("Price : 7.000.000 per night");
                    System.out.println("Facility description : A Presidential Suite is the largest and most expensive room, with luxurious facilities such as a separate living room, dining room, and more than one bedroom. ");
                    confim_rsv();
                    break;
                case 0:
                    Reservation_menu();
                    break;
                default:
                    System.out.println("Your choice is not valid, please try again!");
                    getche();
            }
        } catch (Exception e) {
            Rsv.nextLine(); // fungsinya mirip getche di c++, ini saya ngide aja bang biar bisa tampil pesan errornya
            System.out.println("");
            System.out.println("That was not a number!!! Please try again.");
            Rsv.nextLine(); // buat buffer
        }
    }
    
    public static void Reservation_menu(){
        clearScreen();
        System.out.println("===================================");
        System.out.println("  KING THE LAND HOTEL RESERVATION  ");
        System.out.println("===================================");
        System.out.println("      1. MAKE A RESERVATION        ");
        System.out.println("      2. VIEW ROOMS TYPE           ");
        System.out.println("      3. VIEW RESERVATION PROOF    ");
        System.out.println("      4. EDIT RESERVATION          ");
        System.out.println("      5. DELETE RESERVATION        ");
        System.out.println("      0. EXIT FROM SYSTEM          ");
        System.out.println("===================================");
        System.out.println("                                   ");
    }

    public static void add_menu(){
        clearScreen();
        System.out.println("===================================================");
        System.out.println("          R E S E R V A T I O N   F O R M          ");
        System.out.println("===================================================");
        System.out.println("                                                   ");
        System.out.print("Name                        : ");
        String customer_name = Rsv.nextLine();
        System.out.print("Email                       : ");
        String customer_email = Rsv.nextLine();
        System.out.print("Room type                   : ");
        String room_type = Rsv.nextLine();
        LocalDate reservation_date = LocalDate.now();
        System.out.print("Check-in date (YYYY-MM-DD)  : ");
        String check_in = Rsv.nextLine();
        System.out.print("Check-out date (YYYY-MM-DD) : ");
        String check_out = Rsv.nextLine();
        
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

    public static void read_menu(){
        clearScreen();
        System.out.println("=====================================");
        System.out.println("  R E S E R V A T I O N   P R O O F  ");
        System.out.println("=====================================");
        System.out.println("                                     ");
        if (Reservations.size() == 0){
            System.out.println("No reservation data found, please make reservation to view");
            
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

    public static void edit_menu(){
        clearScreen();
        System.out.println("=========================================");
        System.out.println("     E D I T    R E S E R V A T I O N    ");
        System.out.println("=========================================");
        System.out.println("                                         ");
        System.out.print(  "Enter customer name : ");
        String editName = Rsv.nextLine();
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
                    int choice_edit = Rsv.nextInt();
                    Rsv.nextLine();
                    System.out.println("");
                    switch(choice_edit){
                        case 1:
                            System.out.print("Email                       : ");
                            String newEmail= Rsv.nextLine();
                            reservation.setCustomer_email(newEmail);
                            System.out.println("");
                            System.out.println("Email updated successfully!");
                            break;
                        case 2:
                            System.out.print("Room type                   : ");
                            String new_RoomType = Rsv.nextLine();
                            reservation.setRoom_type(new_RoomType);
                            System.out.println("");
                            System.out.println("Room type updated successfully!");
                            break;
                        case 3:
                            System.out.print("Check-in date (YYYY-MM-DD)  : ");
                            String new_CheckInDate = Rsv.nextLine();
                            reservation.setCheck_in(new_CheckInDate);
                            System.out.println("");
                            System.out.println("Check-in date updated successfully!");
                            break;
                        case 4:
                            System.out.print("Check-out date (YYYY-MM-DD) : ");
                            String new_CheckOutDate = Rsv.nextLine();
                            reservation.setCheck_out(new_CheckOutDate);
                            System.out.println("");
                            System.out.println("Check-out date updated successfully!");
                            break;
                        case 0:
                            Reservation_menu();
                            break;
                        default:
                            System.out.println("Your choice is not valid, please try again!");
                            getche();
                    }
                } catch (InputMismatchException e){
                    Rsv.nextLine(); // fungsinya mirip getche di c++, ini saya ngide aja bang biar bisa tampil pesan errornya
                    System.out.println("");
                    System.out.println("That was not a number!!! Please try again.");
                    getche();
                    edit_menu();
                    Rsv.nextLine(); // buat buffer
                }
            }
        }
        if (!found) {
            System.out.println("");
            System.out.println("Reservation with name " + editName + " not found.");
        }
        getche();
    }

    public static void del_menu(){
        clearScreen();
        System.out.println("=========================================");
        System.out.println("   D E L E T E    R E S E R V A T I O N  ");
        System.out.println("=========================================");
        System.out.println("                                         ");
        System.out.print(  "Enter customer name : ");
        String delName = Rsv.nextLine();
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

    public static void main(String[] args){
        clearScreen();

        while(true){
            Reservation_menu();
            System.out.print  ("Enter your choice : ");
            
            try{
                int choice = Rsv.nextInt();
                Rsv.nextLine();
                switch(choice){
                    case 1:
                        add_menu();
                        break;
                    case 2:
                        Rooms();
                        break;
                    case 3:
                        read_menu();
                        break;
                    case 4:
                        edit_menu();
                        break;
                    case 5:
                        del_menu();
                        break;
                    case 0:
                        System.out.println("Exiting from system...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Your choice is not valid, please try again!");
                        getche();
                }
            } catch (InputMismatchException e){
                Rsv.nextLine(); // fungsinya mirip getche di c++, ini saya ngide aja bang biar bisa tampil pesan errornya
                System.out.println("");
                System.out.println("That was not a number!!! Please try again.");
                Rsv.nextLine(); // buat buffer
            }
            
        }
    }
}