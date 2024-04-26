package javaclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Admin extends Account{
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    final String role = "Admin";
    private int room_number = 100;
    static ArrayList<Room> room_data = new ArrayList<>();

    public Admin(String email, String username, String password, String role){
        super(email,username,password);

    }

    public Admin(){}

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public ArrayList<Room> getRoomData(){
        return room_data;
    }

    private int RoomType() throws IOException {
        System.out.println("==============================================");
        System.out.println("              R O O M S    T Y P E            ");
        System.out.println("==============================================");
        System.out.println("               1. SINGLE ROOM                 ");
        System.out.println("               2. TWIN ROOM                   ");
        System.out.println("               3. DOUBLE ROOM                 ");
        System.out.println("               4. DELUXE ROOM                 ");
        System.out.println("               5. SUITE ROOM                  ");
        System.out.println("               6. PRESIDENTIAL ROOM           ");
        System.out.println("               0. BACK TO ADMIN MENU          ");
        System.out.println("==============================================");
        System.out.println("                                              ");
        System.out.print(" Enter the choice of room type you want: ");
        return Integer.parseInt(br.readLine());
    }
    
    private void AddRoom() throws IOException {
        User.clearScreen();
        int choice_roomType = RoomType();
    
        String room_type = "";
        switch (choice_roomType) {
            case 1:
                room_type = "SINGLE ROOM";
                break;
            case 2:
                room_type = "TWIN ROOM";
                break;
            case 3:
                room_type = "DOUBLE ROOM";
                break;
            case 4:
                room_type = "DELUXE ROOM";
                break;
            case 5:
                room_type = "SUITE ROOM";
                break;
            case 6:
                room_type = "PRESIDENTIAL ROOM";
                break;
            case 0:
                adminMenu();
                return;
        }
        User.clearScreen();
        System.out.println("===================================================");
        System.out.println("         A  D  D    R  O  O  M    D  A  T  A       ");
        System.out.println("===================================================");
        System.out.println("                                                   ");
        System.out.println("Room Type   : " + room_type);
        System.out.print("Description : ");
        String description = br.readLine();
        System.out.print("Price       : ");
        double price = Double.parseDouble(br.readLine());
        System.out.print("Room Status : ");
        String status = br.readLine();
    
        Room newRoom = new Room(room_number++, room_type, description, price, status);
        room_data.add(newRoom);
        System.out.println("");
        System.out.println("The room data has been successfully added!");
        User.getche();
    }

    @Override
    public void ViewRoom() throws IOException{
        User.clearScreen();
        System.out.println("=====================================");
        System.out.println("      R  O  O  M      D  A  T  A     ");
        System.out.println("=====================================");
        System.out.println("                                     ");
        if (room_data.isEmpty()){
            System.out.println("The room data is empty!");
            User.getche();
        } else {
            super.ViewRoom();

        }
    }

    private void UpdateRoom() throws IOException {
        User.clearScreen();
        if (room_data.isEmpty()) {
            System.out.println("The room data is empty, please fill it in first!");
            User.getche();
        } else {
            ViewRoom();
            User.clearScreen();
            System.out.println("=========================================");
            System.out.println("     E D I T    R E S E R V A T I O N    ");
            System.out.println("=========================================");
            System.out.println("                                         ");
            System.out.print("Enter room type : ");
            String up_room = br.readLine();
            boolean roomFound = false; 
            
            for (int i = 0; i < room_data.size(); i++) {
                Room room_attributes = room_data.get(i);
                if (room_attributes.getRoom_type().equals(up_room)) {
                    roomFound = true; 
                    
                    User.clearScreen();
                    System.out.println("=============================================");
                    System.out.println("       U P D A T E   R O O M   M E N U       ");
                    System.out.println("=============================================");
                    System.out.println("         1. UPDATE ROOM TYPE                 ");
                    System.out.println("         2. UPDATE ROOM PRICE                ");
                    System.out.println("         3. UPDATE ROOM DESCRIPTION          ");
                    System.out.println("         0. BACK TO ADMIN MENU               ");
                    System.out.println("=============================================");
                    System.out.println("                                             ");
                    System.out.print("Enter your choice : ");
                    
                    try {
                        int choice_update = Integer.parseInt(br.readLine());
                        switch (choice_update) {
                            case 1 -> {
                                System.out.print("Room Type                       : ");
                                String newRoom = br.readLine();
                                room_attributes.setRoom_type(newRoom);
                                System.out.println("");
                                System.out.println("Room type updated successfully!");
                                break;
                            }
                            case 2 -> {
                                System.out.print("Price                   : ");
                                double newPrice = Double.parseDouble(br.readLine());
                                room_attributes.setPrice(newPrice);
                                System.out.println("");
                                System.out.println("Room price updated successfully!");
                                break;
                            }
                            case 3 -> {
                                System.out.print("Description             : ");
                                String newDescription = br.readLine();
                                room_attributes.setDescription(newDescription);
                                System.out.println("");
                                System.out.println("Room description updated successfully!");
                                break;
                            }
                            case 0 -> {
                                adminMenu();
                                break;
                            }
                            default -> {
                                System.out.println("Your choice is not valid, please try again!");
                                User.getche();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("");
                        System.out.println("That was not a number!!! Please try again.");
                        User.getche();
                    }
                }
            }
            
            if (!roomFound) { 
                System.out.println("The room type you are looking for is not found in the data.");
                User.getche();
            }
        }
    }
    
    private void DelRoom() throws IOException{
        ViewRoom();
        User.clearScreen();
        System.out.println("=========================================");
        System.out.println("   D E L E T E    R E S E R V A T I O N  ");
        System.out.println("=========================================");
        System.out.println("                                         ");
        if (room_data.isEmpty()){
            System.out.println("The room data is empty, please fill it in first!");
            br.readLine();
        } else {
            System.out.print(  "Enter room number : ");
            int delRoomNum = Integer.parseInt(br.readLine());

            for (int i = 0; i < room_data.size(); i++){
                Room room_attributes = room_data.get(i);
                if (room_attributes.getRoom_number() == delRoomNum){ 
                    room_data.remove(i);
                    System.out.println("");
                    System.out.println("Room with number " + delRoomNum+ " deleted successfully!");
                    break;
                }
            }


        }

    }

    private void viewUserAccount() throws IOException {
        User.clearScreen();
        if (App.UserAccount.isEmpty()){
            System.out.println();
            System.out.println("User data is empty!");br.readLine();
        }
        else {
            System.out.println("==================================================================================");
            System.out.println("     M   A   N   A   G   E       U   S   E   R      A   C   C   O   U   N   T     ");
            System.out.println("==================================================================================");
            System.out.println("|  NO.  |           EMAIL           |       USERNAME       |       PASSWORD      |");
            System.out.println("==================================================================================");
            for (int i = 0; i < App.UserAccount.size(); i++) {
                User user = App.UserAccount.get(i);
                String format = "| %-5d | %-25s | %-20s | %-20s |%n";
                System.out.printf(format, (i + 1), user.getEmail(), user.getUsername(), user.getPassword());
            }
            System.out.println("==================================================================================");
            System.out.println("");
            User.getche();
        }
    }

    private void ManageUser() throws IOException {
        User.clearScreen();
        System.out.println("===================================");
        System.out.println("      MANAGE USER ACCOUNT MENU     ");
        System.out.println("===================================");
        System.out.println("      1. VIEW USER ACCOUNT         ");
        System.out.println("      2. DELETE USER ACCOUNT       ");
        System.out.println("      0. BACK TO ADMIN MENU        ");
        System.out.println("===================================");
        System.out.println("                                   ");
        System.out.print  ("Enter your choice : ");
        int choice_manage = Integer.parseInt(br.readLine());

        switch (choice_manage){
            case 1 -> {
                viewUserAccount();
            }
            case 2 -> {
                viewUserAccount();
                System.out.println("Enter the number of the user account to delete (0 to cancel): ");
                int choice = Integer.parseInt(br.readLine());
                if (choice == 0) {
                    System.out.println("Operation canceled.");
                    return;
                }

                if (choice > 0 && choice <= App.UserAccount.size()) {
                    User deletedUser = App.UserAccount.remove(choice - 1);
                    System.out.println("User account '" + deletedUser.getUsername() + "' has been deleted.");
                } else {
                    System.out.println("Invalid choice.");
                }
                User.getche();
            }
        }
    }
        
    public void adminMenu() throws IOException{
        while (true){
            User.clearScreen();
            System.out.println("===================================");
            System.out.println(" ADMIN MENU OF KING THE LAND HOTEL ");
            System.out.println("===================================");
            System.out.println("      1. ADD ROOM DATA             ");
            System.out.println("      2. VIEW ROOM DATA            ");
            System.out.println("      3. VIEW RESERVATION DATA     ");
            System.out.println("      4. MANAGE USER DATA          ");
            System.out.println("      5. UPDATE ROOM DATA          ");
            System.out.println("      6. DELETE ROOM DATA          ");
            System.out.println("      7. DELETE RESERVATION        ");
            System.out.println("      0. BACK TO MAIN MENU         ");
            System.out.println("===================================");
            System.out.println("                                   ");
            
                System.out.print  ("Enter your choice : ");
                
                try{
                    int choice = Integer.parseInt(br.readLine());
                    switch(choice){
                        case 1 -> {
                            AddRoom();
                            break;
                        }
                        case 2 -> {
                            ViewRoom();
                            break;
                        }
                        case 3 -> {
                            User user = new User();
                            user.read_menu();
                            break;
                        }
                        case 4 -> {
                            ManageUser();
                            break;
                        }
                        case 5 -> {
                            UpdateRoom();
                            break;
                        }
                        case 6 -> {
                            DelRoom();
                            break;
                        }
                        case 7 -> {
                            User user = new User();
                            user.del_menu();
                            break;
                        }
                        case 0 -> {
                            App.mainMenu();
                            break;
                        }
                        default -> {
                            System.out.println("");
                            System.out.println("Your choice is not valid, please try again!");
                            User.getche();
                        }
                    }
                } catch (InputMismatchException e){
                    br.readLine(); 
                    System.out.println("");
                    System.out.println("That was not a number!!! Please try again.");
                    br.readLine(); 
                }
        }
    }
}
