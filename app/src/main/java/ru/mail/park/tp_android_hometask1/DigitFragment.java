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

    public static DigitFragment newInstance(int value, int color) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_VALUE,value);
        args.putInt(EXTRA_COLOR,color);
        DigitFragment fragment = new DigitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String value = String.valueOf(getArguments().getInt(EXTRA_VALUE));
        int color = getArguments().getInt(EXTRA_COLOR);

        View view = inflater.inflate(R.layout.digit_fragment,container,false);
        TextView digitTextView = view.findViewById(R.id.digit);
        digitTextView.setText(value);
        digitTextView.setTextColor(color);
        return view;
    }
}
