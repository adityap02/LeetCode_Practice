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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        while(list1!=null || list2!=null){
            if(list1!=null && list2!=null && list1.val<=list2.val){
                ans.next =  list1;
                //ans.val = list1.val;
                //ans.next = new ListNode();
                ans = ans.next;
                list1 = list1.next;
            }else if(list1!=null && list2!=null && list1.val>list2.val){
                ans.next = list2;
                //ans = new ListNode(list2.val);
                // ans.val = list2.val;
                // ans.next = new ListNode();
                ans = ans.next;
                list2 = list2.next;
            }else if(list1!=null && list2==null){
                ans.next = list1;
                //ans = new ListNode(list1.val);
                // ans.val = list1.val;
                // ans.next = new ListNode();
                ans = ans.next;
                list1 = list1.next;
            }else if(list2!=null && list1==null){
                //ans = new ListNode(list2.val);
                // ans.val = list2.val;
                // ans.next = new ListNode();
                
                ans.next = list2;
                ans = ans.next;
                list2 = list2.next;
            }
        }

        return temp.next;
    }
}