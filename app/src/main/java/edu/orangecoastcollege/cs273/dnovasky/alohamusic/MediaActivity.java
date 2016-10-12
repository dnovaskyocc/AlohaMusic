package edu.orangecoastcollege.cs273.dnovasky.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaActivity extends AppCompatActivity {

    private MediaPlayer mUkuleleMP;
    private MediaPlayer mIpuMP;

    private Button mUkuleleButton;
    private Button mIpuButton;
    private Button mHulaButton;

    private VideoView mHulaVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        mUkuleleButton = (Button) findViewById(R.id.ukuleleButton);
        mIpuButton = (Button) findViewById(R.id.ipuButton);
        mHulaButton = (Button) findViewById(R.id.hulaButton);

        mHulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        mHulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hula));
        mHulaVideoView.setMediaController(new MediaController(this));


        // Associate MediaPlayer objects with the raw files
        mUkuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        mIpuMP = MediaPlayer.create(this, R.raw.ipu);
    }

    public void playMedia(View view) {

        // Determine which button was pressed
        switch(view.getId())
        {

            case R.id.ukuleleButton:
                if (mUkuleleMP.isPlaying())
                {
                    mUkuleleMP.pause();
                    mUkuleleButton.setText(R.string.ukulele_button_play_text);
                    mIpuButton.setVisibility(View.VISIBLE);
                    mHulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    mUkuleleMP.start();
                    mUkuleleButton.setText(R.string.ukulele_button_pause_text);
                    mIpuButton.setVisibility(View.INVISIBLE);
                    mHulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.ipuButton:
                if (mIpuMP.isPlaying())
                {
                    mIpuMP.pause();
                    mIpuButton.setText(R.string.ipu_button_play_text);
                    mUkuleleButton.setVisibility(View.VISIBLE);
                    mHulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    mIpuMP.start();
                    mIpuButton.setText(R.string.ipu_button_pause_text);
                    mUkuleleButton.setVisibility(View.INVISIBLE);
                    mHulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.hulaButton:
                if (mHulaVideoView.isPlaying())
                {
                    mHulaVideoView.pause();
                    mHulaButton.setText(R.string.hula_button_watch_text);
                    mIpuButton.setVisibility(View.VISIBLE);
                    mUkuleleButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    mHulaVideoView.start();
                    mHulaButton.setText(R.string.hula_button_pause_text);
                    mIpuButton.setVisibility(View.INVISIBLE);
                    mUkuleleButton.setVisibility(View.INVISIBLE);
                }
                break;

        }
    }
}
