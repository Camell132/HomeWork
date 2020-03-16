package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnNumberClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //проверка были\ ли уже создан фрагмент
        TableFragment fragment1 = (TableFragment) getSupportFragmentManager().findFragmentByTag("FR1");

        if (fragment1 == null) {
            fragment1 = new TableFragment();
            FragmentManager myFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = myFragmentManager
                    .beginTransaction();
            // добавляем в контейнер при помощи метода add()
            fragmentTransaction.add(R.id.container, fragment1, "FR1");
            fragmentTransaction.commit();
        }
    }

    private void showNumberFragment(String number, int color) {
        NumberFragment fragment2 = (NumberFragment) getSupportFragmentManager().findFragmentByTag("FR2");
        if (fragment2 == null) {
            fragment2 = new NumberFragment();
            fragment2.setNum(number, color);
            FragmentManager myFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = myFragmentManager
                    .beginTransaction();

            fragmentTransaction.replace(R.id.container, fragment2, "FR2");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onNumberClick(String num, int color) {
        showNumberFragment(num, color);
    }
}