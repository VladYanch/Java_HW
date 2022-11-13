public class Booking {
    private String guestName;
    private MyDate bookingDate;

    public Room room;
    public int night;

    public String fitness;

    public Booking(String guestName, MyDate bookingDate, Room room, int night) {
        this.guestName = guestName;
        this.bookingDate = bookingDate;
        this.room = room;
        this.night = night;
        if (room.roomName == "Standard" || room.roomName == "Superior") {
            this.fitness = "not ordered";
        } else {
            this.fitness = "included";
        }
    }

 //   public void getFitness(Booking booking) {
    public void getFitness() {
        int priceDayFitness = 10;
        if (room.roomName == "Standard" || room.roomName == "Superior") {
            room.price+=priceDayFitness* night;
            fitness = "ordered";
        } else {
            System.out.println("Fitness include in price of room " + room.roomName + " N" + room.roomNumber);
        }

    }


    @Override
    public String toString() {
        return "Booking{" +
                "guestName='" + guestName + '\'' +
                ", bookingDate=" + bookingDate +
                ", room=" + room +
                ", night=" + night +
                ", fitness= " + fitness +
                '}';
    }
}

