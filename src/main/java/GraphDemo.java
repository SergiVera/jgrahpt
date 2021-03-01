import org.jgrapht.Graph;
import org.jgrapht.alg.scoring.BetweennessCentrality;
import org.jgrapht.alg.scoring.ClosenessCentrality;
import org.jgrapht.alg.scoring.HarmonicCentrality;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.LinkedHashMap;
import java.util.Map;

public class GraphDemo {
    public static void main(String[] args) {
        Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");
        graph.addVertex("L");
        graph.addVertex("M");
        graph.addVertex("N");
        graph.addVertex("O");
        graph.addVertex("P");
        graph.addVertex("Q");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("C", "E");
        graph.addEdge("C", "D");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");
        graph.addEdge("D", "G");
        graph.addEdge("F", "G");
        graph.addEdge("G", "H");
        graph.addEdge("G", "I");
        graph.addEdge("H", "J");
        graph.addEdge("H", "K");
        graph.addEdge("H", "L");
        graph.addEdge("J", "M");
        graph.addEdge("J", "N");
        graph.addEdge("J", "O");
        graph.addEdge("J", "K");
        graph.addEdge("J", "L");
        graph.addEdge("M", "N");
        graph.addEdge("M", "L");
        graph.addEdge("N", "O");
        graph.addEdge("O", "P");
        graph.addEdge("P", "Q");

        System.out.println("Topology Graph");
        System.out.println(graph.toString() + "\n");

        double density = 2 * graph.edgeSet().size() / (double)(graph.vertexSet().size()*(graph.vertexSet().size() - 1));
        System.out.println("Density: " + density + "\n");

        System.out.println("Degree Centrality for every vertex");
        Map<String, Double> degreeCentrality = new LinkedHashMap<>();
        for (String entry : graph.vertexSet()) {
            double degreeCentralityScore = graph.edgesOf(entry).size() / (double) (graph.vertexSet().size() - 1);
            degreeCentrality.put(entry, degreeCentralityScore);
        }
        System.out.println(degreeCentrality + "\n");

        System.out.println("Closeness Centrality for every vertex");
        ClosenessCentrality<String, DefaultEdge> closenessCentrality = new ClosenessCentrality<>(graph);
        Map<String, Double> closenessCentralityScores = closenessCentrality.getScores();
        System.out.println(closenessCentralityScores + "\n");

        System.out.println("Betweenness Centrality for every vertex");
        BetweennessCentrality<String, DefaultEdge> betweennessCentrality = new BetweennessCentrality<>(graph, true);
        Map<String, Double> betweennessCentralityScores = betweennessCentrality.getScores();
        System.out.println(betweennessCentralityScores + "\n");

        System.out.println("Eigenvector Centrality for every vertex");
        /*AlphaCentrality<String, DefaultEdge> alphaCentrality = new EigenvectorCentrality<>(graph);
        Map<String, Double> alphaCentralityScores = alphaCentrality.getScores();
        System.out.println(alphaCentralityScores + "\n");*/

        HarmonicCentrality<String, DefaultEdge> harmonicCentrality = new HarmonicCentrality<>(graph, false, true);
        Map<String, Double> harmonicCentralityScores = harmonicCentrality.getScores();
        System.out.println(harmonicCentralityScores + "\n");
    }
}
