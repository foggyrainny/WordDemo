import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2019/6/13.
 */
public class TestQueue {

    public static void main(String[] args) {
        File f = new File("C://Users//Administrator//Downloads");
        // 文件总数
        final List<File> filePathsList = new ArrayList<File>();
        File[] filePaths = f.listFiles();
        for (File s : filePaths) {
            filePathsList.add(s);
        }
        System.out.println(filePaths.length);

        CountDownLatch latch = new CountDownLatch(filePathsList.size());
        ExecutorService pool = Executors.newFixedThreadPool(10);

        BlockingQueue<Future<Map<String, FileInputStream>>> queue =
                new ArrayBlockingQueue<Future<Map<String, FileInputStream>>>(10);

        System.out.println("-------------文件读、写任务开始时间：" );
        for (int i = 0; i < filePathsList.size(); i++) {
            File temp = filePathsList.get(i);
            Future<Map<String, FileInputStream>> future = pool.submit(new MyCallableProducer(latch, temp));
            queue.add(future);

            pool.execute(new MyCallableConsumer(queue));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("-------------文件读、写任务结束时间：" + sdf.format(new Date()));
        pool.shutdownNow();

    }
}
