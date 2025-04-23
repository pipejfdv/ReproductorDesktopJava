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
    
    public void updatePerson(String names, String lastnames, String email, String idPerson){
        repositoryPerson.updatePerson(names, lastnames, email, idPerson);
    }
    
    public void deletePerson(String idPerson){
        repositoryPerson.removePerson(idPerson);
    }
}
