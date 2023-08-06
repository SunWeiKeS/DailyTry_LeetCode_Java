package BackUp.graduated.P03_Array;

public class P11_minArray {

    public int minArray1(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid= left+(right-left)/2;
            if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else if(numbers[mid]<numbers[right]){
                right=mid;
            }else {
                right--;
            }

        }

        return numbers[left];
    }

    
}
