package Equals;

import java.util.Objects;

public class Person {
    private String name;
    private int id;
    

    Person(String name, int id){
        this.name=name;
        this.id=id;
    }

    @Override
    public boolean equals(Object obj){

        if(obj== this){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }


        Person person=(Person) obj;
        return id == person.id && name == person.name;
    }


    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    }
}
