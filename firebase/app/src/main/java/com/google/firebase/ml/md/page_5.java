package com.google.firebase.ml.md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class page_5 extends AppCompatActivity {

    public int restriction_button_index = 0;

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.page_5);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
    }

    public void page_5_button_1(View view) {
        restriction_button_index = 0;

        Intent intent = new Intent(page_5.this, page_6.class);
        startActivity(intent);

    }

    public void page_5_button_2(View view) {
        restriction_button_index = 1;

        Intent intent = new Intent(page_5.this, page_6.class);
        startActivity(intent);

    }

    public void page_5_button_3(View view) {
        restriction_button_index = 2;

        Intent intent = new Intent(page_5.this, page_6.class);
        startActivity(intent);

    }
    public void page_5_skip_button (View view) {
        Intent intent = new Intent(page_5.this, page_6.class);
        startActivity(intent);
    }
}

