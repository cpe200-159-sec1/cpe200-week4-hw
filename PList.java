package cpe200;


/*##PList Class
* Modify the PList class from your previous work to be able to handle "Object" data instead of "char".
* Make sure all the methods work correctly with "Object".
* Rename the method "search(char i)" to "found(Object data)" which search the list for the specified data
    * Return True if the data is found in the list, otherwise returns False.
* Add the "remove(Object data)" which removes the first node containing the "data" from the list.
    * Returns True if data is removed successfully, otherwise returns False.
* Add the "elementAt(int index)" which returns an "Object" data stored at location "index".
    * "index" value of a list starts from 0 to (size-1)
    * Returns "null" if "i" is invalid.*/


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

        PNode tmp = head, tmp2;

        while (tmp != null) {
            if (tmp.data.equals(data)) {
                if (tmp.prev != null)
                    tmp.prev.next = tmp.next;
                if (tmp.next != null)
                    tmp.next.prev = tmp.prev;
                if (tmp == head) {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                }
                if (tmp == tail) {
                    tail = tail.prev;
                    if (tail != null)
                        tail.next = null;
                }
                size--;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public Object elementAt(int index) {
        // implement your code here!!!
        // what if index is not in between 0 to (size-1)
        if(index >= getSize() || index < 0)
            return null;

        PNode curr = head;
        for(;index>0;index--){
            curr = curr.next;
        }
        return curr.data;

    }

    // rename the search method to "found(Object data)"
    public boolean found(Object data) {
        PNode curr = head;
        while(curr != null){
            if(curr.data.equals(data)){
                return true;
            }
            curr = curr.next;
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
