import java.util.*;
import java.io.*;

public class CountingRooms {
    private static char[][] matrix;
    private static int rowLength;
    private static int colLength;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        rowLength = scanner.nextInt();
        colLength = scanner.nextInt();
        scanner.nextLine();

        List<String> input = new ArrayList<>();
        for(int i=0; i<rowLength; i++){
            input.add(scanner.nextLine());
        }

        constructMatrix(input); // step 1
        int noOfRooms =  findRooms(); // step 2
        System.out.println(noOfRooms);
    }

    private static int findRooms(){
        int noOfRooms = 0;
        for(int i=0; i<rowLength; i++){
            for(int j=0; j<colLength; j++){
                if(matrix[i][j] == '.'){
                    depthFirstSearch(i, j);
                    noOfRooms++;
                }
            }
        }

        return noOfRooms;
    }

    private static void depthFirstSearch(int i, int j){
        // base case
        if(i < 0 || i >= rowLength || j < 0 ||  j>= colLength || matrix[i][j] == '#'){
            return;
        }

        // changes
        matrix[i][j] = '#';

        // Recursion call
        depthFirstSearch(i + 1, j);
        depthFirstSearch(i - 1, j);
        depthFirstSearch(i, j + 1);
        depthFirstSearch(i, j - 1);
    }

    private static void constructMatrix( List<String> input){
        matrix = new char[rowLength][colLength];
        for(int i=0; i<rowLength; i++){
            String currentRow = input.get(i);
            for(int j=0; j<colLength; j++){
                matrix[i][j] = currentRow.charAt(j);
            }
        }
    }
}