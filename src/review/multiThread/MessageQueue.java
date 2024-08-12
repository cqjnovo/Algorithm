package review.multiThread;


import java.util.LinkedList;

/**
 * @description: 多个生产者进程向队列中存放消息，消费者进程从队列中获取消息
 * @author: lzy
 * @time: 2024/8/12 21:28
 */
class Test{
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);

        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(new Message(id, "messge" + id));
                System.out.println("生产者线程" + Thread.currentThread().getName() + "存入消息");
            }, "producer" + i).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Message message = queue.take();
                System.out.println("消费者线程" + Thread.currentThread().getName() + "取出消息：" + message.getMessage());
            }
        },"consumer" ).start();

    }
}

public class MessageQueue {
    private int capacity;
    private LinkedList<Message> list = new LinkedList<>();

    public MessageQueue(int capacity) {

        this.capacity = capacity;
    }

    //消费者线程调用take方法从队列中获取消息
    public Message take() {
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    System.out.println("队列为空，当前消费者线程" + Thread.currentThread().getName() + "已被阻塞");
                    list.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Message message = list.removeFirst();
            //唤醒因队列已满而被阻塞的生产者线程
            list.notifyAll();
            return message;
        }
    }

    //生产者线程调用put方法向队列中加入消息
    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                try {
                    //队列已满，阻塞当前生产者线程
                    System.out.println("队列已满，当前线程" + Thread.currentThread().getName() + "已被阻塞");
                    list.wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            list.addLast(message);
            //唤醒所有因队列为空而阻塞的消费者线程
            list.notifyAll();
        }
    }
}

/**
 * 消息对象：包含消息id和消息内容
 */
class Message {
    private int id;
    private Object message;

    public Message(int id, Object message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public Object getMessage() {
        return message;
    }
}
