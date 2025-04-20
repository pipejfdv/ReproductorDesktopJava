package org.uninpahu.Services;

import org.uninpahu.Modelo.Person;
import org.uninpahu.Repository.RepositoryPerson;


public class ServicesPerson {
    private final RepositoryPerson repositoryPerson;
    
    public ServicesPerson(RepositoryPerson repositoryPerson){
        this.repositoryPerson = repositoryPerson;
    }
    
    public void insertPerson (Person person){
        repositoryPerson.insertPerson(person);
    }
    
    public Person searhByEmail (String email){
        return repositoryPerson.searchByEmail(email);
    }
}
