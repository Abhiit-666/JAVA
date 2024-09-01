package Equals;
import Equals.Person;

public class testing {
    public static void main(String args[]){
        Person a= new Person("John",2);
        Person b= new Person("Tom", 2);
        
        System.out.println(a.equals(b));
        
    }
    
}
