package Graph;

import java.util.ArrayList;
import java.util.Iterator;


public class Graph {
    
    private ArrayList<Vertice> vertices;

    public Graph() {
        this.vertices = new ArrayList<Vertice>();
    }

    public Graph(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    @Override
    public String toString() {
        Iterator<Vertice> iterator = vertices.iterator();

        String output = "";

        while(iterator.hasNext()) {
            Vertice currentVertice = iterator.next();
            output += currentVertice.getInformation() + "\n";
        }

        return output;
    }

}
