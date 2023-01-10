package com.example.todolistmvvm_room_livedata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextInputNote;
    private RadioButton radioButtonLow, radioButtonMedium, radioButtonHigh;
    private Button buttonSaveNote;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initViews();
    }

    private void initViews() {
        radioButtonLow = findViewById(R.id.radioButtonLow);
        radioButtonMedium = findViewById(R.id.radioButtonMedium);
        radioButtonHigh = findViewById(R.id.radioButtonHigh);
        buttonSaveNote = findViewById(R.id.buttonSaveNote);
        editTextInputNote = findViewById(R.id.editTextInputNote);
    }

    public static Intent newIntent (Context context) {
        Intent intent = new Intent(context, AddNoteActivity.class);
        return intent;
    }

}


