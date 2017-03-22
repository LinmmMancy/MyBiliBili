package com.mancy.mybilibili.LiveAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.DirecTvInfo;
import com.mancy.mybilibili.gridrView.Constants;
import com.mancy.mybilibili.gridrView.HomeBean;
import com.mancy.mybilibili.gridrView.HotAdapter;
import com.mancy.mybilibili.gridrView.MyGridView;
import com.mancy.mybilibili.live.adpter.EnterAdapter;
import com.mancy.mybilibili.live.adpter.GameAdapter;
import com.mancy.mybilibili.live.adpter.MappingAdapter;
import com.mancy.mybilibili.live.adpter.SingAdapter;
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
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class LiveAdapter extends RecyclerView.Adapter {

    public static final int BANNER = 0;
    public static final int HOT = 1;
    public static final int MAPPING = 2;
    public static final int ENTETTAINMENT = 3;
    public static final int SING = 4;
    public static final int GAMES = 5;


    public int currenType = BANNER;

    private final Context context;


    private DirecTvInfo.DataBean datas;


    private LayoutInflater layoutInflater;


    private HomeBean.ResultBean result;
    private HotViewHolder hotViewHolder;


    public LiveAdapter(Context context, DirecTvInfo.DataBean datas) {
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currenType = BANNER;

        } else if (position == HOT) {
            currenType = HOT;
        } else if (position == MAPPING) {
            currenType = MAPPING;
        } else if (position == ENTETTAINMENT) {
            currenType = ENTETTAINMENT;
        } else if (position == SING) {
            currenType = SING;
        } else if (position == GAMES) {
            currenType = GAMES;
        }
        return currenType;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.setData(datas.getBanner());
        } else if (getItemViewType(position) == HOT) {
            hotViewHolder = (HotViewHolder) holder;
            getDataFromNet();
            // Log.e("TAG", "onBindViewHolder: ++++"+homeBean.getResult().getHot_info().toString());
        } else if (getItemViewType(position) == MAPPING) {
            MappingViewHolder mappingViewHolder = (MappingViewHolder) holder;
            mappingViewHolder.setData(datas.getPartitions());


        } else if (getItemViewType(position) == ENTETTAINMENT) {
            EnterViewHodler entettainment = (EnterViewHodler) holder;
            entettainment.setData(datas.getPartitions());
        } else if (getItemViewType(position) == SING) {
            SINGViewHodler entettainment = (SINGViewHodler) holder;
            entettainment.setData(datas.getPartitions());
        } else if (getItemViewType(position) == GAMES) {
            GAMESViewHodler gamesViewHodler = (GAMESViewHodler) holder;
            gamesViewHodler.setData(datas.getPartitions());


        }


    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 根据不同type
        if (viewType == BANNER) {

            return new BannerViewHolder(context, layoutInflater.inflate(R.layout.banner_viewpager, null));
        } else if (viewType == HOT) {
            return new HotViewHolder(context, layoutInflater.inflate(R.layout.hot_item, null));
        } else if (viewType == MAPPING) {
            return new MappingViewHolder(context, layoutInflater.inflate(R.layout.mapping_item, null));

        } else if (viewType == ENTETTAINMENT) {
            return new EnterViewHodler(context, layoutInflater.inflate(R.layout.enter_item, null));
        } else if (viewType == SING) {
            return new SINGViewHodler(context, layoutInflater.inflate(R.layout.sing_item, null));
        } else if (viewType == GAMES) {
            return new GAMESViewHodler(context, layoutInflater.inflate(R.layout.game_item, null));
        }
        return null;
    }

    class GAMESViewHodler extends RecyclerView.ViewHolder {
        @InjectView(R.id.title_pic)
        ImageView titlePic;
        @InjectView(R.id.titles)
        TextView titles;
        @InjectView(R.id.tv_more_hot)
        TextView tvMoreHot;
        @InjectView(R.id.gv_hot)
        MyGridView gvHot;

        private final Context context;
        GameAdapter adapter;

        public GAMESViewHodler(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.inject(this, itemView);

        }

        public void setData(List<DirecTvInfo.DataBean.PartitionsBean> partitions) {
            adapter = new GameAdapter(context, partitions);
            Glide.with(context)
                    .load(datas.getPartitions().get(3).getPartition().getSub_icon().getSrc())
                    .into(titlePic);
            titles.setText(datas.getPartitions().get(3).getPartition().getName());

            gvHot.setAdapter(adapter);

            gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

    class SINGViewHodler extends RecyclerView.ViewHolder {
        private final Context context;
        @InjectView(R.id.title_pic)
        ImageView titlePic;
        @InjectView(R.id.titles)
        TextView titles;
        @InjectView(R.id.tv_more_hot)
        TextView tvMoreHot;
        @InjectView(R.id.gv_hot)
        MyGridView gvHot;

        SingAdapter adapter;

        public SINGViewHodler(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.inject(this, itemView);
        }

        public void setData(List<DirecTvInfo.DataBean.PartitionsBean> partitions) {
            adapter = new SingAdapter(context, partitions);

            gvHot.setAdapter(adapter);
            titles.setText(datas.getPartitions().get(2).getLives().get(0).getArea());
            Glide.with(context)
                    .load(datas.getPartitions().get(2).getPartition().getSub_icon().getSrc())
                    .into(titlePic);

            gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    class EnterViewHodler extends RecyclerView.ViewHolder {

        private final Context context;
        @InjectView(R.id.tv_more_hot)
        TextView tvMoreHot;
        @InjectView(R.id.gv_hot)
        MyGridView gvHot;

        EnterAdapter adapter;


        public EnterViewHodler(Context context, View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            this.context = context;

        }

        public void setData(List<DirecTvInfo.DataBean.PartitionsBean> partitions) {
            adapter = new EnterAdapter(context, partitions);

            gvHot.setAdapter(adapter);
            gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "position" + parent, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    class MappingViewHolder extends RecyclerView.ViewHolder {

        private final Context context;

        @InjectView(R.id.tv_more_hot)
        TextView tvMoreHot;
        @InjectView(R.id.gv_hot)
        MyGridView gvHot;

        MappingAdapter mappingAdapter;

        public MappingViewHolder(Context context, View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            this.context = context;
        }

        public void setData(List<DirecTvInfo.DataBean.PartitionsBean> partitions) {
            Log.e("TAG", "setData: 111111111111111");

            mappingAdapter = new MappingAdapter(context, partitions);
            gvHot.setAdapter(mappingAdapter);

            gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }


    class HotViewHolder extends RecyclerView.ViewHolder {

        private final Context context;
        @InjectView(R.id.tv_more_hot)
        TextView tvMoreHot;
        @InjectView(R.id.gv_hot)
        MyGridView gvHot;

        HotAdapter hotAdapter;


        public HotViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.inject(this, itemView);

        }

        public void setData(List<HomeBean.ResultBean.HotInfoBean> hot_info) {


            hotAdapter = new HotAdapter(context, hot_info);

            gvHot.setAdapter(hotAdapter);

            // 设置点击事件
            gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "111", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }


    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.HOME_URL)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError: 联网失败" + e.getMessage());

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse: 联网成功");
                        processData(response);
                    }
                });


    }

    private void processData(String response) {
        HomeBean homeBean = JSON.parseObject(response, HomeBean.class);
        result = homeBean.getResult();
        hotViewHolder.setData(result.getHot_info());

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
            for (int i = 0; i <=1; i++) {
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
            //  banner.setBannerAnimation(BackgroundToForegroundTransformer.class);

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
        return 6;
    }
}
