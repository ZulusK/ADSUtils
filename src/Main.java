import task_1.FindHCF;
import task_6.ArrayOperations;
import task_9.ArraySort;

public class Main {

    public static void main(String[] args) {
        int[] arr= ArrayOperations.getRandomizeArray(100_000_000,0, 99999999);
//        ArrayOperations.printArray(arr);
        System.out.println("Created");
//        arr= ArraySort.mergeSortButtom(arr);
        arr=ArraySort.quickSort(arr,0,arr.length-1);
//        ArrayOperations.printArray(arr);

    }

}
