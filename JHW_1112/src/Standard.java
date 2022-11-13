public class Standard extends Room{

//    private String fitness = "not ordered";

    public Standard(String roomName, int roomNumber, int price) {
        super(roomName, roomNumber, price);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "roomName='" + roomName + '\'' +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                '}';
    }
}
