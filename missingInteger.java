import java.util.*;

public class missingInteger {
    public static int Solution(int[] A){
        if(A.length == 1 && A[0] != 1){
            return 1;
        }
        else if (A.length == 1){
            return 2;
        }

        mergeSort(A,0,A.length-1);
        /*for(int q = 0; q<A.length;q++) {
            System.out.println(A[q]);
        }*/
        int smallest = 0;
        for(int i = 0;i<A.length;i++) {
            if(A[i+1]-A[i] != 1 && A[i+1]-A[i] != 0){
                smallest = A[i]+1;
                break;
            }
        }
        return smallest;
    }

    public static void mergeSort(int[] A, int l, int r){
        //1. Find middle point to divide array
        //2. call mergeSort on 1st half
        //3. call mergeSort on 2nd half
        //4. merge 2 halves
        if(l < r) {
            int middle = (l + r) / 2;

            mergeSort(A, l, middle);
            mergeSort(A, middle + 1, r);

            merge(A, l, middle, r);
        }
    }

    static void merge(int[] A, int l, int m, int r) {
        //Find size of temporary arrays
        int s1 = m - l + 1;
        int s2 = r - m;

        //Create temporary arrays
        int[] L = new int[s1];
        int[] R = new int[s2];

        //Store Data into temp arrays
        for(int i = 0;i<s1;++i){
            L[i] = A[i + l];
        }
        for(int j = 0;j<s2;++j) {
            R[j] = A[m + j + 1];
            //System.out.println(j);
        }

        /*Merge Temporary Arrays*/

        ////Initial Indices of subarrays
        int i = 0;
        int j = 0;

        //Initial index of merged subarray
        int k = l;
        while(i < s1 && j < s2){
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }
            else{
                A[k] = R[j];
                j++;
            }
            k++;
        }

        //Copy remaining elements of L and R
        while(i < s1){
            A[k] = L[i];
            i++;
            k++;
        }
        while(j < s2){
            A[k] = R[j];
            j++;
            k++;
        }
    }
}
