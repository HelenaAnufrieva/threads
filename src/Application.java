import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Hillel on 22.06.2017.
 */
public class Application implements Runnable {
    private final int nThreads = 30;
    private final ExecutorService pool = Executors.newFixedThreadPool(nThreads);

    @Override
    public void run() {

        List<String> strings = new LinkedList<>();
        for (int i = 0; i < 50; i++)
        {
            StringBuilder string = new StringBuilder();
            for (int j = 0; j < 5; j++)
            {
                string.append(String.valueOf(i));
            }
            strings.add(string.toString());
        }

        StringsDistributor distributor = new StringsDistributor(strings);
        List<SimpleTask> tasks = new LinkedList<>();

       for (int i = 0; i < nThreads; i++)
           tasks.add(new SimpleTask(distributor));

            /*try {
                List<Future<Void>> futures = pool.invokeAll(tasks);

                boolean isDone = false;
                while (!isDone)
                {
                    for (Future<Void> future : futures)
                    {
                        if (!future.isDone())
                            continue;
                            isDone = true;
                    }
                }

            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }*/


        //    ForkJoinPool.commonPool();
        //    RecursiveTask;
        }


    public void cleanup()
    {
        pool.shutdown();
    }
}
