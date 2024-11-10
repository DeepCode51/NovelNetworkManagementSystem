package com.ykjzone.service;

import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserCollect;

import java.util.List;

public interface CollectService {
    public List<UserCollect> getByUidAndNid(String user_id, String novel_id);

    public int insert(String user_id, String novel_id);

    public int delete(String user_id, String novel_id);

    public int deleteByNovelId(String novel_id);
}
