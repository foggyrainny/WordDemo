import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2019/6/13.
 */
public  class MyCallableConsumer implements Runnable
{
    private String fileName = "";
    private BlockingQueue<Future<Map<String, FileInputStream>>> queue;
    private FileInputStream fis = null;
    private File dirFile = null;

    private BufferedReader br = null;
    private InputStreamReader isr = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;

    public MyCallableConsumer(BlockingQueue<Future<Map<String, FileInputStream>>> queue2)
    {
        this.queue = queue2;
    }

    @Override
    public void run()
    {
        try {
            Future<Map<String, FileInputStream>> future = queue.take();
            Map<String, FileInputStream> map = future.get();

            Set<String> set = map.keySet();
            for (Iterator<String> iter = set.iterator(); iter.hasNext();)
            {
                fileName = iter.next().toString();
                fis = map.get(fileName);

//                System.out.println(Thread.currentThread().getName() + " 线程开始写文件 ：" + fileName  + " ,时间为 "+ sdf.format(new Date()));
                try {
                    isr = new InputStreamReader(fis, "utf-8");
                    br = new BufferedReader(isr);

                    dirFile = new File("d:" + File.separator + "gc3" + File.separator + fileName);
                    fw = new FileWriter(dirFile);
                    bw = new BufferedWriter(fw);

                    String data = "";
                    bw.write("+++++++++++++" + Thread.currentThread().getName() + " 线程开始写文件++++++++++++");
                    while ((data = br.readLine()) != null) {
                        bw.write(data + "\r");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bw.close();
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


