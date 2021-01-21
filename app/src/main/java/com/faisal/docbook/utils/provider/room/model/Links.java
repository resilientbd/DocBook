/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/22/21 12:20 AM
 * Last edited by :  imac
 * Edited time    : 1/22/21 12:20 AM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.utils.provider.room.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "links_table")
public class Links {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String link;

    public Links() {
    }

    public Links(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
