package ru.mail.park.tp_android_hometask1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mail.park.tp_android_hometask1.R;

/**
 * Fragment showing the pressed number
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class DigitFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("myLogs", "Fragment2  onCreateView");
        return inflater.inflate(R.layout.digit_fragment,container,false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("myLogs", "Fragment2  onAttach");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("myLogs", "Fragment2  onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("myLogs", "Fragment2  onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("myLogs", "Fragment2  onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("myLogs", "Fragment2  onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("myLogs", "Fragment2  onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("myLogs", "Fragment2  onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("myLogs", "Fragment2  onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myLogs", "Fragment2  onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("myLogs", "Fragment2  onDetach");
    }


    @Override
    public void onViewStateRestored(@Nullable final Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("myLogs", "Fragment2  onViewStateRestored");
    }
}
