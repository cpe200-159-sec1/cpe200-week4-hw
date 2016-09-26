package cpe200;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(Object i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }
    public PNode getHead(){
        return head;
    }
    public void pushToTail(Object i) {
        tail = new PNode(i,null, tail);
        if (head==null)
            head = tail;
        else
            tail.prev.next = tail;
        size++;
    }

    public Object popHead() {
        Object data=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;tmp.next = null;
            head.prev = null;

        }

        size--;

        return data;
    }

    public Object popTail() {
        Object D=tail.data;
        PNode tmp = tail;

        if (tail==head)
            tail = head = null;
        else {
            tail = tail.prev;tmp.prev = null;
            tail.next = null;

        }

        size--;

        return D;
    }

    public boolean remove(Object D) {

        PNode tmp = head,tmp2=tail,a,b;

        if(head.next==tail&&tail.prev==head) {
            if (tmp.data.equals(D)) {
                this.popHead();
                return true;
            } else if (tmp2.data.equals(D)) {
                this.popTail();
                return true;
            }
        }
        else if(head==tail){head=tail=null;return true;}
        else{
            while (tmp != null) {
                if (tmp.data.equals(D)) {
                    if (tmp == head) {
                        this.popHead();
                        return true;
                    } else if (tmp == tail) {
                        this.popTail();
                        return true;
                    } else {
                        a = tmp.prev;
                        b = tmp.next;
                        a.next = b;
                        b.prev = a;
                        return true;
                    }
                }
                tmp = tmp.next;
            }
        }
        return false;
    }

    public Object elementAt(int index) {
        if(!(index>=0 && index<this.getSize())){return null;}
        else{
            PNode curr=head;
            for(int i=0;i<index;i++){curr=curr.next;}
            Object d=curr.data;
            return d;
        }
    }
    public boolean found(Object w) {
        if (isEmpty()){return false;}
        else
        {
            PNode curr=head;
            while(curr.next!=null && curr.data!=w){curr=curr.next;}
            if(curr.data!=w){return false;}
            else{return true;}
        }
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
