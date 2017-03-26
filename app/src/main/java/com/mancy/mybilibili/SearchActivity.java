package com.mancy.mybilibili;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchActivity extends AppCompatActivity {


    @InjectView(R.id.iv_search_back)
    ImageView ivSearchBack;
    @InjectView(R.id.et_search_keyword)
    EditText etSearchKeyword;
    @InjectView(R.id.iv_search_search)
    ImageView ivSearchSearch;
    @InjectView(R.id.ll_layout)
    LinearLayout llLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.inject(this);

        SearchFragment searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
            @Override
            public void OnSearchClick(String keyword) {
                Toast.makeText(SearchActivity.this, "1", Toast.LENGTH_SHORT).show();


            }
        });
        searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
        initListener();
    }

    private void initListener() {
        ivSearchSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        etSearchKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = SearchFragment.newInstance();
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        Toast.makeText(SearchActivity.this, "1", Toast.LENGTH_SHORT).show();


                    }
                });
                searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
            }
        });
        ivSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
