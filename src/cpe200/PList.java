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

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            if(head == null)
                this.tail = this.head;
            else
                head.prev = null;
        }

        size--;

        return data;
    }

    public Object popTail() {
        Object data=tail.data;


        if (tail==head)
            tail = head = null;
        else {
            tail = tail.prev;
            if(tail == null)
                this.head = this.tail;
            else
                tail.next = null;
        }

        size--;

        return data;
    }

    public boolean remove(Object data) {

        PNode temp = head, temp2 = head;

        while (temp != null) {
            if (temp.data.equals(data)) {
                // implement your code here!!!

                // case 1: head of the list
                if(temp == head)
                {
                    popHead();
                    return true;
                }
                // case 2: tail of the list
                if(temp == tail)
                {
                    popTail();
                    return true;
                }
                // case 3: somewhere in the middle
                temp2.next = temp.next;
                temp.next.prev = temp2;
                size--;
                return true;
            }
            temp2 = temp;
            temp = temp.next;
        }
        return false;
    }

    public Object elementAt(int index) {
        // implement your code here!!!
        // what if index is not in between 0 to (size-1)
        PNode temp = head;
        int count = 0;
        if(index<0 || index > size-1)  return null;


        while(temp != null)
        {
            if(count++ == index)
                return temp.data;
            temp = temp.next;
        }
        return null;
    }

    // rename the search method to "found(Object data)"
    public boolean found(Object data) {
        // implement your code here!!!

        PNode temp = head;

        while(temp != null)
        {
            if(temp.data.equals(data))
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
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