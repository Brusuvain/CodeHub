public class MinimuCostTreeFromLeafValues {
    static sumAndMax[][]memo;
    public static int mctFromLeafValues(int[] arr) {
        memo=new sumAndMax[arr.length][arr.length];
        int[] ans = getMaxAndLeastSum(arr, 0, arr.length - 1);
        return ans[0];
    }

    public static int[] getMaxAndLeastSum(int[] arr, int start, int end) {
        if (start == end) {
            return new int[]{0, arr[start]};
        }
        if(memo[start][end]!=null)
        {
            return new int[]{memo[start][end].sum,memo[start][end].currMax};
        }
        int minTotalSum = Integer.MAX_VALUE;
        int maxLeaf = 0;
        for (int i = start; i < end; i++) {
            int[] leftMaxAndLeastSum = getMaxAndLeastSum(arr, start, i);
            if(memo[start][i]==null)
            {
                sumAndMax temp_object=new sumAndMax();
                temp_object.sum=leftMaxAndLeastSum[0];
                temp_object.currMax=leftMaxAndLeastSum[1];
                memo[start][i]=temp_object;
            }
            int[] rightMaxAndLeastSum = getMaxAndLeastSum(arr, i + 1, end);
            if(memo[i+1][end]==null){
                sumAndMax tempobject=new sumAndMax();
                tempobject.sum=rightMaxAndLeastSum[0];
                tempobject.currMax=rightMaxAndLeastSum[1];
                memo[i+1][end]=tempobject;
            }

            int total = leftMaxAndLeastSum[0] + rightMaxAndLeastSum[0] + (leftMaxAndLeastSum[1] * rightMaxAndLeastSum[1]);
            minTotalSum = Math.min(minTotalSum, total);
            maxLeaf = Math.max(leftMaxAndLeastSum[1], rightMaxAndLeastSum[1]);

        }

        return new int[]{minTotalSum, maxLeaf};
    }

    public static void main(String args[]) {
        int[] ans = new int[]{6,2, 4,7,5,3};
        int x = mctFromLeafValues(ans);
        System.out.println(x);
    }

}
class sumAndMax{
    int currMax;
    int sum;
}