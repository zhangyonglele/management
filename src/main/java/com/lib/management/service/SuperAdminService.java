package com.lib.management.service;

import com.lib.management.model.SuperAdmin;

public interface SuperAdminService {
    SuperAdmin searchAccountByAdminName(String name);

    void updateAccountByAdminName(String name,String password);
}
