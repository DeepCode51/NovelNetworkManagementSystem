package com.ykjzone.service.impl;

import com.ykjzone.mapper.PermissionMapper;
import com.ykjzone.pojo.Permission;
import com.ykjzone.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> getByUserId(String user_id) {
        return permissionMapper.selectByUserId(user_id);
    }
}
