import java.util.*;
public class ConcatArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int row;
        int total_row = sc.nextInt();
        int arr[] = new int[total_row];
        for (row = 0; row < arr.length; row++) {
            arr[row] = sc.nextInt();
        }
        //int m =arr.length*2;
       // System.out.println(m);
       int []a=getConcatenation(arr);
        display(a);
    }
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length*2;
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            if(i<n/2)
                arr[i]=nums[i];

            else
                arr[i]=nums[i-n/2];
        }
        return arr;
    }
    public static void display(int arr[])
    {
        for(int row=0;row<arr.length;row++)
        {
            {
                System.out.print(arr[row]+" ");
            }
        }
    }
}
