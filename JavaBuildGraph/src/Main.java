import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File(args[0].trim());
        String[] formats = new String[]{"A %d %d", "R %d %d", "F %d", "I %d", "C %d %d", "PRINT"};
        Handler handler = new Handler(new Scanner(file), formats);
        Graph graph = new Graph(10);
        Commands<String, Vertices> commands = new Commands<>();
        commands.add("A", graph::connectVertices);
        commands.add("R", graph::disconnect);
        commands.add("F", graph::connectFromAllVertices);
        commands.add("I", graph::disconnectFromAllVertices);
        commands.add("C", graph::swapVertices);
        commands.add("PRINT", graph::print);
        Pair<String, Vertices> ans;
        while ((ans = handler.getCommands()) != null)
            commands.apply(ans.first, ans.second);
    }
}