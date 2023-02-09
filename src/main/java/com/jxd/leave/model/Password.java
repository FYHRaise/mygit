package com.jxd.leave.model;

/**
 * @ClassName Password
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/30
 * @Version 1.0
 */
public class Password {
    private Integer id;
    private Integer role;
    private String oldPassword;
    private String newPassword;
    private String newPassword2;

    public Password() {
    }

    public Password(Integer id, Integer role, String oldPassword, String newPassword, String newPassword2) {
        this.id = id;
        this.role = role;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPassword2 = newPassword2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
