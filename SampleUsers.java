package com.example.camel;

import java.util.ArrayList;
import java.util.List;

public class SampleUsers {

    private static List<SampleUser> USERS;

    static {
        final List<SampleUser> users = new ArrayList<>();
        users.add(new SampleUser("AAA"));
        users.add(new SampleUser("BBB"));
        users.add(new SampleUser("CCC"));

        USERS = users;
    }


    public void addUser(SampleUser user) {
        if (null == user) {
            throw new IllegalArgumentException("user must not be null");
        }

        USERS.add(user);
    }

}
