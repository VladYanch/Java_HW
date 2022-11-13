public class Deluxe extends Room{

//    private String fitness = "included";
    public Deluxe(String roomName, int roomNumber, int price) {
        super(roomName, roomNumber, price);
    }

    @Override
    public int getPrice() {
        return price;
    }
    public String toString() {
        return "Deluxe{" +
                "roomName='" + roomName + '\'' +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                '}';
    }
}
