class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n  = skill.length, m= mana.length;
        long[] arr = new long[n+1];
        Arrays.fill(arr, 0);
        long startTime = 0;
        long sum = 0;
        for(int i =0 ;i<n;i++){
            sum +=(long)skill[i] * (long)mana[0];
            arr[i+1] = sum;
        }
        //skill(wizard) I = [1,5,2,4], mana(potion) P = [5,1,4,2]
        //
        for(int p = 1;p<m;p++){
            //int start = calcOffset(arr,skill,mana[p]);
            long[] currentOutput = new long[n+1];
            Arrays.fill(currentOutput, 0);
            for(int i =0;i<n;i++){
                currentOutput[i+1] = currentOutput[i] + (long)mana[p]* (long)skill[i];
                startTime = Math.max(startTime, arr[i+1]-currentOutput[i]);
                // arr[i] = start+ (skill[i] * mana[p]);
                // start = arr[i];
            }
            arr[0] = startTime;
            for(int i=0;i<n;i++){
                arr[i+1] = arr[i] + ((long)mana[p] * (long)skill[i]);
            }

        }
        return (long)arr[arr.length-1];
    }

    // int calcOffset(int[] arr,int[] skill,int potion){
    //     int[] temp = new int[arr.length];
    //     int offset =arr[0];
    //     for(int a=0; a<arr.length-1;a++){
    //         if(arr[a] + (skill[a]*potion)>=arr[a+1]){
    //             continue;
    //         }else{
    //             offset += arr[a+1]- (arr[a] + (skill[a]*potion));
    //         }
    //     }
    //     return offset;

    // }
}