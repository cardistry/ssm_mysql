package LC705;

class MyHashSet {

    private final int BASE = 1024;
    Node[] set;
    private class Node{
        int key;
        Node next;
        Node(){}
        Node(int key){
            this.key = key;
        }
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new Node[BASE];
    }

    public void add(int key) {
        if(contains(key))
            return;
        int index = key % BASE;
        if(set[index] == null)
            set[index] = new Node(key);
        else{
            Node tmp = new Node(key);
            tmp.next = set[index];
            set[index] = tmp;
        }

    }

    public void remove(int key) {
        int index = key % BASE;
        if(!contains(key))
            return;
        if(set[index].key == key){
            set[index] = set[index].next;
        }
        else {
            Node pre = set[index];
            Node p = pre.next;
            while(p != null){
                if(p.key == key)
                    pre.next = p.next;
                else
                    pre = p;
                p = p.next;
            }
        }


    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % BASE;
        Node p = set[index];
        while(p != null){
            if(p.key == key)
                return true;
            p = p.next;
        }
        return false;
    }
}



