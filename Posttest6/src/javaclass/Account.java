package javaclass;

import java.io.IOException;

//Hierarchical Inheritance
public abstract class Account {
    protected String email;
    protected String username;
    protected String password;

    public Account(){
        
    }
    public Account(String email, String username,String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public abstract String getEmail();

    public abstract String getUsername();

    public abstract String getPassword();

    public void ViewRoom() throws IOException{
        for (int i = 0; i < Admin.room_data.size(); i++){
            Room room_attributes = Admin.room_data.get(i);
            System.out.println(   "Room number   : " + room_attributes.getRoom_number());
            System.out.println(   "Room type     : " + room_attributes.getRoom_type());
            System.out.println(   "Price         : " + room_attributes.getPrice());
            System.out.println(   "Description   : " + room_attributes.getDescription());
            System.out.println(   "Status        : " + room_attributes.getStatus());
            System.out.println("=====================================");
        }
        System.out.println("");
        User.getche();
    }
}
