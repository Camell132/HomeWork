package com.example.homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {
    private List<Number> numbers;
    private OnNumberClickListener listener;


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView numberView;

        ViewHolder(View itemView, final OnNumberClickListener onNumberClickListener) {
            super(itemView);
            numberView = itemView.findViewById(R.id.number1);
            numberView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView p = (TextView) v;
                    String num = p.getText().toString();
                    int col = p.getCurrentTextColor();
                    onNumberClickListener.onNumberClick(num, col);
                }

            });
        }
    }

    NumberAdapter(List<Number> numbers, OnNumberClickListener listener) {
        this.numbers = numbers;
        this.listener = listener;
    }

    @Override
    @NonNull
    public NumberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(NumberAdapter.ViewHolder viewHolder, int position) {
        Number number = numbers.get(position);
        viewHolder.numberView.setText(String.valueOf(number.getNum()));
        viewHolder.numberView.setTextColor(number.getColor());
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    void newAddedNumber() {
        notifyDataSetChanged();
    }
}


