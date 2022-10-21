import java.util.HashMap;
import java.util.Set;
import java.util.function.Predicate;

public class Commands<Key, Arg> {
    private final HashMap<Key, Predicate<Arg>> commands = new HashMap<>();

    public Set<Key> getCommands()
    {
        return commands.keySet();
    }

    public boolean containsCommand(Key key){
        return commands.containsKey(key);
    }

    public void putCommands(Key key, Predicate<Arg> arg){
        commands.put(key, arg);
    }

    public boolean apply(Key key, Arg arg)
    {
        if(!commands.containsKey(key)) return false;
        commands.get(key).test(arg);
        return true;
    }
    public boolean apply(Pair<Key, Arg> pair){
        if(!commands.containsKey(pair.first)) return false;
        commands.get(pair.first).test(pair.second);
        return true;
    }

    public boolean add(Key key, Predicate<Arg> arg)
    {
        if(commands.containsKey(key)) return false;
        commands.put(key, arg);
        return true;
    }
}

