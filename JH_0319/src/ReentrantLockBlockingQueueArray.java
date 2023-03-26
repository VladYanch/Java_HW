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

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBlockingQueue<T> {

    private Queue<T> queue;
    private Lock lock = new ReentrantLock(true);
    private Condition queueIsEmpty = lock.newCondition();
    private Condition queueIsFull = lock.newCondition();
    private int size;

    public ReentrantLockBlockingQueue(int size) {
        this.size = size;
        this.queue = new  ArrayDeque<>(size);
    }

    public void put(T item) {
        lock.lock();
        try {
            while (queue.size() >= size) {
                queueIsFull.awaitUninterruptibly();
            }
            queue.add(item);
            queueIsEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                queueIsEmpty.awaitUninterruptibly();
            }
            queueIsFull.signal();
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


}

    private Queue<T> queue;
    private Lock lock = new ReentrantLock(true);
    private Condition queueIsEmpty = lock.newCondition();
    private Condition queueIsFull = lock.newCondition();
    private int size;

    public ReentrantLockBlockingQueue(int size) {
        this.size = size;
        this.queue = new  ArrayDeque<>(size);
    }

    public void put(T item) {
        lock.lock();
        try {
            while (queue.size() >= size) {
                queueIsFull.awaitUninterruptibly();
            }
            queue.add(item);
            queueIsEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                queueIsEmpty.awaitUninterruptibly();
            }
            queueIsFull.signal();
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


}
