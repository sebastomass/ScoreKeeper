package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.scorekeeper.R;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_SCORE_1 = "score1";
    private static final String STATE_SCORE_2 = "score2";
    Bundle savedInstanceState;
    int scoreTeam1 = 0;
    int scoreTeam2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
//Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//Save the scores
        outState.putInt(STATE_SCORE_1, scoreTeam1);
        outState.putInt(STATE_SCORE_2, scoreTeam2);
        if (savedInstanceState != null) {
            scoreTeam1 = savedInstanceState.getInt(STATE_SCORE_1);
            scoreTeam2 = savedInstanceState.getInt(STATE_SCORE_2);
//Set the score text views
            TextView textViewTeam1 = findViewById(R.id.scoreTeam1);
            textViewTeam1.setText(""+scoreTeam1);
            TextView textViewTeam2 = findViewById(R.id.scoreTeam2);
            textViewTeam2.setText(""+scoreTeam2);
        }
        super.onSaveInstanceState(outState);
    }




    public void increaseScore(View view) {
        if(view.getId() == R.id.plusTeam1){
            scoreTeam1++;
            TextView textViewTeam1 = findViewById(R.id.scoreTeam1);
            textViewTeam1.setText(""+scoreTeam1);
        }else{
            scoreTeam2++;
            TextView textViewTeam2 = findViewById(R.id.scoreTeam2);
            textViewTeam2.setText(""+scoreTeam2);
        }
    }

    public void decreaseScore(View view) {
        if(view.getId() == R.id.minusTeam1){
            scoreTeam1--;
            TextView textViewTeam1 = findViewById(R.id.scoreTeam1);
            textViewTeam1.setText(""+scoreTeam1);
        }else{
            scoreTeam2--;
            TextView textViewTeam2 = findViewById(R.id.scoreTeam2);
            textViewTeam2.setText(""+scoreTeam2);
        }
    }
}
