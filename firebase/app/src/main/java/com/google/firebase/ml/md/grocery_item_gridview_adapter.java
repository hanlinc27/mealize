//package com.google.firebase.ml.md;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//public class grocery_item_gridview_adapter extends BaseAdapter {
//
//        private final Context mContext;
//        private final Item[] items;
//
//        // 1
//        public grocery_item_gridview_adapter(Context context, Items[] items) {
//            this.mContext = context;
//            this.items = items;
//        }
//
//        // 2
//        @Override
//        public int getCount() {
//            return items.length;
//        }
//
//        // 3
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        // 4
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        // 5
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            TextView dummyTextView = new TextView(mContext);
//            dummyTextView.setText(String.valueOf(position));
//            return dummyTextView;
//        }
//
//    }
//}
