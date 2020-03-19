package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnNumberClickListener {
    public static final String TAG1 = "TableFragment";
    public static final String TAG2 = "NumberFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //проверка были\ ли уже создан фрагмент
        TableFragment fragment1 = (TableFragment) getSupportFragmentManager().findFragmentByTag(TAG1);

        if (fragment1 == null) {
            fragment1 = new TableFragment();
            FragmentManager myFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = myFragmentManager
                    .beginTransaction();
            // добавляем в контейнер при помощи метода add()
            fragmentTransaction.add(R.id.container, fragment1, TAG1);
            fragmentTransaction.commit();
        }
    }

    private void showNumberFragment(String number, int color) {
            NumberFragment fragment2 = new NumberFragment();
            fragment2.setNum(number, color);
            FragmentManager myFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = myFragmentManager
                    .beginTransaction();

            fragmentTransaction.replace(R.id.container, fragment2, TAG2);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

    }

    @Override
    public void onNumberClick(String num, int color) {
        showNumberFragment(num, color);
    }
}