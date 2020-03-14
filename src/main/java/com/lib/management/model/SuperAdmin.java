package com.lib.management.model;

import java.io.Serializable;

public class SuperAdmin implements Serializable {
    private Integer superAdminId;

    private String superAdminName;

    private String superAdminPassword;

    public Integer getSuperAdminId() {
        return superAdminId;
    }

    public void setSuperAdminId(Integer superAdminId) {
        this.superAdminId = superAdminId;
    }

    public String getSuperAdminName() {
        return superAdminName;
    }

    public void setSuperAdminName(String superAdminName) {
        this.superAdminName = superAdminName == null ? null : superAdminName.trim();
    }

    public String getSuperAdminPassword() {
        return superAdminPassword;
    }

    public void setSuperAdminPassword(String superAdminPassword) {
        this.superAdminPassword = superAdminPassword == null ? null : superAdminPassword.trim();
    }
}