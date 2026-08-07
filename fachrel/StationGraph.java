package fachrel;

public class StationGraph {
    private class AdjNode {
        int vertex;
        AdjNode next;

        public AdjNode(int vertex){
            this.vertex = vertex;
            this.next = null;
        }
    }

    private final int MAX = 20;
    private String[] stations;
    private AdjNode[] adjacencyList;
    private int stationCount;

    public StationGraph() {
        stations = new String[MAX];
        adjacencyList = new AdjNode[MAX];
        stationCount = 0;

        for (int i = 0; i < MAX; i++) {
            adjacencyList[i] = null;
        }
    }

    private int getIndex(String station){
        for (int i = 0; i < stationCount; i++) {
            if (stations[i].equals(station)){
                return i;
            }
        }
        return -1;
    }

    public void addNode(String station) {
        if (stationCount >= MAX) {
            System.out.println("Graph Penuh");
            return;
        }
        if (getIndex(station) != -1) {
            return;
        }
        stations[stationCount] = station;
        stationCount++;

    }

    public void addEdge(String from, String to){
        int fromIndex = getIndex(from);
        int toIndex = getIndex(to);

        if (fromIndex == -1 ||  toIndex == -1) {
            System.out.println("Stasiun tidak ditemukan");
            return;
        }
        AdjNode newNode = new AdjNode(toIndex);

        if (adjacencyList[fromIndex] == null) {
            adjacencyList[fromIndex] = newNode;
        } else {
            AdjNode current = adjacencyList[fromIndex];
            while (current.next != null) {
                current = current.next;

            }
            current.next = newNode;
        }

    }
    
    public void printGraph() {
        System.out.println("===== Graf Stasiun =====");
        for (int i = 0; i < stationCount; i++){
            System.out.println(stations[i] + " -> [");
            AdjNode current = adjacencyList[i];
            while (current != null) {
                System.out.println(stations[current.vertex]);
                if (current.next != null) {
                    System.out.println(", ");

                }
                current = current.next;

            }
            System.out.println("]");
        }
    }
    private class Queue {
        int[] data;
        int front;
        int rear;
        public Queue(){
            data = new int[MAX];
            front = 0;
            rear = -1;

        }
        public boolean isEmpty(){
            return front > rear;
        }
        public void enqueue(int value) {
            rear++;
            data[rear] = value;
        }
        public int dequeue() {
            int value = data[front];
            front++;
            return value;
        }

    }

    public void BFS(String start) {
        int startIndex = getIndex(start);
        if (startIndex == -1) {
            System.out.println("Stasiun tidak ditemukan");
            return;
        }
        boolean[] visited = new boolean[MAX];
        Queue queue = new Queue();
        visited[startIndex] = true;
        queue.enqueue(startIndex);

        System.out.println("=== BFS dari " + start + " ===");

        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            System.out.println("Kunjungi: " + stations[current]);
            AdjNode temp = adjacencyList[current];
            while (temp != null) {
                if (!visited[temp.vertex]) {
                    visited[temp.vertex] = true;
                    queue.enqueue(temp.vertex);

                }
                temp = temp.next;
            }
        }

    }

    public void DFS(String start){
        int startIndex = getIndex(start);
        if (startIndex == -1) {
            System.out.println("Stasiun tidak ditemukan");
            return;
        }

        boolean[] visited = new boolean[MAX];
        System.out.println("=== DFS dari " + start + " ===");
        DFSRecursive(startIndex, visited);

    }

    private void DFSRecursive(int current, boolean[] visited){
        visited[current] = true;
        System.out.println("Kunjungi: " + stations[current]);
        AdjNode temp = adjacencyList[current];
        while (temp != null) {
            if (!visited[temp.vertex]){
                DFSRecursive(temp.vertex, visited);
        }
        temp = temp.next;
        }
    }

    public boolean hasPath(String from, String to){
        int start = getIndex(from);
        int target = getIndex(to);

        if (start == -1 || target == -1) {
            return false;
        }
        boolean[] visited = new boolean[MAX];

        Queue queue = new Queue();

        visited[start] = true;
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            int current = queue.dequeue();

            if (current == target){
                return true;
            }
            AdjNode temp = adjacencyList[current];
            while (temp != null) {
                if (!visited[temp.vertex]){
                    visited[temp.vertex] = true;
                    queue.enqueue(temp.vertex);
                }
                temp = temp.next;
            }
        }
        return false;
    }


}
