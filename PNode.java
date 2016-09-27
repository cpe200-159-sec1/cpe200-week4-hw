package cpe200;

public class PNode {
    public Object data;
    public PNode next, prev;

    public PNode() { next = prev = null; }
    public PNode(Object data, PNode next, PNode prev) {
        this.data = data;
        this.next=next;
        this.prev=prev;
    }
}

//##PNode Class
   //     * Modify the PNode class from your previous work to store "Object" data instead of "char".