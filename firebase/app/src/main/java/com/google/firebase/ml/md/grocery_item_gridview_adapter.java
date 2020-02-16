package com.google.firebase.ml.md;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class grocery_item_gridview_adapter extends BaseAdapter {

        private final Context mContext;
        private final ArrayList<GroceryItem> test_items;

        // 1
        public grocery_item_gridview_adapter(Context context, ArrayList<GroceryItem> test_items) {
            this.mContext = context;
            this.test_items = test_items;
        }

        // 2
        @Override
        public int getCount() {
            return 1;
            //items.count
        }

        // 3
        @Override
        public long getItemId(int position) {
            return 0;
        }

        // 4
        @Override
        public Object getItem(int position) {
            return null;
        }

        // 5
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView dummyTextView = new TextView(mContext);
            dummyTextView.setText(String.valueOf(position));
            return dummyTextView;
        }

}

