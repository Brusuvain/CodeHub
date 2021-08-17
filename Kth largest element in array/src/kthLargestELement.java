public class kthLargestELement {
        public int findKthLargest(int[] nums, int k) {
            int lastMax = Integer.MAX_VALUE;
            int currmax = 0;
            while (k > 0) {
                currmax = Integer.MIN_VALUE;
                int frequency = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] < lastMax) {
                        if (nums[i] > currmax) {
                            currmax = nums[i];
                            frequency = 1;
                        } else if (nums[i] == currmax)
                            ++frequency;
                    }

                }
                lastMax = currmax;
                k = k - frequency;
            }
            return currmax;
        }
}
