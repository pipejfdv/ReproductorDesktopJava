
package org.uninpahu.Controlers;

import org.uninpahu.Modelo.Person;
import org.uninpahu.Repository.PersonDAO;
import org.uninpahu.Repository.RepositoryPerson;
import org.uninpahu.Services.ServicesPerson;

public class ControlerPerson {
    private ServicesPerson servicesPerson;
    
    public ControlerPerson(){
    RepositoryPerson repositoryPerson = new PersonDAO();
    this.servicesPerson = new ServicesPerson(repositoryPerson);
    }
    
    public void insertPerson(Person person){
        servicesPerson.insertPerson(person);
    }
    
    public Person emailSearch(String email){
        return servicesPerson.searhByEmail(email);
    }
    
    public void updatePerson(String names, String lastnames, String email, String idPerson){
        servicesPerson.updatePerson(names, lastnames, email, idPerson);
    }
}
