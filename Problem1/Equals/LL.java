package Equals;

import org.w3c.dom.Node;

public class LL {
    private Node head;
    private int size;

    private static class Node {
        private int data;
        private Node next;

        Node(int data, Node next){
            this.data=data;
            this.next=null;
        }
        
    }

    LL(){
        this.head=null;
        this.size=0;
    }


    public void add(int data,Node next){
        Node N = new Node(data, next);
        this.head=N;
        size++;
    }

    public void remove(int data){

        if(head==null){
            return;
        } 

        if(head.data == data){
            head=head.next;
            size--;
        }


        Node current=head;
        Node prev=null;


        while (current!= null && current.data!=data) {
            prev=current;
            current=current.next;
        }

        if(current != null){
            prev.next=current.next;
            size--;
        }

    }
    
}
