public class Clothes extends Goods {
    double size;

    public Clothes(String name, double price, double size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes{"  +
                ", name='" + name + '\'' +
                ", price=" + price +
                + "size=" + size +
                '}';
    }
}
