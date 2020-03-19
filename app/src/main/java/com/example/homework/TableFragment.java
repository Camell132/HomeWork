package com.example.homework;
import android.content.res.Configuration;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class TableFragment extends Fragment implements OnNumberClickListener {
    private int maxNumber = 100;
    private List<Number> numbers = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            maxNumber = savedInstanceState.getInt("MAX" ,maxNumber);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Привязка фрагмента к xml разметке
        final View view = inflater.inflate(R.layout.fragment_table, container, false);

        //создание списка
        numbers = tableNumbers (maxNumber);

        final RecyclerView recyclerView = view.findViewById(R.id.list);

        final NumberAdapter adapter = new NumberAdapter(numbers, this);
        recyclerView.setAdapter(adapter);

        Button addButton = view.findViewById(R.id.addbutton);

        //Определение разметки таблицы согласно ориентации экрана

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 4));
        }
        //Обработка нажатия на кнопку добавления чисел
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.add(new Number(++maxNumber));
                adapter.newAddedNumber(numbers.size()-1);
                recyclerView.scrollToPosition(numbers.size()-1);


            }
        });
        return view;

    }
    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("MAX",maxNumber);
    }

//Создание списка чисел от 1 до 100
    private List<Number> tableNumbers(int amount) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            numbers.add(new Number(i));
        }
        return numbers;
    }
    @Override
    public void onNumberClick(String num, int color) {
        ((OnNumberClickListener) (requireActivity())).onNumberClick(num, color);
    }
}

