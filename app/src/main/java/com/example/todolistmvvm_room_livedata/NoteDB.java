package com.example.todolistmvvm_room_livedata;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)

public abstract class NoteDB extends RoomDatabase {

    private static NoteDB instance = null;
    private static final String DB_NAME = "my_notes.db";

    public static NoteDB getInstance(Application application){
        if (instance == null){
            instance = Room.databaseBuilder(
                    application,
                    NoteDB.class,
                    DB_NAME
            ).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract NotesDao notesDao();
}
