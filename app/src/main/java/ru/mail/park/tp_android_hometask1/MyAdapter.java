package ru.mail.park.tp_android_hometask1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private  List<Digit> mDigits;
    private FragmentManager fragmentManager;

    public MyAdapter(List<Digit> mDigits, FragmentManager fragmentManager) {
        this.mDigits = mDigits;
        this.fragmentManager =  fragmentManager;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Digit model = mDigits.get(position);
        holder.value.setText(String.valueOf(model.getValue()));
        holder.value.setTextColor(model.getColor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, new DigitFragment())
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDigits.size();
    }
}
