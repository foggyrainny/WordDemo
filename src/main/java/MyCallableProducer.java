import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2019/6/13.
 */
public class MyCallableProducer implements Callable<Map<String, FileInputStream>> {
    private CountDownLatch latch;
    private File file;
    private FileInputStream fis = null;
    private Map<String, FileInputStream> fileMap = new HashMap<String, FileInputStream>();

    public MyCallableProducer(CountDownLatch latch, File file) {
        this.latch = latch;
        this.file = file;
    }

    @Override
    public Map<String, FileInputStream> call() throws Exception {
//        System.out.println(Thread.currentThread().getName() + " 线程开始读取文件 ：" + file.getName() + " ,时间为 "+ sdf.format(new Date()));
        fis = new FileInputStream(file);
//        TestTxt.readWantedText(fis,"");
        System.out.println(fis);
        fileMap.put(file.getName(), fis);
        doWork();
//        System.out.println(Thread.currentThread().getName() + " 线程读取文件 ：" + file.getName() + " 完毕"  + " ,时间为 "+ sdf.format(new Date()));
        latch.countDown();
        return fileMap;
    }

    private void doWork() {
        //此方法可以添加一些业务逻辑，如何包装一些pojo等，返回值可以是任何类型
        Random rand = new Random();
        int time = rand.nextInt(10) * 1000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

