package com.mancy.mybilibili.faxian.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.faxian.bean.ShopXiangqing;
import com.mancy.mybilibili.gen.MyApplication;
import com.mancy.mybilibili.gen.ShopXiangqingDao;
import com.mancy.mybilibili.gridrView.GoodsBean;
import com.mancy.mybilibili.utils.AddSubView;
import com.mancy.mybilibili.utils.VirtualkeyboardHeight;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShopInfoActivity extends AppCompatActivity {


    @InjectView(R.id.ib_good_info_back)
    ImageButton ibGoodInfoBack;
    @InjectView(R.id.ib_good_info_more)
    ImageButton ibGoodInfoMore;
    @InjectView(R.id.iv_good_info_image)
    ImageView ivGoodInfoImage;
    @InjectView(R.id.tv_good_info_name)
    TextView tvGoodInfoName;
    @InjectView(R.id.tv_good_info_desc)
    TextView tvGoodInfoDesc;
    @InjectView(R.id.tv_good_info_price)
    TextView tvGoodInfoPrice;
    @InjectView(R.id.tv_good_info_store)
    TextView tvGoodInfoStore;
    @InjectView(R.id.tv_good_info_style)
    TextView tvGoodInfoStyle;
    @InjectView(R.id.wb_good_info_more)
    WebView wbGoodInfoMore;
    @InjectView(R.id.progressbar)
    ProgressBar progressbar;
    @InjectView(R.id.tv_good_info_callcenter)
    TextView tvGoodInfoCallcenter;
    @InjectView(R.id.tv_good_info_collection)
    TextView tvGoodInfoCollection;
    @InjectView(R.id.tv_good_info_cart)
    TextView tvGoodInfoCart;
    @InjectView(R.id.btn_good_info_addcart)
    Button btnGoodInfoAddcart;
    @InjectView(R.id.ll_goods_root)
    LinearLayout llGoodsRoot;
    @InjectView(R.id.tv_more_share)
    TextView tvMoreShare;
    @InjectView(R.id.tv_more_search)
    TextView tvMoreSearch;
    @InjectView(R.id.tv_more_home)
    TextView tvMoreHome;
    @InjectView(R.id.btn_more)
    Button btnMore;
    @InjectView(R.id.ll_root)
    LinearLayout llRoot;
    private String title;
    private String imags;
    private String jiage;


    private ShopXiangqing shopXiangqing;

    private ShopXiangqingDao shopXiangqingDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);
        ButterKnife.inject(this);
        shopXiangqingDao = MyApplication.getInstances().getDaoSession().getShopXiangqingDao();
        getData();
    }

    private void getData() {

        //设置数据

        title = getIntent().getStringExtra(ShopHomeFragment.TITLE);
        imags = getIntent().getStringExtra(ShopHomeFragment.IMAGES);
        jiage = getIntent().getStringExtra(ShopHomeFragment.JIAGE);

        //设置图片
        Glide.with(this)
                .load(imags)
                .into(ivGoodInfoImage);


        //设置 名称 和 价格

        tvGoodInfoName.setText(title);

        tvGoodInfoPrice.setText("￥" + jiage);
    }

    @OnClick({R.id.ib_good_info_back, R.id.ib_good_info_more, R.id.wb_good_info_more, R.id.tv_good_info_callcenter, R.id.tv_good_info_collection, R.id.tv_good_info_cart, R.id.btn_good_info_addcart, R.id.tv_more_share, R.id.tv_more_search, R.id.tv_more_home, R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            // 返回
            case R.id.ib_good_info_back:
                finish();

                break;
            case R.id.ib_good_info_more:
                //    Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
                // 如果显示
                if (llRoot.isShown()) {
                    //隐藏
                    llRoot.setVisibility(View.GONE);


                } else {
                    // 显示
                    llRoot.setVisibility(View.VISIBLE);

                }


                break;

            case R.id.tv_good_info_callcenter:
                Toast.makeText(this, "客服中心", Toast.LENGTH_SHORT).show();


                break;
            case R.id.tv_good_info_collection:
                Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_good_info_cart:
                Toast.makeText(this, "购物车", Toast.LENGTH_SHORT).show();


                break;
            case R.id.btn_good_info_addcart:
                Toast.makeText(this, "添加到购物车", Toast.LENGTH_SHORT).show();
//                CartStorage.getInstance(this).addData(goodsBean);
                showPopwindow();

                break;
            case R.id.tv_more_share:

                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();

//                Intent intent1 = new Intent(this, WeiMaActivity.class);
//                intent1.putExtra("asd", goodsBean.getFigure());
//
//                startActivity(intent1);


                break;
            case R.id.tv_more_search:
//
//                intent = new Intent(this, SearchActivity.class);
//                startActivity(intent);


                break;
            case R.id.tv_more_home:

                Toast.makeText(this, "主页", Toast.LENGTH_SHORT).show();


                break;
            case R.id.btn_more:

                //     Toast.makeText(this, "消失更多的页面", Toast.LENGTH_SHORT).show();
                llRoot.setVisibility(View.GONE);

                break;
        }
    }


    //缓存
    private GoodsBean tempGoodsBean;
    //该商品信息是否在购物车中存在
    private boolean isExist = false;


    private void showPopwindow() {
//        tempGoodsBean = CartStorage.getInstance(this).fingdDete(goodsBean.getProduct_id());
//        if (tempGoodsBean == null) {
//
//            isExist = false;
//            tempGoodsBean = goodsBean;
//        } else {
//            isExist = true;
//        }


        // 1 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow_add_product, null);

        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);


        // 4 控件处理
        ImageView iv_goodinfo_photo = (ImageView) view.findViewById(R.id.iv_goodinfo_photo);
        TextView tv_goodinfo_name = (TextView) view.findViewById(R.id.tv_goodinfo_name);
        TextView tv_goodinfo_price = (TextView) view.findViewById(R.id.tv_goodinfo_price);
        AddSubView nas_goodinfo_num = (AddSubView) view.findViewById(R.id.nas_goodinfo_num);
        Button bt_goodinfo_cancel = (Button) view.findViewById(R.id.bt_goodinfo_cancel);
        Button bt_goodinfo_confim = (Button) view.findViewById(R.id.bt_goodinfo_confim);

        // 加载图片
        Glide.with(ShopInfoActivity.this)
                .load(imags)
                .into(iv_goodinfo_photo);

        // 名称
        tv_goodinfo_name.setText(title);
        // 显示价格
        tv_goodinfo_price.setText(jiage);

        // 设置最大值和当前值
        nas_goodinfo_num.setMaxValue(100);//库存100

//        nas_goodinfo_num.setValue(tempGoodsBean.getNumber());


        nas_goodinfo_num.setOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void onNumberChanger(int value) {
//                tempGoodsBean.setNumber(value);
            }
        });

        bt_goodinfo_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
//                if (isExist && tempGoodsBean.getNumber() == 1) {
//                    tempGoodsBean.setNumber(tempGoodsBean.getNumber() + 1);
//                }
            }
        });

        bt_goodinfo_confim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                //添加购物车
//                CartStorage.getInstance(GoodsInfoActivity.this).addData(tempGoodsBean);
                // Log.e("TAG", "66:" + tempGoodsBean.toString());
                Toast.makeText(ShopInfoActivity.this, "添加购物车成功", Toast.LENGTH_SHORT).show();

                shopXiangqing = new ShopXiangqing(null, imags, title, jiage, true);

                shopXiangqingDao.insert(shopXiangqing);


//                Toast.makeText(ShopInfoActivity.this, "存储数据成功", Toast.LENGTH_SHORT).show();


            }
        });

        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });

        // 5 在底部显示
        window.showAtLocation(ShopInfoActivity.this.findViewById(R.id.ll_goods_root),
                Gravity.BOTTOM, 0, VirtualkeyboardHeight.getBottomStatusHeight(ShopInfoActivity.this));

    }

}
