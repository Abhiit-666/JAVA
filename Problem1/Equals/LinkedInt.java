package Equals;

public class LinkedInt {

    public static void main(String args[]){
        LLint l1=new LLint();
        l1.add(10,0);
        l1.add(12,1);
        l1.add(8,1);
        l1.print();
        l1.sort();
        l1.print();

        
        System.out.println("Size :" + l1.size());
    }
    
}
