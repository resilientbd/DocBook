/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       : $faisal.hossain.pk@gmail.com
 * Created Date	  : 1/19/21 9:38 PM
 * Last edited by :  imac
 * Edited time    : 1/19/21 9:36 PM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */
package com.faisal.docbook.utils.provider.room.model;

import android.graphics.Color;
import android.util.Log;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


import com.faisal.docbook.R;
import com.faisal.docbook.utils.provider.room.ColorData;

import java.util.Random;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String date;
    private String time;
    private boolean isFavourite;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
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

    public String getDate() {
        if (date == null)
            return "";
        else
            return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFavoriteImageId() {
        if (isFavourite) {
            return R.drawable.ic_pink_favorite;
        } else {
            return R.drawable.ic_favorite;
        }
    }

    public String getTime() {
        if (time == null)
            return "";
        else
            return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMonth() {
        String month = "Jan";
        if (date != null) {
            String[] dateString = date.split("/");
            if (dateString.length > 1) {
                month = dateString[1];
            } else {
                month = "JAN";
            }
        }

        return month;
    }

    public String getDateNumber() {
        String dateNumber = "1";
        if (date != null) {
            String[] dateString = date.split("/");
            if (dateString.length > 1) {
                dateNumber = dateString[0];
            } else {
                dateNumber = "1";
            }
        }

        return dateNumber;
    }

    public int getColorValue() {
        int index = randInt(0, ColorData.colorValueArray.length - 1);

        String colorValue = ColorData.colorValueArray[index];
        int color = Color.parseColor(colorValue);
        return color;
    }

    public static int randInt(int min, int max) {


        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public boolean isTiteValid() {
        boolean isValid = true;
        if (title != null) {
            if (title.isEmpty()) {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        Log.d("chktitle", "+" + title + ":" + isValid);
        return isValid;
    }

    public boolean isDescriptionValid() {
        boolean isValid = true;
        if (description != null) {
            if (description.isEmpty()) {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        Log.d("chktitle", "+" + description + ":" + isValid);
        return isValid;
    }
}
