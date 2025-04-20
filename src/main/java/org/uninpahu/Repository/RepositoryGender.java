
package org.uninpahu.Repository;

import org.uninpahu.Modelo.Gender;


public interface RepositoryGender {
    // read type of Gender by id or name
    Gender typeGender(String idGender, String nameGender);
}
