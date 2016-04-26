package com.mafiagame.csci3308.mafiagame;

/**
 * Created by soorinpark on 3/4/16.
 */

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * This is the setting activity. It sets up the background music and the Notification Sounds.
 * @author Soo Park
 */
public class Settings extends Activity {

        private TextView music_label;
        private Switch music_switch;
        MediaPlayer mafiaMusic; //declaring vars for the switches and music file


        @Override
        protected void onPause() {
            super.onPause();
            mafiaMusic.release(); //stops music upon release (or when you leave the app
        }

    /**
     * This function can be called only once. Setting up the view to the new_game layout.
     * This function also set up the background music.
     * @param savedInstanceState
     */
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.settings);

            mafiaMusic = MediaPlayer.create(this, R.raw.music); //this is assigning our music var the mafia music -alex

            music_label = (TextView) findViewById(R.id.music_label);
            music_switch = (Switch) findViewById(R.id.music_switch);

            //set the switch to ON
            music_switch.setChecked(true);
            //attach a listener to check for changes in state
            music_switch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {

                    if(isChecked){//if switch is turned on
                        //music_label.setText("Switch is currently ON");
                        mafiaMusic.start(); //play music

                    }else{
                        //music_label.setText("Switch is currently OFF");
                        mafiaMusic.stop(); //stop the music
                    }

                }
            });

            //check the current state before we display the screen
            if(music_switch.isChecked()){
                music_label.setText("Switch is currently ON");
            }
            else {
                music_label.setText("Switch is currently OFF");
            }
        }

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.settings, menu);
//            return true;
//        }

    }
