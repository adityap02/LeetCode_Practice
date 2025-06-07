//VERYY EASy SOLUTION
// class MyHashMap {
//     public int[] arr= new int[1000001];
//     public MyHashMap() {
//         for(int i=0;i<1000001;++i){
//             arr[i]=-1;
//         }
//     }

//     public void put(int key, int value) {
//         arr[key]=value;
//     }

//     public int get(int key) {
//         return arr[key];
//     }

//     public void remove(int key) {
//         arr[key]=-1;
//     }
// }

class Node {
    int key;
    int val;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
//Why do we use Linked List? -> That's because Array can keep one data in a place(index). But there is possibility that we have the same hash key with different data.
//Full Explaination -> https://leetcode.com/problems/design-hashmap/solutions/6279872/video-how-we-think-about-a-solution-python-javascript-java-c

class MyHashMap {

    private Node[] map;

    public MyHashMap() {
        map = new Node[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }

        cur.next = new Node(key, value);
    }

    public int get(int key) {
        int hash = hash(key);
        Node cur = map[hash].next;

        while (cur != null) {
            if (cur.key == key)
                return cur.val;
            cur = cur.next;
        }

        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    private int hash(int key) {
        return key % 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */



// class Bucket {
//     private List<Pair<Integer, Integer>> bucket;

//     public Bucket() {
//         this.bucket = new LinkedList<Pair<Integer, Integer>>();
//     }

//     public Integer get(Integer key) {
//         for (Pair<Integer, Integer> pair : this.bucket) {
//             if (pair.getKey().equals(key))
//                 return pair.getValue();
//         }
//         return -1;
//     }

//     public void update(Integer key, Integer value) {
//         boolean found = false;
//         for (int i = 0; i < this.bucket.size(); i++) {
//             Pair p = this.bucket.get(i);
//             if (p.getKey().equals(key)) {
//                 this.bucket.set(i, new Pair(p.getKey(), value));
//                 found = true;
//             }
//         }
//         if (!found)
//             this.bucket.add(new Pair<Integer, Integer>(key, value));
//     }

//     public void remove(Integer key) {
//         for (Pair<Integer, Integer> pair : this.bucket) {
//             if (pair.getKey().equals(key)) {
//                 this.bucket.remove(pair);
//                 break;
//             }
//         }
//     }
// }

// class MyHashMap {
//     private int key_space;
//     private List<Bucket> hash_table;

//     public MyHashMap() {
//         this.key_space = 2069;
//         this.hash_table = new ArrayList<Bucket>();
//         for (int i = 0; i < this.key_space; ++i) {
//             this.hash_table.add(new Bucket());
//         }
//     }

//     /** value will always be non-negative. */
//   public void put(int key, int value) {
//     int hash_key = key % this.key_space;
//     this.hash_table.get(hash_key).update(key, value);
//   }

//   /**
//    * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
//    * for the key
//    */
//   public int get(int key) {
//     int hash_key = key % this.key_space;
//     return this.hash_table.get(hash_key).get(key);
//   }

//   /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//   public void remove(int key) {
//     int hash_key = key % this.key_space;
//     this.hash_table.get(hash_key).remove(key);
//   }
// }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */