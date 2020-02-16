package com.google.firebase.ml.md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class page_3 extends AppCompatActivity {

    public int store_button_index = 0;

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);

        Button button_1 = findViewById(R.id.page_3_button_1);
        Button button_2 = findViewById(R.id.page_3_button_2);
        Button button_3 = findViewById(R.id.page_3_button_3);

        button_1.setText(page_2.gf.storeList.get(0).name);
        button_2.setText(page_2.gf.storeList.get(1).name);
        button_3.setText(page_2.gf.storeList.get(2).name);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.page_3);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
    }

    public void page_3_button_1(View view) {
        store_button_index = 0;
        System.out.println(store_button_index);
        Intent intent = new Intent(page_3.this, page_3a.class);
        startActivity(intent);
    }

    public void page_3_button_2(View view) {
        store_button_index = 1;
        System.out.println(store_button_index);
        Intent intent = new Intent(page_3.this, page_3a.class);
        startActivity(intent);
    }

    public void page_3_button_3(View view) {
        store_button_index = 2;
        System.out.println(store_button_index);
        Intent intent = new Intent(page_3.this, page_3a.class);
        startActivity(intent);
    }
}
