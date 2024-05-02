package javaclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static ArrayList<User> UserAccount = new ArrayList<>();

    public static void sleep(){
        try {
            for (int i = 3; i >= 1; i--) {
                System.out.print("You will be redirected to the next page. Please wait for " + i + " seconds!\r");
                Thread.sleep(1000);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mainMenu () throws IOException{
        Admin adminAccount = new Admin("admin123@gmail.com", "admin", "admin123", "Admin");
        Receptionist rcptAccount = new Receptionist("receptionist345@gmail.com", "receptionist", "receptionist123", "Receptionist");
        boolean loggedIn = false;

        while (true) {
            User.clearScreen();
            System.out.println("===================================");
            System.out.println("   WELCOME TO KING THE LAND HOTEL  ");
            System.out.println("===================================");
            System.out.println("         1. MAKE AN ACCOUNT        ");
            System.out.println("         2. LOGIN                  ");
            System.out.println("         0. EXIT FROM SYSTEM       ");
            System.out.println("===================================");
            System.out.println("                                   ");
            System.out.print  ("Enter your choice : ");

            try {
                int choice_menu = Integer.parseInt(br.readLine());
                System.out.println("");
                while (true) {
                    switch(choice_menu){
                        case 1 -> {
                            User.clearScreen();
                            System.out.println("===================================");
                            System.out.println("          REGISTRATION             ");
                            System.out.println("===================================");
    
                            System.out.print("Enter your email    : ");
                            String email = br.readLine();
                            // Validasi format email
                            if (!email.contains("@")) {
                                System.out.println("Invalid email format! Please enter a valid email address.");
                                User.getche();
                                break;
                            }
                            System.out.print("Enter your username : ");
                            String username = br.readLine();
                            
                            if (username.length() > 8 && username.length() < 1) {
                                System.out.println("Username length cannot exceed 8 characters! Please choose a shorter username.");
                                User.getche();
                                break;
                            }
    
                            System.out.print("Enter your password : ");
                            String password = br.readLine();
                            
                            if (password.length() > 8 && password.length() < 1) {
                                System.out.println("Password length cannot exceed 8 characters! Please choose a shorter password.");
                                User.getche();
                                break;
                            }
                            
                            boolean containsLetter = false;
                            boolean containsDigit = false;
                            for (char c : password.toCharArray()) {
                                if (Character.isLetter(c)) {
                                    containsLetter = true;
                                } else if (Character.isDigit(c)) {
                                    containsDigit = true;
                                }
                            }
                        
                            if (!containsLetter || !containsDigit) {
                                System.out.println("Password must contain both letters and digits! Please choose a valid password.");
                                User.getche();
                                break;
                            }
                        
                            User newUser = new User(email, username, password, "User");
                            UserAccount.add(newUser);
                        
                            System.out.println("");
                            System.out.println("Registration successful!");
                            sleep();
                            loggedIn = true;
                            mainMenu();
                            break;
                        }
                        
                        case 2 -> {
                            User.clearScreen();
                            System.out.println("===================================");
                            System.out.println("             LOGIN                ");
                            System.out.println("===================================");
                            System.out.print("Enter your username : ");
                            String Username = br.readLine();
                            System.out.print("Enter your password : ");
                            String Password = br.readLine();
    
                            if (Username.equalsIgnoreCase(adminAccount.getUsername()) && Password.equalsIgnoreCase(adminAccount.getPassword())) {
                                System.out.println("");
                                System.out.println("Admin login successful!");
                                loggedIn = true;
                                sleep();
                                adminAccount.adminMenu();
    
                            } else if (Username.equalsIgnoreCase(rcptAccount.getUsername()) && Password.equalsIgnoreCase(rcptAccount.getPassword())){
                                System.out.println("");
                                System.out.println("Receptionist login successful!");
                                loggedIn = true;
                                sleep();
                                rcptAccount.menuRcpt();
                            }else {
                                for (int i = 0; i < UserAccount.size(); i++) {
                                    User user = UserAccount.get(i);
                                    User currentUser;
                                   
                                    if (Username.equalsIgnoreCase(user.getUsername()) && Password.equals(user.getPassword())) {
                                        System.out.println("");
                                        System.out.println("User login successful!"); 
                                        currentUser = user;
                                        loggedIn = true;
                                        sleep();
                                        currentUser.menu(); // Menggunakan currentUser untuk memanggil menu()
                                        break;
                                    }
                                    
                                }                            
                                if (!loggedIn) {
                                    System.out.println();
                                    System.out.println("Invalid username or password. Please try again (0 to go back) ");
                                    int choice = Integer.parseInt(br.readLine());
                                    if (choice == 0){
                                        mainMenu();
                                    }
                                    User.getche();
                                    }
                            } 
                            break;
                        }
                        case 0 -> {
                            System.out.println("Exiting the system...");
                            sleep();
                            System.exit(0);
                            break;
                        }
                        default -> {
                            System.out.println();
                            System.out.println("Invalid choice. Please enter a valid option.");
                            User.getche();
                        }
                    }
                }
                
            } catch (IOException e) {
                System.out.println();
                System.out.println("Error reading input. Please try again."); 
                User.getche();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number."); 
                User.getche();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        mainMenu();
    }

}