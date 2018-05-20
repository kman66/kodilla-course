package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> list = new ArrayList<>();

    public void addForumUser(final ForumUser ... forumUsers){
        for(ForumUser f : forumUsers){
            list.add(f);
        }
    }

    public List<ForumUser> getList(){
        return new ArrayList<>(list);
    }
}
