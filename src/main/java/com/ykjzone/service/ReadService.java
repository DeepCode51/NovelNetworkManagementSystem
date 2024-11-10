package com.ykjzone.service;

import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserRead;

import java.util.List;

public interface ReadService {
    public List<UserRead> select(User user, Novel novel);

    public int insert(User user, Novel novel);

    public int deleteByNovelId(String novel_id);
}
