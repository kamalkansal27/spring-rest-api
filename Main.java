import java.util.Scanner;
public class Main {
    public static int[][] solve(int rows, int cols){
        int [][] res = new int[rows][cols];
        int top = 0, down = rows-1, left = 0, right = cols-1;
        while(top <= down && left <= right){
            // Top row
            for(int i = left; i <= right; i ++){
                res[top][i] = top + 1;
            }
            // Right col
            for(int i = top+1; i <= down; i ++){
                res[i][right] = cols-right;
            }
            // Bottom row
            for(int i = right-1; i >= left; i --){
                res[down][i] = rows-down;
            }
            // left col
            for(int i = down - 1; i > top; i --){
                res[i][left] = left + 1;
            }
            top ++; down --; left ++; right --;
        }
        return res;
    }
    public static void main(String[] args) {

        // Creating a Scanner Object.
        Scanner sc = new Scanner(System.in);

        // User Input
        System.out.print("Width: ");
        int cols = sc.nextInt();
        System.out.print("Height: ");
        int rows = sc.nextInt();

        // Calling the solve function.
        int [][] ans = solve(rows, cols);
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }
}