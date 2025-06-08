class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!list.isEmpty() && (list.peekLast() > 0 && asteroid < 0)) {
                // If the top asteroid in the stack is smaller, then it will explode.
                // Hence pop it from the stack, also continue with the next asteroid in the stack.
                if (Math.abs(list.peekLast()) < Math.abs(asteroid)) {
                    list.pollLast();
                    continue;
                }
                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                else if (Math.abs(list.peekLast()) == Math.abs(asteroid)) {
                    list.pollLast();
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                flag = false;
                break;
            }

            if (flag) {
                list.addLast(asteroid);
            }
        }


        // Add the asteroids from the stack to the vector in the reverse order.
        int[] ans = new int[list.size()];
        for (int i = 0; i<ans.length; i++) {
            ans[i] = list.pollFirst();
            
        }
        return ans;
    }
}