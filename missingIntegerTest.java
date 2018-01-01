import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class missingIntegerTest {
    @Test
    void solution() {
        //Arrays of size 1 will either have - 1 million or -999999 as smallest non-existent integeer
        int[] arr1 = new int[1];
        int[] arr2 = new int[1];
        arr1[0] = 1;
        arr2[0] = 6;
        //Handle Edge case of Array Size = 1;
        assertEquals(2,missingInteger.Solution(arr1));
        assertEquals(1,missingInteger.Solution(arr2));

        //Simple Tests to see general correctness
        int[] arr3 = new int[4];
        arr3[0] = 1; arr3[1] = 5; arr3[2] = 4; arr3[3] = 2;
        assertEquals(3,missingInteger.Solution(arr3));

        int[] arr4 = new int[7];
        arr4[0] = 5; arr4[1] = 1; arr4[2] = 2; arr4[3] = 1;
        arr4[4] = 3; arr4[5] = 4; arr4[6] = 7;
        assertEquals(6,missingInteger.Solution(arr4));

        //Test on a larger set of data
        int[] arr5 = new int[1000];
        for(int i = 0; i<arr5.length;i++){
            if(i == 67){
                arr5[i] = 75;
            }
            else{
                arr5[i] = i;
            }
        }

        assertEquals(67,missingInteger.Solution(arr5));
    }
}