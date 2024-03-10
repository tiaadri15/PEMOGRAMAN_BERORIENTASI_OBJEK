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

    public static void confim_rsv(){
        System.out.println("");
        System.out.println("Do you want to make a reservation? (y/n) : ");
        String rsv = Rsv.nextLine();
        if (rsv.equals("y") || rsv.equals("Y")){
            add_menu();
        } else if (rsv.equals("n") || rsv.equals("N")){
            menu();
        }
    }

    public static void Rooms(){
        clearScreen();
        System.out.println("===================================");
        System.out.println("        R O O M     T Y P E S      ");
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
                    menu();
                    break;
                default:
                    System.out.println("Your choice is not valid, please try again!");
                    System.out.print("Press any key to continue...");
                    Rsv.nextLine();
            }
        } catch (Exception e) {
            Rsv.nextLine(); // fungsinya mirip getche di c++, ini saya ngide aja bang biar bisa tampil pesan errornya
            System.out.println("");
            System.out.println("That was not a number!!! Please try again.");
            Rsv.nextLine(); // buat buffer
        }
    }
    
    public static void menu(){
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
        
        Reservations.add(new Hotel_Reservation(reservation_number++, customer_name, customer_email, reservation_date, room_type, check_in, check_out));
        System.out.println("");
        System.out.println("Reservation successful, please see the reservation proof.");
        System.out.print("Press any key to continue...");
        Rsv.nextLine();
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
                System.out.println(   "Reservation number : " + Reservations.get(i).reservation_number);
                System.out.println(   "Customer name      : " + Reservations.get(i).customer_name);
                System.out.println(   "Customer email     : " + Reservations.get(i).customer_email);
                System.out.println(   "Room type          : " + Reservations.get(i).room_type);
                System.out.println(   "Reservation date   : " + Reservations.get(i).reservation_date);
                System.out.println(   "Check in           : " + Reservations.get(i).check_in);
                System.out.println(   "Check out          : " + Reservations.get(i).check_out);
                System.out.println("=====================================");
            }
        }
        System.out.print("Press any key to continue...");
        Rsv.nextLine();
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
            if (reservation.customer_name.equals(editName)){ 
                found = true;

                clearScreen();
                System.out.println("");
                System.out.println("=========================================");
                System.out.println("     E D I T    R E S E R V A T I O N    ");
                System.out.println("=========================================");
                System.out.println("                                         ");
                System.out.println(   "     Enter new data for customer " + editName);
                System.out.println("");
                
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
                            reservation.customer_email = Rsv.nextLine();
                            System.out.println("");
                            System.out.println("Reservation updated successfully!");
                            break;
                        case 2:
                            System.out.print("Room type                   : ");
                            reservation.room_type = Rsv.nextLine();
                            System.out.println("");
                            System.out.println("Reservation updated successfully!");
                            break;
                        case 3:
                            System.out.print("Check-in date (YYYY-MM-DD)  : ");
                            reservation.check_in = Rsv.nextLine();
                            System.out.println("");
                            System.out.println("Reservation updated successfully!");
                            break;
                        case 4:
                            System.out.print("Check-out date (YYYY-MM-DD) : ");
                            reservation.check_out = Rsv.nextLine();
                            System.out.println("");
                            System.out.println("Reservation updated successfully!");
                            break;
                        case 0:
                            menu();
                            break;
                        default:
                            System.out.println("Your choice is not valid, please try again!");
                            System.out.print("Press any key to continue...");
                            Rsv.nextLine();
                    }
                } catch (InputMismatchException e){
                    Rsv.nextLine(); // fungsinya mirip getche di c++, ini saya ngide aja bang biar bisa tampil pesan errornya
                    System.out.println("");
                    System.out.println("That was not a number!!! Please try again.");
                    Rsv.nextLine(); // buat buffer
                }
            }
        }
        if (!found) {
            System.out.println("");
            System.out.println("Reservation with name " + editName + " not found.");
        }
        System.out.print("Press any key to continue...");
        Rsv.nextLine();
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
            if (reservation.customer_name.equals(delName)){ 
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
        System.out.print("Press any key to continue...");
        Rsv.nextLine();
    }

    public static void main(String[] args){
        clearScreen();

        while(true){
            menu();
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
                        System.out.print("Press any key to continue...");
                        Rsv.nextLine();
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
