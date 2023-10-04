package com.example.android_room_java.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android_room_java.entity.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table WHERE 1")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();
}
