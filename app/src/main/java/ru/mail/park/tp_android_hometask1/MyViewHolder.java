package ru.mail.park.tp_android_hometask1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ViewHolder for grid items
 * @autor Mahmudjon Rahimov
 * Created 14/10/2020
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    public final TextView value;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        value = itemView.findViewById(R.id.item);
    }
}
