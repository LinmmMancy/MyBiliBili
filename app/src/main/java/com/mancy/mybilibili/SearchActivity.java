package com.mancy.mybilibili;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchActivity extends AppCompatActivity {
    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};
    @InjectView(R.id.searchView)
    SearchView searchView;
    @InjectView(R.id.listView)
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.inject(this);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        listView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    listView.setFilterText(newText);
                } else {
                    listView.clearTextFilter();
                }
                return false;
            }
        });

    }
}
