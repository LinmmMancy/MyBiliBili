package com.mancy.mybilibili.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by linmingming(林明明) on 2017/3/25.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class FanJuBean {

    /**
     * code : 0
     * data : [{"title":"【1月】小林家的龙女仆 11【独家正版】","cover":"http://i1.hdslb.com/bfs/archive/a1080d35c404c099ee066646113fca17a5f131e5.jpg_320x200.jpg","uri":"bilibili://video/9326290","param":"9326290","goto":"av","name":"哔哩哔哩番剧","play":928994,"danmaku":25204,"pts":550531},{"title":"【1月/完结】火影忍者 疾风传 720","cover":"http://i0.hdslb.com/bfs/archive/2deda6733b8266ec67ae536aee93aa068ecdc5d7.jpg_320x200.jpg","uri":"bilibili://video/9341465","param":"9341465","goto":"av","name":"TV-TOKYO","play":340312,"danmaku":33394,"pts":390512},{"title":"【1月】珈百璃的堕落 11","cover":"http://i0.hdslb.com/bfs/archive/050cee70527166eed3a8f9c85007e83dbd6f77d1.jpg_320x200.jpg","uri":"bilibili://video/9291420","param":"9291420","goto":"av","name":"哔哩哔哩番剧","play":470649,"danmaku":13921,"pts":363758},{"title":"【4月】双星之阴阳师 49","cover":"http://i1.hdslb.com/bfs/archive/4a69258c93dba82814810066f57b0f981a3d3ac5.jpg_320x200.jpg","uri":"bilibili://video/9323043","param":"9323043","goto":"av","name":"TV-TOKYO","play":282677,"danmaku":10193,"pts":244704},{"title":"【1月】小林家的龙女仆 10【独家正版】","cover":"http://i1.hdslb.com/bfs/archive/c1ef52083ec6339fba7eac7ce796ef9f37bbaf12.jpg_320x200.jpg","uri":"bilibili://video/9187768","param":"9187768","goto":"av","name":"哔哩哔哩番剧","play":213180,"danmaku":3348,"pts":200099},{"title":"【1月/完结】黑白来看守所 25【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/cd8f757cd39cd5be9b83d85532ea925bdd36f39a.jpg_320x200.jpg","uri":"bilibili://video/9310212","param":"9310212","goto":"av","name":"哔哩哔哩番剧","play":190042,"danmaku":5266,"pts":170806},{"title":"【1月】人渣的本愿 10【幻樱/澄空学园】","cover":"http://i0.hdslb.com/bfs/archive/c4f451cfe07a9fe1c056a2c111fad82ba8c25c73.jpg_320x200.jpg","uri":"bilibili://video/9208819","param":"9208819","goto":"av","name":"真鱼","play":142348,"danmaku":2719,"pts":133250},{"title":"【1月】小林家的龙女仆 01【独家正版】","cover":"http://i1.hdslb.com/bfs/archive/4a2420aa6d3664aa69fe35e94fdaac364a053452.jpg_320x200.jpg","uri":"bilibili://video/7961887","param":"7961887","goto":"av","name":"哔哩哔哩番剧","play":127079,"danmaku":-458,"pts":121300},{"title":"【1月】Hand Shakers 11","cover":"http://i0.hdslb.com/bfs/archive/87e7c602d482a2628a1c2ddf68f9b15cf9ed42d6.jpg_320x200.jpg","uri":"bilibili://video/9305917","param":"9305917","goto":"av","name":"哔哩哔哩番剧","play":113388,"danmaku":1801,"pts":112642},{"title":"【1月】小林家的龙女仆 02【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/fbc8ce3986e7dd4d587501fa1dde45d8d729da47.jpg_320x200.jpg","uri":"bilibili://video/8084513","param":"8084513","goto":"av","name":"哔哩哔哩番剧","play":106208,"danmaku":998,"pts":105966},{"title":"【1月】小林家的龙女仆 09【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/1ec8ffb12a9c6313cba04cd7ac27cd47eb39a3fc.jpg_320x200.jpg","uri":"bilibili://video/9042355","param":"9042355","goto":"av","name":"哔哩哔哩番剧","play":101579,"danmaku":1234,"pts":102479},{"title":"【1月】人渣的本愿 01【幻樱/澄空】","cover":"http://i0.hdslb.com/bfs/archive/b61bc343b7bf19f82c30b671615bd0df9aad4fbb.jpg_320x200.jpg","uri":"bilibili://video/7964205","param":"7964205","goto":"av","name":"真鱼","play":106977,"danmaku":1546,"pts":97296},{"title":"【1月】ACCA13区监察课 11","cover":"http://i0.hdslb.com/bfs/archive/2e5d701c8e680bdf00b4e4e64b102d113ffac6fc.jpg_320x200.jpg","uri":"bilibili://video/9309906","param":"9309906","goto":"av","name":"哔哩哔哩番剧","play":98207,"danmaku":3337,"pts":94545},{"title":"【1月】One Room 11【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/f1658f3ead2dccd45186cfb9efcc34608ed26f11.jpg_320x200.jpg","uri":"bilibili://video/9324701","param":"9324701","goto":"av","name":"哔哩哔哩番剧","play":97680,"danmaku":1162,"pts":91861},{"title":"【1月】小林家的龙女仆 03【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/bed04be09056c1ed547cfe7571511f3a2caf2e59.jpg_320x200.jpg","uri":"bilibili://video/8212411","param":"8212411","goto":"av","name":"哔哩哔哩番剧","play":89939,"danmaku":634,"pts":82085},{"title":"【1月】小林家的龙女仆 08【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/f952f9281e98422e38d8f3bebb271534e809046f.jpg_320x200.jpg","uri":"bilibili://video/8908904","param":"8908904","goto":"av","name":"哔哩哔哩番剧","play":87881,"danmaku":866,"pts":80155},{"title":"【1月】小林家的龙女仆 04【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/b0ea2b22c5cf52125b32eb8a843d3bf2160ea9bc.jpg_320x200.jpg","uri":"bilibili://video/8334007","param":"8334007","goto":"av","name":"哔哩哔哩番剧","play":87352,"danmaku":1076,"pts":79739},{"title":"【1月】小林家的龙女仆 06【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/56d6792656c00772fd3eab4e721db904442bf68c.jpg_320x200.jpg","uri":"bilibili://video/8636310","param":"8636310","goto":"av","name":"哔哩哔哩番剧","play":85454,"danmaku":966,"pts":78131},{"title":"【1月】小林家的龙女仆 07【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/68b92e978b75024e6b9b33067db3ab9299cf3a45.jpg_320x200.jpg","uri":"bilibili://video/8764173","param":"8764173","goto":"av","name":"哔哩哔哩番剧","play":84870,"danmaku":987,"pts":77157},{"title":"【1月】小林家的龙女仆 05【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/5698a5858bfb26b0e1993ffe1ac22dba87fb8dcd.jpg_320x200.jpg","uri":"bilibili://video/8487114","param":"8487114","goto":"av","name":"哔哩哔哩番剧","play":82303,"danmaku":1050,"pts":75076}]
     * message :
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 【1月】小林家的龙女仆 11【独家正版】
         * cover : http://i1.hdslb.com/bfs/archive/a1080d35c404c099ee066646113fca17a5f131e5.jpg_320x200.jpg
         * uri : bilibili://video/9326290
         * param : 9326290
         * goto : av
         * name : 哔哩哔哩番剧
         * play : 928994
         * danmaku : 25204
         * pts : 550531
         */

        private String title;
        private String cover;
        private String uri;
        private String param;
        @SerializedName("goto")
        private String gotoX;
        private String name;
        private int play;
        private int danmaku;
        private int pts;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public int getPts() {
            return pts;
        }

        public void setPts(int pts) {
            this.pts = pts;
        }
    }
}
