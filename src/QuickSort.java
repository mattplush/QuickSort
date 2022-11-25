import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("src\\input.txt");
		File output = new File("src\\output.txt");
		int[] array = getArrayOfInts(input);
		int n = array.length - 1;
		quickSort(array,0,n);
		printArray(output,array);

	}
	public static void quickSort(int array[], int left, int right) {
		if(left >= right) {
			return;
		}
		int i = choosePivot(array,left,right);
		int temp = array[i];
		array[i] = array[left];
		array[left] = temp;
		
		
		int j = partition(array,left,right);
		quickSort(array, left, j - 1);
		quickSort(array, j + 1, right);
		
	}
	public static int choosePivot(int array[], int left, int right) {
		Random randomNum = new Random();
        int rand = randomNum.nextInt((right-left)+1)+left;
		return rand;
	}
	public static int partition(int array[], int left, int right) {
		int p = array[left];
		int i = left + 1;
		for(int j = left + 1; j <= right; ++j) {
			if(array[j] < p) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				++i;
			}
		}
		int temp = array[left];
		array[left] = array[i - 1];
		array[i - 1] = temp;
		return i - 1;
		
	}
	public static int[] getArrayOfInts(File input) throws FileNotFoundException {

		Scanner counter = new Scanner(input);
		Scanner scanner = new Scanner(input);

		int n = 0;
		int[] array;

		while (counter.hasNextLine()) {
			++n;
			counter.nextLine();
		}
		counter.close();
		array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		return array;
	}

	static void printArray(File output, int array[]) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(output);
		for (int i = 0; i < array.length; ++i) {
			writer.println(array[i]);
			System.out.println(array[i]);
		}
		writer.close();
	}
}
