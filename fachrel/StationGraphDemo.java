package fachrel;

public class StationGraphDemo {
    public static void main(String[] args) {
        StationGraph graph = new StationGraph();
        graph.addNode("Jakarta");
        graph.addNode("Cirebon");
        graph.addNode("Yogyakarta");
        graph.addNode("Solo");
        graph.addNode("Surabaya");
        graph.addEdge("Jakarta", "Cirebon");
        graph.addEdge("Cirebon", "Yogyakarta");
        graph.addEdge("Yogyakarta", "Solo");
        graph.addEdge("Solo", "Surabaya");
        graph.addEdge("Jakarta", "Surabaya"); // direct route
        graph.printGraph();
        graph.BFS("Jakarta");
        System.out.println("Jalur Jakarta->Surabaya? " + graph.hasPath("Jakarta","Surabaya"));
    }
}
