
package org.uninpahu.Repository;

import org.uninpahu.Modelo.User;

public interface RepositoryUser {
    //add user
    void insertUser(User user);
    //seach by nickname
    User searhByNickname(String nickname);
}
