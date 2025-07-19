/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    //Two pass
    //1St pass we create a HashMap<Original Node , Copy Node> => No linking btwn new Copy Nodes Yet
    //2nd Pass we link the New Copy Nodes

    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node ans = dummy;
        Map<Node,Node> map = new HashMap<>();
        Node ptr = head;
        //Hashmap created with New Nodes, just the nodes , no linking
        while(ptr!= null){
            map.put(ptr,new Node(ptr.val));
            ptr = ptr.next;
        }

        Node pointer = head;
        // Now we look over the original List and create Links in new node as it is... next and Random
        while(pointer != null){
            Node node = map.get(pointer);
            //Setting next
            if(pointer.next==null){
                node.next = null;    
            }else{
                node.next = map.get(pointer.next);
            }
            //Setting random
            if(pointer.random==null){
                node.random = null;
            }else{
                node.random = map.get(pointer.random);
            }
            
            ans.next = node;
            pointer = pointer.next;
            ans=ans.next;
        }

        return dummy.next;
    }
}