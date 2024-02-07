import java.io.*;
import java.util.*;

public class App {
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random rand = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            for (int i : array) {
                writer.println(i);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFileToArray(String filename) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;

    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to generate a random array, or 2 to sort an existing file:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Enter the length of the array:");
            int arrayLength = scanner.nextInt();
            int[] array = createRandomArray(arrayLength);
            System.out.println("Enter the filename to store the array:");
            scanner.nextLine();
            String filename = scanner.nextLine();
            writeArrayToFile(array, filename);
        } else if (choice == 2) {
            System.out.println("Enter the filename to read the array from:");
            String filename = scanner.nextLine();
            int[] array = readFileToArray(filename);
            bubbleSort(array);
            System.out.println("Enter the filename to store the sorted array:");
            String sortedFilename = scanner.nextLine();
            writeArrayToFile(array, sortedFilename);
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        scanner.close();
    }
}
