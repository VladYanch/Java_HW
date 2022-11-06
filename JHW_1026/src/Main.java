public class Main {
    public static void main(String[] args) {

        Clothes cloth1 = new Clothes("Jacket", 100, 40);
        Electronics el1= new Electronics("AppleAir", 1000, "laptop");
        Electronics el2= new Electronics("Galaxy20", 1200, "mobile");
        Products food1 = new Products("Milk", 1.5,1);
        Goods[] good = new Goods[]{cloth1, el1, el2, food1};


        for (int i = 0; i < good.length; i++) {
            System.out.println(good[i].name+" : "+good[i].price);
        }

        //Basket[] basket = new Basket[];
        Basket basket = new Basket(good);
        basket.addBasket(food1);
        basket.addBasket(el1);
        basket.checkOut();
    }
}

//Допустим, у нас есть магазин. В нашем магазине есть товары трёх категорий: продукты,
// электроника(мобильные телефоны и ноутбуки), одежда. У каждого товара есть цена и наименование .
// Каждый товар можно купить (покупателю выставляется счет).
//        при покупки продуктов выставляется дополнительная цена за срочность доставки.
//        при покупке электроники, покупателю оформляют гарантию
//        (т.е. при покупке должен выполнятся метод “Оформить гарантию”)
//        телефоны продаются только с контрактом оператора
//        (т.е. при покупке должен выполнятся метод “Оформить контракт”)
//        Необходимо создать соответствующую структуру классов метод покупки товара
