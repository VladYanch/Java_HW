import java.util.Random;
import java.util.concurrent.Exchanger;

//    необходимо доставить посылки двумя грузовиками
//    грузовик 1 везет: посылка A -> C и посылка A -> D
//    грузовик 2 везет: посылка B -> C и посылка B -> D
//    A  _ _ _ _             _ _ _ _ B
//    \          /
//    - - E - -
//    _ _ _ _ /          \ _ _ _ _
//    C                              D
//
//    E - точка обмена
//    каждый грузовик может отвезти обе посылки, но это не оптимально
//    поэтому необходимо создать пункт E для обмена конечными посылками, так чтобы
//    итоговые конечные точки были одинаковые, то есть
//    грузовик 1: посылка A -> C и A -> D, после обмена: A -> D и B -> D
//    грузовик 2: посылка B -> C и B -> D, после обмена: B -> C и A -> C

public class Truck extends Thread {

    static Random random = new Random();
    String name;
    private String parcel;
    private String parcelChange;
    private Exchanger<String> exchanger = new Exchanger<>();

    public Truck(String name, String parcel, String parcelChange, Exchanger<String> exchanger) {
        this.name = name;
        this.parcel = parcel;
        this.parcelChange = parcelChange;
        this.exchanger = exchanger;
    }

    public String getParcel() {
        return parcelChange;
    }

    public void setParcel(String parcel) {
        this.parcelChange = parcel;
    }

    public void run() {
        System.out.println("Driving from " + name + " with: " + parcel + " " + parcelChange);
        try {
            Thread.sleep(1000);
            System.out.println("Wait for another truck");
            Thread.sleep(new Random().nextInt(5000));
            setParcel(exchanger.exchange(getParcel()));
            Thread.sleep(1000);
            System.out.println("Changing parcels");
            Thread.sleep(1000);
            System.out.println("Delivery parcels " + parcel + " " + parcelChange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Truck truckA = new Truck("A","A->D","A->C",exchanger);
        Truck truckB = new Truck("B","B->C","B->D",exchanger);
        truckA.start();
        truckB.start();
    }
}