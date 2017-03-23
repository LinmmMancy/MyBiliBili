package com.mancy.mybilibili.ZhuiAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.ZhuiFan.ZhuiFanAdapter;
import com.mancy.mybilibili.ZhuiFan.ZhuiFanAdapter2;
import com.mancy.mybilibili.bean.DirecTvInfo;
import com.mancy.mybilibili.bean.RunPlayBean;
import com.mancy.mybilibili.bean.ZhuiFanBannerBean;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by linmingming(林明明) on 2017/3/23.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class ZhuiAdapter extends RecyclerView.Adapter {


    private BANNERViewHolder bannerViewHolder;

    private void getDataFromNet() {

        OkHttpUtils.get()
                .url("http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError:  失败 " + e.getMessage());


                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse:  联网成功");
                        processData(response);
                    }
                });


    }


    private void processData(String json) {
        DirecTvInfo direcTvInfo = new Gson().fromJson(json, DirecTvInfo.class);
        dataBean = direcTvInfo.getData();
        bannerViewHolder.setData(dataBean.getBanner());
    }


    private DirecTvInfo.DataBean dataBean;

//

    public static final int LOGIN = 0;
    public static final int GVIEW1 = 1;
    public static final int BANNER = 2;
    public static final int GVIEW2 = 3;

    public int currenType = LOGIN;


    private final Context context;
    private final RunPlayBean datas;


    private LayoutInflater layoutInflater;

    public ZhuiAdapter(Context context, RunPlayBean datas) {
        this.context = context;
        this.datas = datas;

        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemViewType(int position) {

        if (position == LOGIN) {
            currenType = LOGIN;

        } else if (position == GVIEW1) {
            currenType = GVIEW1;
        } else if (position == BANNER) {
            currenType = BANNER;
        } else if (position == GVIEW2) {
            currenType = GVIEW2;
        }

        return currenType;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == LOGIN) {
            LoginViewHolder loginViewHolder = (LoginViewHolder) holder;
            loginViewHolder.setData();
        }
        if (getItemViewType(position) == GVIEW1) {
            Gview1ViewHolder gview1ViewHolder = (Gview1ViewHolder) holder;
            gview1ViewHolder.setData(datas.getResult());

        }
        if (getItemViewType(position) == BANNER) {
            bannerViewHolder = (BANNERViewHolder) holder;

            getDataFromNet();
        }
        if (getItemViewType(position) == GVIEW2) {
            GVIEW2ViewHolder gview2ViewHolder = (GVIEW2ViewHolder) holder;
            gview2ViewHolder.setData(datas.getResult());

        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 根据不同type
        if (viewType == LOGIN) {

            return new LoginViewHolder(context, layoutInflater.inflate(R.layout.zhuifan_login, null));
        }
        if (viewType == GVIEW1) {

            return new Gview1ViewHolder(context, layoutInflater.inflate(R.layout.zhuifan_gview1, null));
        }
        if (viewType == BANNER) {

            return new BANNERViewHolder(context, layoutInflater.inflate(R.layout.zhuifan_banner, null));
        }
        if (viewType == GVIEW2) {

            return new GVIEW2ViewHolder(context, layoutInflater.inflate(R.layout.zhuifan_gview2, null));
        }
        return null;
    }

    class GVIEW2ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        @InjectView(R.id.ll_more_play)
        LinearLayout llMorePlay;
        @InjectView(R.id.gv_play2)
        GridView gvPlay2;

        ZhuiFanAdapter2 adapter2;

        public GVIEW2ViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.inject(this, itemView);
        }

        public void setData(RunPlayBean.ResultBean result) {

            adapter2 = new ZhuiFanAdapter2(context, result);
            gvPlay2.setAdapter(adapter2);
            gvPlay2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    class BANNERViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        @InjectView(R.id.banner)
        Banner banner;
        private List<ZhuiFanBannerBean.ResultBean> data;

        public BANNERViewHolder(Context context, View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            this.context = context;
        }

        public void setData(List<DirecTvInfo.DataBean.BannerBean> banner1) {
            List<String> images = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                images.add(banner1.get(0).getImg());
            }
            banner.setImages(images).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context)
                            .load(path)
                            .crossFade()
                            .into(imageView);

                }
            }).start();
            //  banner.setBannerAnimation(BackgroundToForegroundTransformer.class);
            banner.isAutoPlay(false);

            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();

                }
            });


        }
    }


    class Gview1ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.ll_more_play)
        LinearLayout llMorePlay;
        @InjectView(R.id.gv_play1)
        GridView gvPlay1;


        private ZhuiFanAdapter adapter;

        private final Context context;

        public Gview1ViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.inject(this, itemView);
        }

        public void setData(RunPlayBean.ResultBean datas) {
            adapter = new ZhuiFanAdapter(context, datas);
            gvPlay1.setAdapter(adapter);

            gvPlay1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    class LoginViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.imageView3)
        ImageView imageView3;
        @InjectView(R.id.imageView4)
        ImageView imageView4;
        @InjectView(R.id.textView4)
        TextView textView4;

        private final Context context;

        public LoginViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
        }


        public void setData() {

        }
    }


    @Override
    public int getItemCount() {
        return 4;
    }
}
