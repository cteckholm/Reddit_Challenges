import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class dt
{
    private static int[][] matrix;
    private static final String label = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String... strings)
    {
        //reading data
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.println("Input line count");
        int vertices = Integer.parseInt(in.nextLine());
        matrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++)
        {
            String line = in.nextLine();
            String[] columns = line.split(",");
            for (int j = 0; j < vertices; j++)
                matrix[i][j] = Integer.parseInt(columns[j]);
        }
        String[] split = in.nextLine().split("\\s");
        int start = label.indexOf(split[0]);
        int end = label.indexOf(split[1]);

        //calculating path
        Result result = shortestPathDijkstra(start, end, matrix, vertices);

        //output result
        System.out.println(result.cost);
        for (int i : result.path)
            System.out.print(label.charAt(i));
        System.out.println();
    }

    private static Result shortestPathDijkstra(int start, int end, int[][] matrix, int size)
    {
        int[] dist = new int[size];
        int[] prev = new int[size];
        HashSet<Integer> Q = new HashSet<Integer>();

        for (int i = 0; i < size; i++)
        {
            if (i == start)
                dist[start] = 0;
            else
            {
                dist[i] = (matrix[start][i] >= 0) ? matrix[start][i] : Integer.MAX_VALUE;
                prev[i] = (matrix[start][i] >= 0) ? start : -1;
                Q.add(i);
            }
        }

        while (Q.size() > 0)
        {
            // find vertex with min dist
            int u = Integer.MAX_VALUE;
            boolean first = true;
            for (int i : Q)
            {
                if (first)
                {
                    u = i;
                    first = false;
                }
                if (dist[i] < dist[u])
                    u = i;
            }
            if (u == end)
            {
                int current = u;
                ArrayList<Integer> path = new ArrayList<Integer>();
                path.add(current);
                while (current != start)
                {
                    current = prev[current];
                    path.add(current);
                }
                Collections.reverse(path);
                return new Result(path,dist[u]);
            }
            Q.remove(u);

            // for each neighbor
            for (int v = 0; v < size; v++)
            {
                // if neighbor
                if (matrix[u][v] >= 0)
                {
                    int alt = dist[u] + matrix[u][v];
                    if (alt < dist[v])
                    {
                        dist[v] = alt;
                        prev[v] = u;
                    }
                }
            }
        }

        return null;
    }

    private static class Result{
        ArrayList<Integer> path;
        int cost;

        Result(ArrayList<Integer> path, int cost)
        {
            this.path=path;
            this.cost=cost;
        }
    }
}