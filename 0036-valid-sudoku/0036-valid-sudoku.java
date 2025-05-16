class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0;i<9;i++){
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
            boxes[i]=new HashSet<>();
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.'){
                    continue;
                }
                //rows
                if(rows[r].contains(board[r][c])){
                    return false;
                }else{
                    rows[r].add(board[r][c]);
                }

                //cols
                if(cols[c].contains(board[r][c])){
                    return false;
                }else{
                    cols[c].add(board[r][c]);
                }
                //boxes
                //0,1,2
                //3,4,5
                //6,7,8
                //0 r-> 0-2 , c-> 0-2
                //1 r-> 0-2, c-> 3-5
                //3 r-> 3-5 , c-> 0-2
                //7 r-> 6-8, c-> 3-5
                int boardNum = r/3 + (c/3)*3;
                if(boxes[boardNum].contains(board[r][c])){
                    return false;
                }else{
                    boxes[boardNum].add(board[r][c]);
                }

            }
        }

        return true;
    }

}