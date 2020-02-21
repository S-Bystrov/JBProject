/*package com.dao;

import com.entity.User;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepoTest {

    @Before
    public void init(){
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        UserRepo.addUser(user1);
        UserRepo.addUser(user2);
        UserRepo.addUser(user3);
    }

    @Test
    public void testSearchUser(){
        User userActual = UserRepo.searchUser("user1");
        User nullUser = UserRepo.searchUser("user4");
//        assertNotNull(userActual);
//        assertNull(nullUser);
        assertThat(userActual, IsNull.notNullValue());
        assertThat(nullUser, IsNull.nullValue());

    }
}*/
