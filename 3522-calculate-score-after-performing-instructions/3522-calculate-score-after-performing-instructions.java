class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int i=0;
        while(i>=0 && i<instructions.length){
            if("jump".equals(instructions[i])){
                instructions[i] = "X";
                i+=values[i];
            }else if("add".equals(instructions[i])){
                instructions[i] = "X";
                score += (int)values[i];
                i++;
            }else{
                break;
            }
        }
        return score;
    }
}