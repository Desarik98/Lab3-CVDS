package edu.eci.cvds.tdd.registry; 
import java.util.ArrayList;
public class Registry {
    private ArrayList<Person> registrated;
    public RegisterResult registerVoter(Person p) {
        registrated = new ArrayList<Person>();
        if(p.getAge() < 0){
            return RegisterResult.INVALID_AGE;
        }
        else if(p.getAge() > 150){
            return RegisterResult.DEAD;
        }
        else if(p.getAge() < 18){
            return RegisterResult.UNDERAGE;
        }
        else if(isDuplicated(p)){
           return RegisterResult.DUPLICATED;
        }
        else{
            registrated.add(p);
            return RegisterResult.VALID;
        }
        
    }

    public boolean isDuplicated(Person p){
        boolean flag = false;
        for(Person i:registrated){
            if(!i.equals(p) && (i.getId() == p.getId()){
                flag = true;
            }
        }
        return flag;
    }
}