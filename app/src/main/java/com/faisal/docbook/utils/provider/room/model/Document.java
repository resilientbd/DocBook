/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/22/21 12:18 AM
 * Last edited by :  imac
 * Edited time    : 1/22/21 12:18 AM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.utils.provider.room.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doc_table")
public class Document {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String base64Doc;

    public Document(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Document(String title, String description, String base64Doc) {
        this.title = title;
        this.description = description;
        this.base64Doc = base64Doc;
    }

    public String getBase64Doc() {
        return base64Doc;
    }

    public void setBase64Doc(String base64Doc) {
        this.base64Doc = base64Doc;
    }

    public Document() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
