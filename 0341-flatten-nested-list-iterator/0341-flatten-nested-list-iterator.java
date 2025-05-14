/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    ArrayDeque<NestedInteger> dq;

    public NestedIterator(List<NestedInteger> nestedList) {

        dq = new ArrayDeque<>(nestedList);
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return dq.removeFirst().getInteger();
        }
        return 0;
    }

    void helper(){
        while(!dq.isEmpty() && !dq.peekFirst().isInteger()){
            List<NestedInteger> temp = dq.removeFirst().getList();
            for(int i =temp.size()-1;i>=0;i--){
                dq.addFirst(temp.get(i));
            }
        }
    }

    @Override
    public boolean hasNext() {
        helper();
        return !dq.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */