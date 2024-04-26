package javaclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Receptionist extends Account {
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    final String role = "Receptionist";

    public Receptionist (String email, String username, String password, String role){
        super(email,username,password);
    }

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

    final void menuRcpt() throws IOException{
        while (true){
            User.clearScreen();
            System.out.println("==========================================");
            System.out.println(" RECEPTIONIST MENU OF KING THE LAND HOTEL ");
            System.out.println("==========================================");
            System.out.println("           1. VIEW ROOM DATA              ");
            System.out.println("           2. VIEW RESERVATION DATA       ");
            System.out.println("           0. BACK TO MAIN MENU           ");
            System.out.println("==========================================");
            System.out.println("                                          ");
            
            try {
                System.out.print  ("Enter your choice : ");
                int choice = Integer.parseInt(br.readLine());
                switch(choice){
                    case 1 -> {
                        ViewRoom();
                        break;
                    }
                    case 2 -> {
                        User user = new User();
                        user.read_menu();
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
