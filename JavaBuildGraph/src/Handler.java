import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Handler {
    private final Scanner input;
    private final String[] formats;

    public Handler(Scanner input, String[] formats)
    {
        this.input = input;
        this.formats = formats;
    }
    public Pair<String, Vertices> getCommands(){
        List<Integer> args = new ArrayList<>();
        boolean isCommand = true;
        String command = "";
        int cnt = 0;
        while (input.hasNext()){
            for (String s: input.nextLine().trim().split("\\s+")){
                if (cnt > 0 && s.matches("[0-9]+")){
                    --cnt;
                    args.add(Integer.parseInt(s));
                    if (cnt == 0) return new Pair<>(command, new Vertices(args.toArray(new Integer[0])));
                } else {
                    cnt = checkCommand(s);
                    if (cnt == 0) return new Pair<>(s, new Vertices());
                    command = s;
                    args.clear();
                }
            }
        }
        return null;
    }
    private int checkCommand(String com){
        for(String commands: formats)
            if (commands.contains(com))
                return (int) commands.chars().filter(ch -> ch == '%').count();

        return -1;
    }
    public void test()
    {
        formats.clone();
        System.out.println(Arrays.toString(input.nextLine().trim().split("\\s+")));
    }
}
