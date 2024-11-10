package com.ykjzone.pojo;

//import javax.validation.constraints.*;
import com.ykjzone.util.MD5;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

public class User {
    private String id;

    @Size(max=16, min=6)
    private String password;

    private Date last_login;

    private Boolean is_superuser;

    @NotBlank
    @Pattern(regexp="^1[3-9]\\d9$")
    private String telephone;

    @NotBlank
    @Size(max=12,min=2)
    private String username;

    private String email;

    private Boolean is_active;

    private Boolean is_author;

    private Boolean is_staff;

    private Date date_joined;

    private String pen_name;

    private List<Group> groups;

    private List<Permission> permissions;


    public List<Group> getGroups(){
        return groups;
    }

    public void setGroups(List<Group> groups){
        this.groups = groups;
    }

    public List<Permission> getPermissions(){
        return permissions;
    }

    public void setPermissions(List<Permission> permissions){
        this.permissions = permissions;
    }

    public boolean hasPermission(String perm){
        if(perm == null || perm.equals(""))
            return false;
        for(Permission p : permissions)
            if(perm.equals(p.getCodename()))
                return true;
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Boolean getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(Boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Boolean getIs_author() {
        return is_author;
    }

    public void setIs_author(Boolean is_author) {
        this.is_author = is_author;
    }

    public Boolean getIs_staff() {
        return is_staff;
    }

    public void setIs_staff(Boolean is_staff) {
        this.is_staff = is_staff;
    }

    public Date getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(Date date_joined) {
        this.date_joined = date_joined;
    }

    public String getPen_name() {
        return pen_name;
    }

    public void setPen_name(String pen_name) {
        this.pen_name = pen_name == null ? null : pen_name.trim();
    }
}