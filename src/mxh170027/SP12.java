package PVT170000;

import rbk.BFSOO;
import rbk.Graph;

import java.io.File;
import java.util.Scanner;

public class SP12 {

    public static int diameter(Graph g){

        if(g.size() == 0) return 0;

        BFSOO b = new BFSOO(g);
        b.bfs(g.getVertex(1));


        Graph.Vertex farthest = findFarthestNode(g, b);
        b.bfs(farthest);

        return b.getDistance(findFarthestNode(g, b));
    }


    private static Graph.Vertex findFarthestNode(Graph g, BFSOO b){

        int max = 0;
        int dist;
        Graph.Vertex farthest = b.getSource();

        for(Graph.Vertex u : g){
            dist = b.getDistance(u);
            if(max < dist){
                max = dist;
                farthest = u;
            }
        }
        return farthest;
    }


    public static void main(String[] args) throws Exception {
        //String string = "7 8   1 2 2   1 3 3   2 4 5   3 4 4   4 5 1   5 1 -7 -1 1";
        String string = "10 9   1 2 2   1 3 3   2 4 5   2 5 4   3 6 1   3 7 1   4 8 1   7 9 1   7 10 1 1";
        Scanner in;
        // If there is a command line argument, use it as file from which
        // input is read, otherwise use input from string.
        in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
        // Read graph from input
        Graph g = Graph.readGraph(in);
        int s = in.nextInt();

        g.printGraph(false);

        int diam = diameter(g);
        System.out.println(diam);
    }
}
