package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateInvalidAge() {

        Person person = new Person();

        person.setAge(-1);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateDuplicatedId(){
        Person daniel = new Person("Daniel",1019139154,22,Gender.MALE,true);
        Person camila = new Person("Camila",1019139154,22,Gender.FEMALE,true);
        camila.setId(1019139154);
        RegisterResult result = registry.registerVoter(daniel);
        result = registry.registerVoter(camila);
        Assert.assertEquals(RegisterResult.DUPLICATED,result);
    }

    @Test
    public void validateDeadPerson(){
        Person daniel = new Person("Daniel",1019139154,22,Gender.MALE,false);
        RegisterResult result = registry.registerVoter(daniel);
        Assert.assertEquals(RegisterResult.DEAD,result);
    }

    @Test
    public void validateUnderagePerson(){
        Person daniel = new Person("Daniel",1019139154,16,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(daniel);
        Assert.assertEquals(RegisterResult.UNDERAGE,result);
    }

    @Test
    public void validateRegistratedPerson(){
        Person daniel = new Person("Daniel",1019139154,22,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(daniel);
        Assert.assertEquals(RegisterResult.VALID,result);
    }
}