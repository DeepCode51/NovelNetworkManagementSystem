package com.ykjzone.service;

import com.ykjzone.pojo.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> getByUserId(String user_id);
}
