package Java;
import java.io.*;
import java.util.*;


public class HashTable<K,V>{

    private Node<K,V> table;
    private int capacity;
    private int size;
    private int load;

    HashTable(){
       this(16,0.75); 
    }

    Hashtable(int capacity, int load){
        this.table=new Node(capacity);
        this.capacity=capacity;
        this.load=load;
        this.size=0;
    }

    public void set(K key,V value){
        int hash=key.hashCode();
        int index=Math.abs(hash%this.capacity);

        if(this.table[index]== null){
            
        }

    }


    public static void main(String args[]){

        }
}