package com.lib.management.service;

import com.lib.management.model.BookManager;
import com.lib.management.model.SuperAdmin;

public interface SuperAdminService {
    SuperAdmin searchAccountByAdminName(String name);

    boolean updateAccountByAdminName(String name,String password);

}
