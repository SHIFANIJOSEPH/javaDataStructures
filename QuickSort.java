import java.util.Scanner;
import java.util.Random;

class QuickSort {
    
    public static void printArray(int[] numbers) {
        for (int index = 0; index < numbers.length; index++) {
            System.out.printf("%d ", numbers[index]);
        }
        System.out.println();
    }

    public static void quickSort(int[] numbers) {
        quickSortHelper(numbers, 0, numbers.length - 1);
    }

    public static void quickSortHelper(int[] numbers, int left, int right) {
        if (left >= right) return;

        int pivot = numbers[right];
        int i = left;
        int j = right - 1;
        int temp;

        while (true) {
            while (i < right && numbers[i] < pivot) {
                i++;
            }

            while (j >= left && numbers[j] >= pivot) {
                j--;
            }

            if (i < j) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            } else {
                break;
            }
        }

        temp = numbers[i];
        numbers[i] = numbers[right];
        numbers[right] = temp;

        quickSortHelper(numbers, left, i - 1);
        quickSortHelper(numbers, i + 1, right);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfElements = input.nextInt();
        int[] elements = new int[numberOfElements];
        Random random = new Random();

        for (int index = 0; index < numberOfElements; index++) {
            elements[index] = random.nextInt();
        }

        long startTime = System.currentTimeMillis();
        quickSort(elements);
        long endTime = System.currentTimeMillis();

        double duration = (endTime - startTime) / 1000.0;
        System.out.printf("Quick Sort - NOE = %d , time taken = %.3f seconds\n", numberOfElements, duration);
    }
}
