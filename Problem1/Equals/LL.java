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


    public void add(int data,int pos){
        //addition at the beginning
        Node N = new Node(data, null);
        if(head== null){
            head=N;
            size++;
        }
        
        //at the end
        if(pos==size){

            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=N;
            size++;
        }

        // at position other than the end
        else{
            Node current=head;
            for(int i=0;i<pos-1;i++){
                current=current.next;
            }    
            Node Next=current.next;
            current.next=N;
            N.next=Next;
            size++;
        }
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


    public Node search(int data){

        if(head==null){
            return null;
        }

        if(head.data == data){
            return head;
        }

        Node current =head;
        Node prev=null;

        while(current!=null && current.data != data)
        {
            prev=current;
            current=null;
        }

        if(current != null){
            return current;
        }

        return null;

    }

    public void print(){
        if(head == null){
            return;
        }

        StringBuilder sb=new StringBuilder();
        Node current =head;

        while(current!=null)
        {   
            sb.append(current.data);
            if(current.next != null){
               sb.append(",");
            }
           
        }

        System.out.println(sb.toString());
        
    }

    //returns the size of the current list
    public int size(){
        return size;
    }


    //merge sorting the list
    public void sort(){
        if(head==null){
            return;
        }

        mergeSort(head);
    }


    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast.next!=null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    public Node mergeSort(Node head){
        Node mid= findMid(head);
        Node next2mid=mid.next;

        mid.next=null;
        Node left= mergeSort(head);
        Node right= mergeSort(next2mid);

        return merge(left, right);
    }

    public Node merge(Node left, Node right){
        if(left==null) return right;
        if(right==null) return left;

        Node result;
        if(left.data < right.data){
            result=left;
            result.next=merge(left.next,right);
        }else{
            result=right;
            result.next=merge(left,right.next);
        }

        return result;
    }

}
