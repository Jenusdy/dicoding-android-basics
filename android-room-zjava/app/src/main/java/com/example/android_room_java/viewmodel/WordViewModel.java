package com.example.android_room_java.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.android_room_java.entity.Word;
import com.example.android_room_java.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private final LiveData<List<Word>> mAllWords;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() { return mAllWords; }

    public void insert(Word word) { mRepository.insert(word); }
}
