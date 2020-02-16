//package com.google.firebase.ml.md;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.GridView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatDelegate;
//
//public class page_3a extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(@Nullable Bundle bundle) {
//        super.onCreate(bundle);
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
//        setContentView(R.layout.page_3a);
//
//
//
//        GridView gridView = (GridView)findViewById(R.id.page_3a);
//        grocery_item_gridview_adapter itemsAdapter = new grocery_item_gridview_adapter(this, items);
//        gridView.setAdapter(grocery_item_gridview_adapter);
//
//        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
//        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
//    }
//}
