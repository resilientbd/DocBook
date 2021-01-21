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
package com.faisal.docbook.utils.provider.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.faisal.docbook.utils.provider.room.dao.CredentialsDao;
import com.faisal.docbook.utils.provider.room.dao.DocDao;
import com.faisal.docbook.utils.provider.room.dao.LinksDao;
import com.faisal.docbook.utils.provider.room.dao.NoteDao;
import com.faisal.docbook.utils.provider.room.model.Credentials;
import com.faisal.docbook.utils.provider.room.model.Document;
import com.faisal.docbook.utils.provider.room.model.Links;
import com.faisal.docbook.utils.provider.room.model.Note;


@Database(entities = {Note.class, Credentials.class, Document.class, Links.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
    public abstract DocDao docDao();
    public abstract CredentialsDao credentialsDao();
    public abstract LinksDao linksDao();
    private static volatile AppDatabase appDatabase;
    public static AppDatabase getDatabase(final Context context) {
        if (appDatabase == null) {
            synchronized (AppDatabase.class) {
                if (appDatabase == null) {
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "note_table").build();
                }
            }
        }
        return appDatabase;
    }



}
