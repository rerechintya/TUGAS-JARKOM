/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.jarkom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


/**
 *
 * @author Asus
 */
class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    @Override
    public String toString() { return name; }
    @Override
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

    String minDistance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}
public class dijaktrialgo {
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

       while (!vertexQueue.isEmpty()) {
           Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
              if (distanceThroughU < v.minDistance) {
                  vertexQueue.remove(v);
                  v.minDistance = distanceThroughU ;
                  v.previous = u;
                  vertexQueue.add(v);
              }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
       Vertex v0 = new Vertex("A");
       Vertex v1 = new Vertex("B");
       Vertex v2 = new Vertex("C");
       Vertex v3 = new Vertex("D");
       Vertex v4 = new Vertex("E");

       v0.adjacencies = new Edge[]{ new Edge(v1, 5),new Edge(v2, 10),new Edge(v3, 8) };
       v1.adjacencies = new Edge[]{ new Edge(v0, 5),new Edge(v2, 3),new Edge(v4, 7) };
       v2.adjacencies = new Edge[]{ new Edge(v0, 10),new Edge(v1, 3) };
       v3.adjacencies = new Edge[]{ new Edge(v0, 8),new Edge(v4, 2) };
       v4.adjacencies = new Edge[]{ new Edge(v1, 7),new Edge(v3, 2) };
       
       dijaktrialgo shortestPath = new dijaktrialgo();
       dijaktrialgo.computePaths(v0);
       System.out.println("Minimum distance from A to B: "+v1.minDistance());
       System.out.println("Minimum distance from A to C: "+v2.minDistance());
       System.out.println("Minimum distance from A to D: "+v3.minDistance());
       System.out.println("Minimum distance from A to E: "+v4.minDistance());
       System.out.println();
       System.out.println("Shortest Path from A to B: "+shortestPath.getcomputePaths(v1));
       System.out.println("Shortest Path from A to C: "+shortestPath.getcomputePaths(v2));
       System.out.println("Shortest Path from A to D: "+shortestPath.getcomputePaths(v3));
       System.out.println("Shortest Path from A to E: "+shortestPath.getcomputePaths(v4));
         
    }

    private String getcomputePaths(Vertex v1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

