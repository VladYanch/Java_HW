public class Main {
    public static void main(String[] args) {
        Route route1=new Route("1","Berlin", "Paris", 1060);
        MyDateTime date1= new MyDateTime(22,10,2022,12,45);
        Ticket ticket1=new Ticket(route1, date1,500);

        Route route2=new Route("2","Berlin", "Hamburg", 284);
        MyDateTime date2= new MyDateTime(22,10,2022,14,20);
        Ticket ticket2=new Ticket(route2, date2,250);

        Route route3=new Route("3","Hamburg", "Paris", 914);
        MyDateTime date3= new MyDateTime(22,10,2022,15,25);
        Ticket ticket3=new Ticket(route3, date3,250);

        Ticket[] tickets = {ticket1,ticket2,ticket3};

        System.out.println("Общая длина всех маршрутов: "+sumAllDist(tickets));
        System.out.println("Общая сумма всех билетов: "+sumAllPrice(tickets));
        print(tickets);


    }
    public static long sumAllDist(Ticket[] tickets) {
        long sum=0;
        for (int i = 0; i < tickets.length; i++) {
            sum+=tickets[i].route.distance;
        }
        return sum;
    }

    public static long sumAllPrice(Ticket[] tickets) {
        long sum=0;
        for (int i = 0; i < tickets.length; i++) {
            sum+=tickets[i].price;
        }
        return sum;
    }

    public static void print(Ticket[] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            System.out.println(tickets[i].route.toString()+" км, дата: "+tickets[i].date.toString()+" цена "+tickets[i].price); ;
        }
        return;
    }
}

