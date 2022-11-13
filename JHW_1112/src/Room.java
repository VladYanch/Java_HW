public abstract class Room {
    String roomName;
    int roomNumber;
    public int price;

    private String fitness;
//    public boolean status;

    public Room(String roomName, int roomNumber, int price) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.price = price;
    //    status = true;
    }

    public abstract int getPrice();


}
