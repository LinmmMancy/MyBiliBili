package com.mancy.mybilibili.LiveAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.DirecTvInfo;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class LiveAdapter extends RecyclerView.Adapter {

    public static final int BANNER = 0;
    public static final int XUANXIANG = 1;
    public static final int TUIJIANZHUBO = 2;
    private final Context context;
    private final DirecTvInfo.DataBean datas;


    private LayoutInflater layoutInflater;

    public int currenType = BANNER;


    public LiveAdapter(Context context, DirecTvInfo.DataBean datas) {
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currenType = BANNER;

        } else if (position == XUANXIANG) {
            currenType = XUANXIANG;
        } else if (position == TUIJIANZHUBO) {
            currenType = TUIJIANZHUBO;
        }
        return currenType;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 根据不同type
        if (viewType == BANNER) {

            return new BannerViewHolder(context, layoutInflater.inflate(R.layout.banner_viewpager, null));
        } else if (viewType == XUANXIANG) {
            return new XuanxiangViewhodler(context, layoutInflater.inflate(R.layout.xuanxiang_viewpager, null));


        }
        return null;
    }

    class XuanxiangViewhodler extends RecyclerView.ViewHolder {

        @InjectView(R.id.iv_guanzhu)
        ImageView ivGuanzhu;
        @InjectView(R.id.iv_zhongxin)
        ImageView ivZhongxin;
        @InjectView(R.id.iv_sousuo)
        ImageView ivSousuo;
        @InjectView(R.id.iv_fenlei)
        ImageView ivFenlei;

        public XuanxiangViewhodler(final Context context, View itemView) {
            super(itemView);

        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == BANNER) {

            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;


            bannerViewHolder.setData(datas.getBanner());

        } else if (getItemViewType(position) == XUANXIANG) {
            XuanxiangViewhodler xuanxiangViewhodler = (XuanxiangViewhodler) holder;
        }


    }


    class BannerViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        @InjectView(R.id.banner)
        Banner banner;

        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            banner = (Banner) itemView.findViewById(R.id.banner);

        }


        public void setData(List<DirecTvInfo.DataBean.BannerBean> data) {
            List<String> images = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                // images.add("http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b");
                images.add(data.get(0).getImg());
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
            banner.setBannerAnimation(BackgroundToForegroundTransformer.class);

            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();

                }
            });


        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
