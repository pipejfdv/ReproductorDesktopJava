
package org.uninpahu.Repository;

import org.uninpahu.Modelo.Person;

public interface RepositoryPerson {
    //add person
    void insertPerson(Person person);
    //searh by email
    Person searchByEmail(String email);
    //update data
    void updatePerson(String names, String lastnames, String email, String idPerson);
    //delete person
    void removePerson(String idPerson);
}
