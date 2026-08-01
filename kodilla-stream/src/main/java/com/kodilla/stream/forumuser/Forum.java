package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.*;

public final class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1, "Vladyslav", 'M', LocalDate.of(2004,05,31), 3));
        theUserList.add(new ForumUser(2, "Ivan", 'M', LocalDate.of(2010,05,31), 0));
        theUserList.add(new ForumUser(3, "Valeriia", 'F', LocalDate.of(2000,05,31), 2));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
