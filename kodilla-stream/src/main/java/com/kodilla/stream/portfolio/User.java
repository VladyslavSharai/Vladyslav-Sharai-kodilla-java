package com.kodilla.stream.portfolio;

import java.util.Objects;

public final class User {
    private final String name;
    private final String realname;

    public User(final String name, final String realname) {
        this.name = name;
        this.realname = realname;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(realname, user.realname);
    }

}
