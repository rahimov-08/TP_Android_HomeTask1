package ru.mail.park.tp_android_hometask1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mail.park.tp_android_hometask1.Digit;
import ru.mail.park.tp_android_hometask1.MyAdapter;
import ru.mail.park.tp_android_hometask1.R;

public class GridFragment extends Fragment {

    private static final int DEFAULT_AMOUNT_OF_ITEMS = 100;
    private static final String STATE = "lastListSize";
    private List<Digit> digitList;
    private int listSize;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("myLogs","Fragment1  onCreate");
        if(savedInstanceState == null)
            listSize = DEFAULT_AMOUNT_OF_ITEMS;
        else
            listSize = savedInstanceState.getInt(STATE);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE,digitList.size());
        Log.d("myLogs","Fragment1  onSaveInstanceState");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("myLogs","Fragment1  onCreateView");
        View fragment_layout = inflater.inflate(R.layout.grid_fragment,container,false);
        Button addBtn = fragment_layout.findViewById(R.id.add_btn);
        digitList = new ArrayList<>();
        for (int i = 0; i < listSize ; i++) {
            digitList.add(new Digit(i+1));
        }
        RecyclerView recyclerView = fragment_layout.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        final MyAdapter adapter = new MyAdapter(digitList,getFragmentManager());
        recyclerView.setAdapter(adapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digitList.add(new Digit(digitList.size()+1));
                adapter.notifyItemInserted(digitList.size());
            }
        });
        return fragment_layout;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("myLogs", "Fragment1  onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("myLogs", "Fragment1  onActivityCreated");
        if(savedInstanceState == null)
            listSize = DEFAULT_AMOUNT_OF_ITEMS;
        else
            listSize = savedInstanceState.getInt(STATE);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("myLogs", "Fragment1  onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("myLogs", "Fragment1  onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("myLogs", "Fragment1  onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("myLogs", "Fragment1  onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("myLogs", "Fragment1  onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myLogs", "Fragment1  onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("myLogs", "Fragment1  onDetach");
    }


    @Override
    public void onViewStateRestored(@Nullable final Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("myLogs", "Fragment1  onViewStateRestored");
    }



}
