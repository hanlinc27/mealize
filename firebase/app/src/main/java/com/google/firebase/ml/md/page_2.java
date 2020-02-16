package com.google.firebase.ml.md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class page_2 extends AppCompatActivity {

    EditText user_edit;

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.page_2);

        user_edit   = (EditText) findViewById(R.id.postal_code_text);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
    }

    public void page_2_button(View view) throws java.io.IOException, org.json.simple.parser.ParseException {
        String postalCode = user_edit.getText().toString();
        postalCode = GroceryFetcher.getValidPostalCode("l4h2w8");
        GroceryFetcher.getGroceryInfo(postalCode);

        //Intent intent = new Intent(page_2.this, page_3.class);
        //startActivity(intent);

    }
}
