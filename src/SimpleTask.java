import java.util.concurrent.Callable;

/**
 * Created by Hillel on 22.06.2017.
 */
public class SimpleTask implements Callable {
    private final StringsDistributor distributor;

    public SimpleTask(StringsDistributor distributor) {
        this.distributor = distributor;
    }


    @Override
    public Void call() throws Exception {
        while (distributor.hasNext())
        {
            System.out.println(distributor.nextString());
        }
        return null;
    }
}
