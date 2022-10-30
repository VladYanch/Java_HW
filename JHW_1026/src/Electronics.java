public class Electronics extends Goods{
    //String[] type = {"mobile","laptop"};
    String type;
    public Electronics(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    String getGarantee() {
        return "Garantee";
    }

    String getContract() {
        return "Contract";
    }

}
