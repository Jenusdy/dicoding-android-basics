package com.example.android_room_java.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.android_room_java.dao.WordDao;
import com.example.android_room_java.database.WordRoomDatabase;
import com.example.android_room_java.entity.Word;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> words;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        words = wordDao.getAlphabetizedWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return words;
    }

    public void insert(Word word) {
        WordRoomDatabase.databaseWriterExecutor.execute(() -> {
            wordDao.insert(word);
        });
    }
}
