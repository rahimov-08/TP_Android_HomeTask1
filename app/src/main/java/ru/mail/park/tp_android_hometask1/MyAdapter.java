package ru.mail.park.tp_android_hometask1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * RecyclerView Adapter for grid
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private  List<Digit> mDigits;
    private OnChangeFragmentListener onChangeFragmentListener;

    public MyAdapter(Context context, List<Digit> mDigits) {
        this.mDigits = mDigits;
        onChangeFragmentListener = (OnChangeFragmentListener) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Digit model = mDigits.get(position);
        holder.value.setText(String.valueOf(model.getValue()));
        holder.value.setTextColor(model.getColor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               onChangeFragmentListener.changeFragment(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDigits.size();
    }
}
