/*
First Line -> Two integeres N , M (1...n)
N - cities
M - roads

Second Line -> Two Integers A , B  ( Two Way Road Between A and B )

4 2
1 2
3 4

1
2 3
 */

import java.util.*;

public class BuildingRoads {
    private static final List<String> newRoads = new ArrayList<>();
    private static final HashMap<Integer,HashSet<Integer>> connections = new HashMap<>();
    private static Integer previous = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // initialize scanner

        int N = scanner.nextInt();  // no iof cities
        long M = scanner.nextLong();   // no of connected roads

        for(int i=0; i<M; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if(!connections.containsKey(a)){
                connections.put(a, new HashSet<>() );
            }

            if(!connections.containsKey(b)){
                connections.put(b, new HashSet<>());
            }

            // Add to connections
            connections.get(a).add(b);
            connections.get(b).add(a);
        }

        findConnectedComponents();   // Actual Logic

        // Final Output
        System.out.println(newRoads.size()-1);
        for(int i=1; i<newRoads.size(); i++){
            System.out.println(newRoads.get(i-1) +" "+newRoads.get(i));
        }

    }


    private static void findConnectedComponents(){
        Set<Integer> visited = new HashSet<>();

        // Finds connected components
        for(int road : connections.keySet()){
            if(!visited.contains(road)){
                depthFirstSearch(road,  visited);  // call to dfs
                newRoads.add(road+"");
            }
        }
    }


    private static void depthFirstSearch(int road, Set<Integer> visited){

        visited.add(road);
        if(connections.containsKey(road)){
            for(int i: connections.get(road)){
                if(!visited.contains(i)){
                    depthFirstSearch(i, visited);
                }
            }
        }
    }
}
