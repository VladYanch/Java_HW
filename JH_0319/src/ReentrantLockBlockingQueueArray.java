import javax.sound.midi.Track;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Переписать класс ReentrantLockBlockingQueue (См. код в репозитории) так,
// чтобы очередь была на основе массива (ArrayDeque)
// размер очереди задавался через пареметр size в конструкторе
// при попытки положить элемент в заполненную очередь поток-продьюсер ожидал бы освобождение места

// BlockingQueue:
// Класс Продьюсер - генерирует сообщения в очередь
// Класс Консьюмер - забирает сообщения из очереди
// Задача - реализовать класс Consumer,
// который будет анализировать сообщения в очереди и при входящем сообщении "exit" заканчивать работу.
// При реализации можно использовать класс MyBlockingQueue или ReentrantLockBlockingQueue в репозитории
// или одну из стандартных реализаций BlockingQueue из библиотеки.

public class ReentrantLockBlockingQueueArray<T> {

    private Queue<T> queue = new ArrayDeque<>();
    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    private int size;

    private int index;

    public ReentrantLockBlockingQueueArray(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>(size);
    }

    public void put(T item) {
        lock.lock();
        try {
            if (queue.size() < size) {
                queue.add(item);
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        } finally {
            lock.unlock();
        }

    }

    public int getSize(){
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantLockBlockingQueueArray queueArray = new ReentrantLockBlockingQueueArray(5);

        ProducerString producerString = new ProducerString(queueArray,5);
        ConsumerString consumerString = new ConsumerString(queueArray);

        producerString.start();
        consumerString.start();

        try {
            producerString.join();
//            Thread.sleep(5000);
//            consumerString.join();
            Thread.sleep(15000);
//            queueArray.put("exit");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class ProducerString extends Thread {
    private ReentrantLockBlockingQueueArray<String> queue;
    private int size;

    public ProducerString(ReentrantLockBlockingQueueArray queue, int size) {
        this.queue = queue;
        this.size = size;
    }
        @Override
        public void run() {

        try {
            for (int i = 1; i < 10; i++) {
                if (queue.getSize() <= size) {
                    queue.put("message: " + i);
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " message put in: " + i);
                } else wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConsumerString extends Thread {
    private ReentrantLockBlockingQueueArray<String> queue;

    public ConsumerString(ReentrantLockBlockingQueueArray queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                String message = queue.take();
                if (message.equals("exit")) break;
                System.out.println(message + " take out");
//                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

