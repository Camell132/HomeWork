package com.example.homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {
    private String number;
    private int color;
    private static final String KEY_NUMBER = "number";
    private static final String KEY_COLOR = "color";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        this.number = bundle.getString(KEY_NUMBER);
        this.color = bundle.getInt(KEY_COLOR);
    }

    //Связь фрагмента с разметкой
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView numberView = view.findViewById(R.id.textView);

        numberView.setText(this.number);
        numberView.setTextColor(this.color);
    }

    // обновление текстового поля
    void setNum(String num, int col) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NUMBER, num);
        bundle.putInt(KEY_COLOR, col);
        setArguments(bundle);
    }

}