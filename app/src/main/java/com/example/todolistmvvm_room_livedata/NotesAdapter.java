package com.example.todolistmvvm_room_livedata;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolderMy>{

    private List<Note> notes = new ArrayList<>();

    private OnNoteClickListnerMy onNoteClickListnerMy;

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    @NonNull
    @Override
    public NotesViewHolderMy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.notes_item,
                parent,
                false
        );
        return new NotesViewHolderMy(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolderMy viewHolderMy, int position) {

        Note note = notes.get(position);

       viewHolderMy.textViewNote.setText(note.getText());

        int colorResId;
        switch (note.getPriority()) {
            case 0:
                colorResId = R.drawable.krugliye_ugli_green;
                break;
            case 1:
                colorResId = R.drawable.krugliye_ugli_orange;
            break;
            default:
                colorResId = R.drawable.krugliye_ugli_red;

        }
        Drawable color = ContextCompat.getDrawable(viewHolderMy.itemView.getContext(), colorResId);
        viewHolderMy.textViewNote.setBackground(color);
        viewHolderMy.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onNoteClickListnerMy != null){
                    onNoteClickListnerMy.onNoteClickMy(note);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolderMy extends RecyclerView.ViewHolder{
        TextView textViewNote;

        public NotesViewHolderMy(@NonNull View itemView) {
            super(itemView);
            textViewNote = itemView.findViewById(R.id.textViewNote);
        }
    }
    interface OnNoteClickListnerMy{
        void onNoteClickMy (Note note);
    }
}
