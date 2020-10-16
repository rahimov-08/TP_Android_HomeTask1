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


/**
 * Fragment showing a grid of numbers
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class GridFragment extends Fragment {

    private static final int DEFAULT_AMOUNT_OF_ITEMS = 100;
    private static final String STATE = "lastListSize";
    private List<Digit> digitList;

    public GridFragment(){
        this.setArguments(new Bundle());
        this.getArguments().putInt(STATE,DEFAULT_AMOUNT_OF_ITEMS);
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if(savedInstanceState == null)
//            listSize = DEFAULT_AMOUNT_OF_ITEMS;
//        else
//            listSize = savedInstanceState.getInt(STATE);
//    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(STATE,digitList.size());
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int listSize = getArguments().getInt(STATE);

        View fragment_layout = inflater.inflate(R.layout.grid_fragment,container,false);
        Button addBtn = fragment_layout.findViewById(R.id.add_btn);
        digitList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
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
    public void onStop() {
        super.onStop();
        getArguments().putInt(STATE,digitList.size());
    }
}
