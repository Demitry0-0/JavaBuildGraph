import java.util.Arrays;


public class Graph {
    final int size;
    private final int[][] graph;
    Graph(int count){
        size = ++count;
        graph = new int[size][size];
    }
    public boolean connectVertices(Vertices vertices){
        graph[vertices.v1][ vertices.v2]= graph[vertices.v2][ vertices.v1] = 1;
        return true;
    }

    public boolean disconnect(Vertices vertices){
        graph[ vertices.v1][ vertices.v2]= graph[ vertices.v2][ vertices.v1] = 0;
        return true;
    }

    public boolean connectFromAllVertices(Vertices vertices){
        for (int i = 1; i < size; ++i)
            graph[i][vertices.v1] = graph[vertices.v1][i]=1;
        // matrix[vertices.v1][vertices.v1]=0;
        return true;
    }
    public boolean disconnectFromAllVertices(Vertices vertices){
        for (int i = 1; i < size; ++i)
            graph[i][vertices.v1] = graph[vertices.v1][i]=0;
        return true;
    }
    public boolean print(Vertices vertices){
        System.out.println(this);
        return true;
    }
    public boolean swapVertices(Vertices vertices){
        int t;
        for (int i = 1; i < size; i++) {
            t = graph[vertices.v1][i];
            graph[vertices.v1][i] = graph[vertices.v2][i];
            graph[vertices.v2][i] = t;

            t = graph[i][vertices.v1];
            graph[i][vertices.v1] = graph[i][vertices.v2];
            graph[i][vertices.v2] = t;

        }
        return true;
    }

    public int[][] getGraph()
    {
        return graph.clone();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(" \t");
        final String format = "%d\t";
        for (int i = 1; i < size; i++)
            res.append(String.format(format, i));
        res.append("\n");

        for (int i =1; i < size; ++i){
            res.append(String.format(format, i));
            for (int j = 1; j < size; j++)
                res.append(String.format(format, graph[i][j]));
            res.append("\n");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

}
