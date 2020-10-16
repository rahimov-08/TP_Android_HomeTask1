package ru.mail.park.tp_android_hometask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Main activity of application
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new GridFragment())
                    .commitAllowingStateLoss();
    }
}