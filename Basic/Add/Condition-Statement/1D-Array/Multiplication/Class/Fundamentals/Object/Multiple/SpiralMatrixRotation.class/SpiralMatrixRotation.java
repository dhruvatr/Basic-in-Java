package SpiralMatrixRotation; // <--- THIS LINE WAS MISSING

import java.util.Scanner;

public class SpiralMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get matrix size
        System.out.print("Enter size of matrix (n): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter an integer.");
            return;
        }
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // 2. Get matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (scanner.hasNextInt()) {
                    matrix[i][j] = scanner.nextInt();
                } else {
                    System.out.println("Invalid element input.");
                    return;
                }
            }
        }
        scanner.nextLine(); // Consume the newline left over

        // 3. Get direction
        System.out.print("Enter direction (up and right / down and right): ");
        String direction = scanner.nextLine().trim().toLowerCase();

        System.out.print("Output is ");
        
        // 4. Call appropriate function based on input
        if (direction.equals("up and right")) {
            printUpAndRight(matrix, n);
        } else if (direction.equals("down and right")) {
            printDownAndRight(matrix, n);
        } else {
            System.out.println("Invalid direction entered.");
        }
        
        scanner.close();
    }

    // Logic for: Up -> Right -> Down -> Left
    public static void printUpAndRight(int[][] matrix, int n) {
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (left <= right && top <= bottom) {
            // Move Up (Traverse left column from bottom to top)
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++; // Done with left column

            if (left > right) break;

            // Move Right (Traverse top row from left to right)
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++; // Done with top row

            if (top > bottom) break;

            // Move Down (Traverse right column from top to bottom)
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--; // Done with right column

            if (left > right) break;

            // Move Left (Traverse bottom row from right to left)
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--; // Done with bottom row
        }
    }

    // Logic for: Down -> Right -> Up -> Left
    public static void printDownAndRight(int[][] matrix, int n) {
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (left <= right && top <= bottom) {
            // Move Down (Traverse left column from top to bottom)
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][left] + " ");
            }
            left++; // Done with left column

            if (left > right) break;

            // Move Right (Traverse bottom row from left to right)
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--; // Done with bottom row

            if (top > bottom) break;

            // Move Up (Traverse right column from bottom to top)
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][right] + " ");
            }
            right--; // Done with right column

            if (left > right) break;

            // Move Left (Traverse top row from right to left)
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[top][i] + " ");
            }
            top++; // Done with top row
        }
    }
}