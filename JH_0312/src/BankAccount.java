import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    private static AtomicInteger sum = new AtomicInteger(0);

//    private int sum;

    public void deposit(int amount) {
//        sum = sum + amount;
        while (!sum.compareAndSet(sum.get(),amount));
    }

    public void withdraw(int amount) {
//        sum = sum - amount;
        if (sum.get()>=amount)
            sum.addAndGet(-amount);
    }

    public AtomicInteger getSum() {
        return sum;
    }


//    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.deposit(100);
//        bankAccount.withdraw(100);
//        System.out.println(sum);
//        }
}

// 1 уровень сложности: Переписать класс BankAccount (см. код в репозитории) и его методы
//public synchronized void deposit(int amount)
//public synchronized void withdraw(int amount)
//с применением AtomicInteger и принципа compare and swap
//так, чтобы несколько потоков могли одновременно безопасно начислять и снимать деньги со счета,
// не используя при этом синхронизацию.