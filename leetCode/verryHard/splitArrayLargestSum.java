public class Solution {
    public int splitArray(int[] nums, int m) {
        int[] ans = new int[m];
        int count = 0;
        int total = 0;
        if(m == nums.length){
            return partAll(nums);
        }


        for(int i = 0; i < nums.length; i++ ){
            total+= nums[i];
        }

        if(m==1){
            return total;
        }
        int target = total/m;
        int cur = 0;
        int prev = 0;
        while( m!=0 ){
            for(int i = 0; i < nums.length; i++ ){
                cur = prev + nums[i];
                if(cur > target){
                    if(Math.abs(cur-target) >= Math.abs(prev-target)){


                      ans[count] = prev;
     //            System.out.println(ans[count]);

                      count++;


                      m--;
                      cur = 0;
                      prev = nums[i];
                    }
                    else{
                        ans[count] = cur;
   //                                     System.out.println(ans[count]);

                        count++;

                        m--;
                        cur = 0;
                        prev = nums[i];

                    }
                }
                prev = nums[i];
            }

        }

        return partAll(ans);

    }


    public int partAll(int nums[]){
        int largest = 0;
        for(int i = 0; i<nums.length; i++){
            if(largest<nums[i]){
                largest = nums[i];
            }
        }
        return largest;
    }
}
