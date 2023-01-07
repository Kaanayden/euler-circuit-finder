package Graph;

public class Edge{
    
    Vertice first;
    Vertice second;

    protected Edge(Vertice first, Vertice second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object obj) {

        if(obj instanceof Edge) {
            Edge otherEdge = (Edge) obj;
            return (first.equals( otherEdge.first ) && second.equals(otherEdge.second)) || (second.equals( otherEdge.first ) && first.equals(otherEdge.second));
        } else {
            return false;
        }
        
    }

    public Vertice getOtherVertice(Vertice vertice) {
        if( vertice.equals(first) ) {
            return second;
        } else {
            return first;
        }
    }


    public int hashCode() {
        return first.hashCode() * 29 + second.hashCode() * 13;
    }

    @Override
    public String toString() {
        return "{" + first.getName() + ", " + second.getName() + "}";
    }

}
