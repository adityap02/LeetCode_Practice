class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int i=0;
        boolean[] set = new boolean[instructions.length];
        while(i>=0 && i<instructions.length && !set[i]){
            set[i] = true;
            if(instructions[i].charAt(0)=='a'){
                score += values[i++];
            }else{
                i+=values[i];
            }
        }
        return score;
    }
}