package DSA.Linkedlist;

class LINKEDLIST {

    static class Node{
        int data;
        Node next;
        Node(int x){
            data=x;
            next=null;
        }
    }
    static void printlist (Node head) { // TIME O(N)  SPACE O(1)
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " --> ");
            curr = curr.next;
        }
    }
    static void printRecursive(Node head){  // TIME O(N)  SPACE O(N)
        if(head==null){
            return;
        }
        System.out.print(head.data + " --> ");
        printRecursive(head.next);
    }
    static Node insertBigin (Node head, int k){
        Node newHead = new Node(k);
        newHead.next = head;
        return newHead;
    }
    static Node insertEnd (Node head, int k){
        Node tmp = new Node(k);
        if(head==null){
            return tmp;
        }
        Node curr = head;
        while (curr.next!=null){
            curr = curr.next;
        }
        curr.next = new Node(k);
        return head;
    }
    static Node deleteFirst (Node head){
        Node newHead = head.next;
        return newHead;
    }
    static Node deleteLast (Node head){

        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        Node curr = head;
        while (curr.next.next!=null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }


    public static void main(String []args)
    {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next =new Node(40);
       /* printlist(head);
        printRecursive(head); */
        Node newhead =insertBigin(head,5);
       /* printlist(newhead);
        printlist(insertEnd(newhead,50)); */
//        printlist(deleteFirst(head));
        printlist(deleteLast(newhead));


    }
}