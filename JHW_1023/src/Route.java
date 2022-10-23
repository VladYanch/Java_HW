public class Route {
    String number, from,destination ;
    long distance;

    public Route(String number, String from, String destination, long distance) {
        this.number = number;
        this.from = from;
        this.destination = destination;
        this.distance = distance;
    }

    public String toString() {
        return "№ "+number+" от "+from+" до "+destination+" расстояние: "+distance;
    }
}
