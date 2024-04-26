package javaclass;

public final class Room {
    private int room_number;
    private String room_type;
    private String description;
    private double price;
    private String status;
    
    public Room (int room_number, String room_type,String description, double price, String status){
        this.room_number = room_number;
        this.room_type = room_type;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    
    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
