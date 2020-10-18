package ru.mail.park.tp_android_hometask1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Fragment showing the pressed number
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class DigitFragment extends Fragment {

    private static final String EXTRA_VALUE = "digitValue";
    private static final String EXTRA_COLOR = "digitColor";
    private String value;
    private int color;

    public static DigitFragment newInstance(int value, int color) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_VALUE,value);
        args.putInt(EXTRA_COLOR,color);
        DigitFragment fragment = new DigitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView digitTextView = view.findViewById(R.id.digit);
        digitTextView.setText(value);
        digitTextView.setTextColor(color);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        value = String.valueOf(getArguments().getInt(EXTRA_VALUE));
        color = getArguments().getInt(EXTRA_COLOR);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.digit_fragment,container,false);
    }
}
