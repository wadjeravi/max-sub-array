
public class Test
{
    public static void main (String[] args)
    {
        //you can edit the input here
        int [] a = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArraySum(a);
    }

    /*
    * Maintains two variables 1) max_positive_sum - keep track of the contiguos positive sum
    * 2) max_so_far - keep track of the max sum till the current index
    * */
    static void maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = 0, max_positive_sum = 0;
        int startIndex = -1;
        int endIndex = -1;
        int len = -1;

        for (int i = 0; i < size; i++)
        {
            max_positive_sum = max_positive_sum + a[i];
            if (max_so_far < max_positive_sum) {
                max_so_far = max_positive_sum;
                endIndex = i;
            }
            if (max_positive_sum < 0) {
                max_positive_sum = 0;
                startIndex = -1;
            }
            else if(max_positive_sum > 0 && startIndex == -1){
                startIndex = i;
            }
        }
        System.out.println("Largest Sub Array");
        System.out.println("Start Index : " + startIndex);
        System.out.println("End Index : " + endIndex);

        if(startIndex != -1 && endIndex != -1) len = (endIndex - startIndex) + 1;

        System.out.println("Length : " + len);
        System.out.println("Sum : " + max_so_far);
        printElements(startIndex, endIndex, a);
    }

    /*
    * Method to print the elements of subarray
    * */
    private static void printElements(int startIndex, int endIndex, int[] a) {
        System.out.print("Elements: ");
        //empty array case
        if(startIndex != -1 && endIndex != -1) {
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.print(" " + a[i]);
            }
        }
    }
}