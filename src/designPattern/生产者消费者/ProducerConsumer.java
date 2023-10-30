package designPattern.生产者消费者;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lz
 * @date 2023/07/09 00:17
 **/
public class ProducerConsumer {

    private final AtomicInteger taskId = new AtomicInteger(1);
    private static final Integer MAX_TASK_ID = 20;
    private final Queue<Integer> taskList = new LinkedBlockingQueue<>();

    public void producer() {
        while (taskId.get() <= MAX_TASK_ID) {
            Integer curTask = taskId.getAndIncrement();
            taskList.add(curTask);
            System.out.println("Produce taskId: " + curTask);
        }
    }

    public void consumer() {
        while (true) {
            //可能会n个线程在这里都能进去，但是任务却没有n个，因此有线程取到null
            if (taskList.size() > 0) {
                Integer curTask = taskList.poll();
                //必须判空
                if (curTask != null) {
                    System.out.println("Consume taskId: " + curTask);
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer ins = new ProducerConsumer();

        for (int i = 0; i < 5; i++) {
            new Thread(ins::producer).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(ins::consumer).start();
        }

    }

}
