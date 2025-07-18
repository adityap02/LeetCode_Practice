/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head!=null && null!= head.next){
            if(s.add(head)){
                head = head.next;
                continue;
            }else{
                return true;
            }
            
        }
        return false;
        // ListNode s = head;
        // ListNode f = head;

        // while(f!=null && f.next!= null){
        //     s=s.next;
        //     f=f.next.next;
        //     if(s==f){
        //         return true;
        //     }

        // }
        // return false;
    }
    
}
