package com.mafiagame.csci3308.mafiagame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This is the mainmenu activity. It deals with all the buttons and changes from activity to another.
 * @author Camille Owens, Soo Park, Jake Mitchell, Alex Sheehan
 */
public class MainActivity extends Activity {

    Button new_game_button;
    Button settings_button;
    Button htp_button;
    Button about_button;
    public static MediaPlayer mafiaMusic;
    public static int backgroundMusicCheck = 0;

    /**
     * This function can be called only once. set the view to the how_to_play layout
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        if (backgroundMusicCheck == 0) {
            mafiaMusic = MediaPlayer.create(this, R.raw.music);
            mafiaMusic.setLooping(true);
            mafiaMusic.start();
        }


    }


    /**
     * This is a listener function. It deals with the function of all the buttons. changing the Activity from MainMenu to others.
     */
    public void addListenerOnButton() {

        final Context context = this;

        new_game_button = (Button) findViewById(R.id.newGameButton);

        new_game_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, NewGame.class);
                startActivity(intent);

            }

        });

        settings_button = (Button) findViewById(R.id.settingsButton);

        settings_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Settings.class);
                startActivity(intent);

            }

        });

        htp_button = (Button) findViewById(R.id.htpButton);

        htp_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, HowToPlay.class);
                startActivity(intent);

            }

        });

        about_button = (Button) findViewById(R.id.aboutButton);

        about_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, About.class);
                startActivity(intent);

            }

        });


    }

}