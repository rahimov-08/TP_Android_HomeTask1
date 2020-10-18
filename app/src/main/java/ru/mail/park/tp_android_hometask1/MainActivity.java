package ru.mail.park.tp_android_hometask1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Main activity of application
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class MainActivity extends AppCompatActivity implements OnChangeFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new GridFragment())
                    .commit();
    }

    /**
     * Changes GridFragment to DigitFragment
     * when number is clicked
     * @param model includes value and color
     *              of pressed number
     */
    @Override
    public void changeFragment(Digit model) {
        int value = model.getValue();
        int color = model.getColor();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DigitFragment.newInstance(value,color))
                .addToBackStack(null)
                .commit();
    }
}