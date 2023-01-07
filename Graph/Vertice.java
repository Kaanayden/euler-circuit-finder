package Graph;

import java.util.LinkedList;
import java.util.ListIterator;

public class Vertice {
 
    private LinkedList<Edge> edges;

    private String name;

    public Vertice(String name) {
        this.name = name;
        edges = new LinkedList<Edge>();
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        String output = "";
        output += "Name: " + getName() + ", Edges: [";
        ListIterator<Edge> listIterator = edges.listIterator();
        if(listIterator.hasNext()) {
            while(listIterator.hasNext()) {
                Edge currentEdge = listIterator.next();
                output += currentEdge + ", ";
            }
            output = output.substring(0, output.length() - 2);
        } 

        output += "]";

        return output;
    }

    @Override
    public String toString() {
return getName();
    }
    

    public void addEdge(Vertice otherVertice) {
        Edge newEdge = new Edge(this, otherVertice);
        if(!hasEdge(newEdge)) {
            edges.push(newEdge);
            otherVertice.edges.push(newEdge);
        }
    }

    public boolean hasEdge(Edge edge) {
        ListIterator<Edge> listIterator = edges.listIterator();
        while(listIterator.hasNext()) {
            Edge currentEdge = listIterator.next();
            if( currentEdge.equals(edge) ) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

}
