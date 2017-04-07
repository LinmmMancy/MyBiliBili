package com.mancy.mybilibili.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by linmingming(林明明) on 2017/3/28.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
@Entity
public class ShopXiangqing {
    @Id
    private Long id;
    //name
    private String title;
    // 价格
    private String jiage;
    // tupian
    private String photo;

    private boolean iscked = true;

    private int number = 1;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getIscked() {
        return this.iscked;
    }

    public void setIscked(boolean iscked) {
        this.iscked = iscked;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getJiage() {
        return this.jiage;
    }

    public void setJiage(String jiage) {
        this.jiage = jiage;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 1879974029)
    public ShopXiangqing(Long id, String title, String jiage, String photo,
            boolean iscked, int number) {
        this.id = id;
        this.title = title;
        this.jiage = jiage;
        this.photo = photo;
        this.iscked = iscked;
        this.number = number;
    }

    @Generated(hash = 79786367)
    public ShopXiangqing() {
    }
}
