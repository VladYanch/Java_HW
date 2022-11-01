public class Products extends Goods {
    double priceSpeedDelivery;

    public Products(String name, double price, double priceDelivery) {
        super(name, price);
        this.priceSpeedDelivery = priceDelivery;
    }

    double getPrice (double price) {

        return price+priceSpeedDelivery;
    }
}
