public class President extends Room{

//    private String fitness = "included";

    public President(String roomName, int roomNumber, int price) {
    super(roomName, roomNumber, price);
}

    @Override
    public int getPrice() {
        return price;
    }

    public String toString() {
        return "President{" +
                "roomName='" + roomName + '\'' +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                '}';
    }
}
