package ru.mail.park.tp_android_hometask1;

import android.content.res.Configuration;
import android.os.Bundle;
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


/**
 * Fragment showing a grid of numbers
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class GridFragment extends Fragment {

    private static final int DEFAULT_AMOUNT_OF_ITEMS = 100;
    private static final String STATE = "lastListSize";
    private List<Digit> digitList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int listSize;
        if(savedInstanceState == null)
            listSize = DEFAULT_AMOUNT_OF_ITEMS;
        else
            listSize = savedInstanceState.getInt(STATE);
        digitList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            digitList.add(new Digit(i+1));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE,digitList.size());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.grid_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button addBtn = view.findViewById(R.id.add_btn);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        int numberOfColumns = getResources().getInteger(R.integer.gridColNums);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),numberOfColumns));
        final MyAdapter adapter = new MyAdapter(getContext(),digitList);
        recyclerView.setAdapter(adapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digitList.add(new Digit(digitList.size()+1));
                adapter.notifyItemInserted(digitList.size());
            }
        });
    }
}
