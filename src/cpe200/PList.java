package cpe200;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(Object i) {
        head = new PNode(i, head, null);                    //PNode(Object data, PNode next, PNode prev)
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(Object i) {
        tail = new PNode(i,null, tail);                     //PNode(Object data, PNode next, PNode prev)
        if (head==null)
            head = tail;
        else
            tail.prev.next = tail;
        size++;
    }

    public Object popHead() {                               //
        Object data=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return data;
    }

    public Object popTail() {
        Object data=tail.data;
        PNode tmp = tail;

        if (tail==head)
            tail = head = null;
        else {
            tail = tail.prev;
            tail.next = null;
            tmp.prev = null;
        }

        size--;

        return data;
    }

    public boolean remove(Object data) {

        PNode tmp = head; //tmp2 = head;                        //don't need tmp2 for replace data

        while (tmp != null) {
            if (tmp.data.equals(data)) {
                // implement your code here!!!


                // case 1: head of the list
                if (tmp.prev == null){
                    popHead();
                    //size--;
                    return true;
                }


                // case 2: tail of the list
                if (tmp.next == null){
                    popTail();
                    //size--;
                    return true;
                }


                // case 3: somewhere in the middle


                    /*
                    //(tmp.prev).next = tmp.next;
                    tmp2 = tmp.next;
                    tmp2.next = (tmp.next).next;
                    tmp2.prev = tmp.prev;
                    //tmp2 = (tmp.prev).next;
                     */


                    /*                                      //code aun
                    tmp2.next = tmp.next;
                    tmp.next.prev = tmp2;
                     */

                    tmp.data = tmp.next.data;               //really not remove code, It a replace data
                    tmp.next = tmp.next.next;               //and replece next node :D


                    /*
                    Node curr = mid;                        //sudo code from web
		            curr.data = curr.next.data;
		            curr.next = curr.next.next;
                     */


                    size--;
                    return true;

            }
            //tmp2 = tmp;                                   //don't need tmp2 for replace data
            tmp = tmp.next;
        }
        return false;
    }

    public Object elementAt(int index) {
        // implement your code here!!!
        // what if index is not in between 0 to (size-1)
        if(index<0 || index > size-1)
            return null;
        PNode tmp = head;
        int count = 0;
        while(tmp != null)
        {
            if(count++ == index)
                return tmp.data;
            tmp = tmp.next;
        }
        return null;
    }

    // rename the search method to "found(Object data)"
    public boolean found(Object data) {
        // implement your code here!!!
        PNode tmp = head;

        while (tmp != null) {
            if (tmp.data.equals(data)) {
                return true;
            }
            tmp = tmp.next;
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
