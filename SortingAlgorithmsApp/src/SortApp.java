import java.util.Scanner;

public class SortApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Prompt the user to enter numbers separated by spaces */
        System.out.println("Enter a series of numbers separated by spaces:");
        String input = scanner.nextLine();
        String[] numberStrings = input.split(" ");
        int[] numbers = new int[numberStrings.length];

        /* Convert input strings to integers */
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        /* Prompt the user to choose the sorting algorithm */
        System.out.println("Choose the sorting algorithm:");
        System.out.println("1: Bubble Sort");
        System.out.println("2: Selection Sort");
        int choice = scanner.nextInt();

        /* Sort the array based on the user's choice */
        if (choice == 1) {
            bubbleSort(numbers);
            System.out.println("Array sorted using Bubble Sort:");
        } else if (choice == 2) {
            selectionSort(numbers);
            System.out.println("Array sorted using Selection Sort:");
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        /* Display the sorted array */
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    /* Bubble Sort algorithm */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, break
            if (!swapped) break;
        }
    }

    /* Selection Sort algorithm */
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}