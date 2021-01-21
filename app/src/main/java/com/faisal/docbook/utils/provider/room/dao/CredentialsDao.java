/*
 * Project Name   : DocBook
 * Created By  	  : imac
 * Email  	       :  faisal.hossain.pk@gmail.com
 * Created Date	  : 1/22/21 1:14 AM
 * Last edited by :  imac
 * Edited time    : 1/22/21 1:14 AM
 * Purpose        :
 * (c) resilientbd.
 *  ======================
 */

package com.faisal.docbook.utils.provider.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.faisal.docbook.utils.provider.room.model.Credentials;
import com.faisal.docbook.utils.provider.room.model.Document;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CredentialsDao {
    @Insert
    long insert(Credentials credentials);

    @Update
    int update(Credentials credentials);

    @Query("SELECT * from credentials_table")
    Flowable<List<Credentials>> getList();

    @Delete
    int delete(Credentials credentials);
}
