public class Ticket {
    public Route route;
    public MyDateTime date;
    double price;

    public Ticket(Route route, MyDateTime date, double price) {
        this.route = route;
        this.date = date;
        this.price = price;
    }

    public String toString() {
        return route +" "+date+" "+"цена: "+price;
    }

}
