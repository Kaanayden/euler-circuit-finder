package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class GraphConstructor {
    
    public static Graph createGraphFromTextFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        Queue lines = new LinkedList<String>();
        while( scanner.hasNextLine() ) {
            String currentLine = scanner.nextLine();
            lines.add(currentLine);
        }
        scanner.close();
        int verticeNumber = lines.size();

        Iterator<String> iterator = lines.iterator();

        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        for(int i = 0; i < verticeNumber; i++) {
            Vertice newVertice = new Vertice(i + "");
            vertices.add(newVertice);
        }

        int verticeIndex = 0;
        while( iterator.hasNext() ) {
            String currentLine = iterator.next();
            Scanner lineScanner = new Scanner(currentLine);
            Vertice vertice = vertices.get(verticeIndex);
            System.out.println("index: " + verticeIndex + ", " + currentLine);
            while(lineScanner.hasNextInt()) {
                int current = lineScanner.nextInt();
                Vertice terminalVertice = vertices.get(current);
                vertice.addEdge( terminalVertice );
            }
            lineScanner.close();
            verticeIndex++;
        }

        Graph graph = new Graph(vertices);
        return graph;

    }

}
