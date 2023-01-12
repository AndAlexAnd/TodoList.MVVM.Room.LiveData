package com.example.todolistmvvm_room_livedata;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface NotesDao {
    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();
    @Insert
    void add (Note note);
    @Query("DELETE FROM notes WHERE id = :id")
    void remove (int id);
}
