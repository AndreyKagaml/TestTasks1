package testTasks;
import java.util.*;

public class Task2 {
    // Class representing a graph edge (destination city and the transportation cost)
    static class Node {
        int destination;
        int cost;

        // Constructor to initialize destination and cost
        Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading the number of test cases
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer

        // Process each test case
        while (testCases > 0) {
            int n = sc.nextInt(); // Number of cities
            sc.nextLine(); // Consume newline

            // Map to store city names and their corresponding index
            Map<String, Integer> cityIndex = new HashMap<>();
            List<List<Node>> graph = new ArrayList<>(); // Graph as an adjacency list

            // Input cities and their neighbors
            for (int i = 0; i < n; i++) {
                String cityName = sc.nextLine(); // Read city name
                cityIndex.put(cityName, i); // Map city name to an index
                int neighbors = sc.nextInt(); // Number of neighbors for the city
                sc.nextLine(); // Consume newline after the integer

                // List to store all the neighbors of the current city (edges of the graph)
                List<Node> edges = new ArrayList<>();
                for (int j = 0; j < neighbors; j++) {
                    int neighbor = sc.nextInt() - 1; // Convert 1-based index to 0-based
                    int cost = sc.nextInt(); // The transportation cost to the neighbor
                    edges.add(new Node(neighbor, cost)); // Add edge to the list
                }
                sc.nextLine(); // Consume newline after the neighbor input
                graph.add(edges); // Add this city’s edges to the graph

                testCases--; // Decrement the number of test cases
            }

            // Reading the number of queries
            int r = sc.nextInt();
            sc.nextLine(); // Consume newline after the integer

            // Process each query
            for (int i = 0; i < r; i++) {
                String source = sc.next(); // Source city for the query
                String destination = sc.next(); // Destination city for the query
                sc.nextLine(); // Consume newline after the query

                // Perform Dijkstra's algorithm to find the shortest path between source and destination
                int result = searchShortWay(graph, cityIndex.get(source), cityIndex.get(destination));
                System.out.println(result); // Output the minimum cost for the current query
            }

            // If there are more test cases, consume the empty line separating them
            if (testCases > 0) sc.nextLine();
        }

        sc.close(); // Close the scanner
    }

    // Dijkstra's algorithm to find the shortest path from start to end
    static int searchShortWay(List<List<Node>> graph, int start, int end) {
        int[] distances = new int[graph.size()]; // Array to store the shortest distance to each city
        boolean[] visited = new boolean[graph.size()]; // Array to track if a city has been visited
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialize all distances to infinity
        distances[start] = 0; // Distance to the start city is 0

        // Main loop of Dijkstra's algorithm
        for (int i = 0; i < graph.size(); i++) {
            // Find the city with the minimum distance that hasn't been visited yet
            int currentNode = -1;
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < graph.size(); j++) {
                if (!visited[j] && distances[j] < minDist) {
                    minDist = distances[j];
                    currentNode = j;
                }
            }

            // If no unvisited cities are left, exit the loop
            if (currentNode == -1) {
                break;
            }

            // Mark the current city as visited
            visited[currentNode] = true;

            // Update the distances to the neighboring cities
            for (Node edge : graph.get(currentNode)) {
                int newDist = distances[currentNode] + edge.cost;
                if (newDist < distances[edge.destination]) {
                    distances[edge.destination] = newDist; // Update the distance if a shorter path is found
                }
            }
        }

        // Return the minimum cost to reach the destination city
        return distances[end];
    }

}
