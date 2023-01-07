import java.io.FileNotFoundException;
import java.util.Stack;

import Graph.*;

public class Main {
    public static Stack<Vertice> findEulerCircuit(Graph graph, int indexOfVertice) {
        Stack<Vertice> verticesInPath = new Stack<Vertice>();
        Stack<Vertice> finalPath = new Stack<Vertice>();

        Vertice firstVertice = graph.getVertices().get(indexOfVertice);
        verticesInPath.push(firstVertice);

        while(!verticesInPath.empty()) {
            Vertice currentVertice = verticesInPath.peek();
            if(currentVertice.getEdges().peek() != null) {
                Edge currentEdge = currentVertice.getEdges().pop();
                Vertice terminalVertice = currentEdge.getOtherVertice(currentVertice);
                terminalVertice.getEdges().remove(currentEdge);
                verticesInPath.push(terminalVertice);
            } else {
                verticesInPath.pop();
                finalPath.push(currentVertice);
            }

        }

        return finalPath;
    }

    public static void main(String[] args) {
        Graph graph;
        try {
            graph = GraphConstructor.createGraphFromTextFile("graph.txt");
            System.out.println(graph);
            System.out.println();
            Stack<Vertice> path = findEulerCircuit(graph, 0);
            System.out.println("Euler Circuit: " + path);
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
