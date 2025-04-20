
package org.uninpahu.Repository;

import org.uninpahu.Modelo.Person;

public interface RepositoryPerson {
    //add person
    void insertPerson(Person person);
    //searh by email
    Person searchByEmail(String email);
}
