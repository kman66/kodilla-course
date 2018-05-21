package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Forum {
    private final List<ForumUser> list = new ArrayList<>();

    public void addForumUser(final ForumUser ... forumUsers){
        list.addAll(Arrays.stream(forumUsers).collect(Collectors.toList()));
    }

    public List<ForumUser> getList(){
        return new ArrayList<>(list);
    }
}
