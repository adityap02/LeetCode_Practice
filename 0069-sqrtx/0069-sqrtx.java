class Solution {
    public int mySqrt(int x) {

        //Bindry Search O(log n)
        //All numbers less than 2 , sqrt is itself 
        if (x < 2) return x;

        long num;
        //we do binary search on nums starting from 2 to x/2
        //all nos after 2 have sqrt less than x/2
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            //Mid point
            pivot = (left + right ) / 2;
            //checking if pivot square is num?
            num = (long) pivot * pivot;
            //if greater, pivot-1 is answer
            if (num > x) right = pivot - 1;
            //smaller? check +1 larger number
            else if (num < x) left = pivot + 1;
            //perfect sq found
            else return pivot;
        }

        return right;
    }
}