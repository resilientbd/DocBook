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
import com.faisal.docbook.utils.provider.room.model.Links;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface LinksDao {
    @Insert
    long insert(Links links);

    @Update
    int update(Links links);

    @Query("SELECT * from links_table")
    Flowable<List<Links>> getList();

    @Delete
    int delete(Links links);
}
