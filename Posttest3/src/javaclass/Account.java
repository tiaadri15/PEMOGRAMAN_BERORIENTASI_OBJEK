package javaclass;

//Hierarchical Inheritance
public class Account {
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

    public String getEmail(){
        return email;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }



}
