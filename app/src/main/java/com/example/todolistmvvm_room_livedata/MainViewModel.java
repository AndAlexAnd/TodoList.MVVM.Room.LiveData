package com.example.todolistmvvm_room_livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AddNoteViewModel{

    private NoteDB noteDB;

    public MainViewModel(@NonNull Application application) {
        super(application);
        noteDB = NoteDB.getInstance(application);
    }

    public LiveData<List<Note>> getNotes(){
        return noteDB.notesDao().getNotes();
    }

    public void remove(Note note){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                noteDB.notesDao().remove(note.getId());
            }
        });
        thread.start();
    }
}
