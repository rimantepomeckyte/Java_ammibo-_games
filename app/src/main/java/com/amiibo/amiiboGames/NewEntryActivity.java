package com.amiibo.amiiboGames;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class NewEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        setTitle("Entry");

        Intent intent = getIntent();
        Games games = (Games) intent.getSerializableExtra(Adapter.ENTRY);

        final CheckBox checkBoxMario = findViewById(R.id.game_mario);
        final CheckBox checkBoxChester = findViewById(R.id.game_chester);
        final CheckBox checkBoxLily = findViewById(R.id.game_lily);
        final CheckBox checkBoxNaomi = findViewById(R.id.game_naomi);

        final RadioGroup groupGameSeries = findViewById(R.id.game_series);
        RadioButton button2 = findViewById(R.id.radio_animal_series);

        final Spinner spinnerType = findViewById(R.id.type);
        ArrayList<String> typeList = new ArrayList<String>();
        typeList.add(games.getType());
        typeList.add(getResources().getString(R.string.new_entry_type_1));
        typeList.add(getResources().getString(R.string.new_entry_type_2));
        typeList.add(getResources().getString(R.string.new_entry_type_3));

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                typeList
        );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(dataAdapter);

        final EditText editTextGameCharacter = findViewById(R.id.game_character);

        Button buttonDisplay = findViewById(R.id.display_selected_btn);

        checkBoxChester.setText(games.getName());
        button2.setText(games.getGameSeries());
        editTextGameCharacter.setText(games.getCharacter()); //pataisyti getId arba pataisyt inpu i character

        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String allGames = "";
                if (checkBoxMario.isChecked()){
                    allGames += checkBoxMario.getText().toString() + ", ";
                }
                if (checkBoxChester.isChecked()){
                    allGames += checkBoxChester.getText().toString() + ", ";
                }
                if (checkBoxLily.isChecked()){
                    allGames += checkBoxLily.getText().toString() + ", ";
                }
                if (checkBoxNaomi.isChecked()){
                    allGames += checkBoxNaomi.getText().toString() + ", ";
                }

                int selectedId = groupGameSeries.getCheckedRadioButtonId();

                RadioButton selectedButton = (RadioButton) findViewById(selectedId);
               String gameSeries = selectedButton.getText().toString();
               String type = String.valueOf(spinnerType.getSelectedItem());
               String character = editTextGameCharacter.getText().toString();

               editTextGameCharacter.setError(null);
               if(Validation.isValidCharacter(character)){
                   //(String id, String name, String character, String gameSeries, String type)
                   Games games = new Games(allGames, character, gameSeries, type);

                   Toast.makeText(
                           NewEntryActivity.this,
                           "Game(ies): " + games.getId() + "\n" +
                                   "Game character " + games.getCharacter() + "\n"+
                                   "Game series: " + games.getGameSeries() + "\n" +
                                   "Type: " + games.getType(),
                           Toast.LENGTH_SHORT).show();
               }else {
                   editTextGameCharacter.setError(getResources().getString(R.string.new_entry_invalid_code));
                   editTextGameCharacter.requestFocus();
               }
            }
        });

    }
}
