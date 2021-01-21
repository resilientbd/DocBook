/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/22/21 12:22 AM
 * Last edited by :  imac
 * Edited time    : 1/22/21 12:22 AM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.utils.provider.room.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "credentials_table")
public class Credentials {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String userid;
    private String password;
    private String description;

    public Credentials() {
    }

    public Credentials(String title, String password, String description) {
        this.title = title;
        this.password = password;
        this.description = description;
    }

    public Credentials(String title, String userid, String password, String description) {
        this.title = title;
        this.userid = userid;
        this.password = password;
        this.description = description;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
