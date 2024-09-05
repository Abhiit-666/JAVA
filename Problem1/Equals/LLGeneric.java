package Equals;

import org.w3c.dom.Node;

public class LLGeneric<T extends Comparable<T>> {

    private Node head;
    private int size;

    private static class Node<T extends Comparable<T>>{
        private T data;
        private Node next;

        Node(T data){
            this.data=data;
            this.next=null;
        }

    }

    LLGeneric(){
        this.head=null;
        this.size=0;
    }

    public int size(){
        return size;
    }

    public void print(){
        Node current = head;
        StringBuilder br= new StringBuilder();

        while(current.next!=null){
            br.append(current.data);
            if(current.next!= null){
                br.append(",");
            }
            current=current.next;
            System.out.println(br.toString());
            
        }
    }

    public void add(T data, int pos){

        Node n=new Node(data);
        if(head==null){
            head=n;
            size++;
            return;
        }
        else{
            Node current=head;
            for(int i=0;i<pos-1;i++){
                current=current.next;
            }
            Node temp=current.next;
            current.next=n;
            n.next=temp;
            size++;
        }
    }

    public void remove(T data){

        Node current=head;
        Node prev=null;

        if(head==null)return;

        if(head.data==data){
            System.out.println("Removed "+head.data);
            head=null;
            size--;
        }

        else{
            while(current != null && current.data != data){
                prev=current;
                current=current.next;
            }
            if(current != null){
                System.out.println("Removed "+current.data);
                prev.next=null;
                size--;
            }
        }

    }


    public void sort(){
        if(this.head==null)return;

        this.head=mergeSort(this.head);
    }

    public Node mergeSort(Node head){
        if(head.next == null)return head;

        Node mid= middle(head);
        Node nextn=mid.next;
        mid.next=null;

        Node left=mergeSort(head);
        Node right= mergeSort(nextn);

        return merge(left,right);
    }

    public Node middle(Node head){

        Node fast=head;
        Node slow=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }


    public Node merge(Node left, Node right){
        if(left== null) return right;
        if(right== null) return left;

        Node result=null;
        if(left.data.compareTo(right.data)<0){
            result=left;
            result.next=merge(left.next,right);
        }
        else{
            result=right;
            result.next=merge(left,right.next);
        }
        // if(left.data instanceof String){
        //     if(((String)left.data).compareTo((String)right.data)<0){
        //         result=left;
        //         result.next= merge(left.next,right);
        //     }else{
        //         result=left;
        //         result.next= merge(left,right.next);
        //     }
        // }
        // else if(left.data instanceof Integer){
        //     if((Integer)left.data<((Integer)right.data)){
        //         result=left;
        //         result.next=merge(left.next,right);
        //     }
        //     else{
        //         result=right;
        //         result.next=merge(left,right.next);
        //     }
        // }
        // else if(left.data instanceof Double){
        //     if((Double)left.data<((Double)right.data)){
        //         result=left;
        //         result.next=merge(left.next,right);
        //     }
        //     else{
        //         result=right;
        //         result.next=merge(left,right.next);
        //     }
        // }

        return result;
    }

    public void reverse(){

        if (this.head ==null || this.head.next==null)return;

        this.head=revImpl(this.head);
    }

    private Node revImpl(Node head){
        Node prev=null;
        Node current=head;

        while(current!=null){
            Node temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }
    
}
