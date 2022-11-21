public class Main {
    public static void main(String[] args) {
        Registration registration = new Registration(10);


        registration.addBooking(new Booking( "Ivanov", new MyDate(12,11,2022),
                new Standard("Standard", 1, 100),5));
        registration.addBooking(new Booking( "Petrov", new MyDate(14,11,2022),
                new Superior("Superior", 5, 200), 3));
        registration.addBooking(new Booking( "Sidorov", new MyDate(18,11,2022),
                new Deluxe("Deluxe", 7, 300), 6));
        registration.addBooking(new Booking( "Svetlov", new MyDate(16,11,2022),
                new President("President", 8, 500), 2));

        System.out.println(registration.toString());
        System.out.println("-----------------------------------");
        System.out.println("-----Add fitness 10$*night ---------");

        Booking booking = registration.get(1);
        booking.getFitness();
        System.out.println(booking.toString());

        booking = registration.get(3);
        booking.getFitness();
        System.out.println(booking.toString());


    }
}