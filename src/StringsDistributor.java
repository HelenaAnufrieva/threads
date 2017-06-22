import java.util.List;

/**
 * Created by Hillel on 22.06.2017.
 */
public class StringsDistributor {
    private final List<String> strings;

    public StringsDistributor(List<String> strings)
    {
        this.strings = strings;
    }

    public String nextString()
    {
        synchronized (strings)
        {
            String string = strings.get(0);
            strings.remove(0);
            return string;
        }
    }

    public boolean hasNext()
    {
        synchronized (strings)
        {
            return !strings.isEmpty();
        }
    }
}
