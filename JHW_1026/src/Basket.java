public class Basket {

    int basketSize;
    double basketSum;

    Goods[] baskets;

    public Basket(Goods[] baskets) {
        this.baskets = baskets;
    }

    public void addBasket(Goods basket) {
        baskets[basketSize] = basket;
        this.basketSize++;
    }

    public Goods[] getBasket() {
        return baskets;
    }

    public void checkOut() {

        for (int i = 0; i < baskets.length; i++) {
            double basketSum = 0;
            basketSum += baskets[i].price;
            System.out.println(baskets[i].name+baskets[i].price);
        }
        System.out.println("Общая сумма: "+toString(basketSum));
    }

    private String toString(double basketSum) {
    }

}

