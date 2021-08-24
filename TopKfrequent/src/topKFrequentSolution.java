import java.util.HashMap;

public class topKFrequentSolution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequencyMap=new HashMap<>();
        int[] topKFrequentNumbers=new int[k];
        for(int i:nums){
            frequencyMap.put(i,frequencyMap.getOrDefault(i,0)+1);
        }
        System.out.println("frequencyMap");
        int prevMax=Integer.MAX_VALUE;
        int i=0;
        while(i<k){
            int currMax=Integer.MIN_VALUE;
            int key=0;
            for(int j:frequencyMap.keySet()){
                if(frequencyMap.get(j)!=-1 && frequencyMap.get(j)>currMax && frequencyMap.get(j)<=prevMax){
                    currMax=frequencyMap.get(j);
                    key=j;
                }
            }
            topKFrequentNumbers[i++]=key;
            frequencyMap.replace(key,-1);
            prevMax=currMax;
        }
        return topKFrequentNumbers;
    }
    public static void main(String args[]){
        int []ans=new int[]{1,1,1,12,3,4,1,5,6,7,2,5,2,6,2,6,2,5,6,5,2,4,1,3,7,8,7,8,7,6,5,3,2,3,4,5};
        for(int i:topKFrequent(ans,6)){
            System.out.println(i);
        }
    }
}
