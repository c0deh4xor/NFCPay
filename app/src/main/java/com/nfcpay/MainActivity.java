package com.nfcpay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nfcpay.adapter.MyGridViewAdapter;
import com.nfcpay.domain.Business;
import com.nfcpay.domain.Function;
import com.nfcpay.adapter.MyListViewAdapter;
import com.nfcpay.view.MyImageIndicatorView;
import com.panxw.android.imageindicator.AutoPlayManager;
import com.panxw.android.imageindicator.ImageIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toast toast;
    private MyImageIndicatorView imageIndicatorView;//轮播图view
    private List<String> picUrls;  //轮播图url
    private GridView gridView;//首页girdview
    private List<Function> functions; //功能集合
    private ListAdapter gridviewAdapter;
    private ListView recommend;//推荐列表
    private List<Business> recommendBusiness;  //推荐商家列表
    private ListAdapter recommendListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void initEvents() {
        //定位点击事件
        findViewById(R.id.id_linearlayout_location).setOnClickListener(this);

        //搜索按钮点击事件
        findViewById(R.id.id_search).setOnClickListener(this);

        //轮播图点击事件
        imageIndicatorView.setOnItemClickListener(new ImageIndicatorView.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                showToast(position + "");
            }
        });

        //gridview点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast(position + "");
            }
        });

        recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast(position + "");
            }
        });
    }

    private void initViews() {

        picUrls = new ArrayList<String>();
        picUrls.add("http://pic2.ooopic.com/12/52/76/42bOOOPIC81_1024.jpg");
        picUrls.add("http://pic38.nipic.com/20140228/11198373_150351517317_2.jpg");
        picUrls.add("http://pic.58pic.com/58pic/16/93/40/65E58PICnVz_1024.jpg");

        imageIndicatorView = (MyImageIndicatorView) findViewById(R.id.id_imageIndicator);
        imageIndicatorView.setupLayoutByUrls(picUrls);
        imageIndicatorView.setIndicateStyle(ImageIndicatorView.INDICATE_ARROW_ROUND_STYLE);
        imageIndicatorView.show();

        //自动播放
        AutoPlayManager autoBrocastManager = new AutoPlayManager(imageIndicatorView);
        autoBrocastManager.setBroadcastEnable(true);
        autoBrocastManager.setBroadCastTimes(-1);//loop times
        autoBrocastManager.setBroadcastTimeIntevel(3 * 1000, 3 * 1000);//set first play time and interval
        autoBrocastManager.loop();

        gridView = (GridView) findViewById(R.id.id_girdview);
        functions = new ArrayList<Function>();
        functions.add(new Function("乘公交", getResources(), R.drawable.bus_icon));
        functions.add(new Function("乘地铁", getResources(), R.drawable.subway_icon));
        functions.add(new Function("看电影", getResources(), R.drawable.film_icon));
        functions.add(new Function("风景区", getResources(), R.drawable.travel_icon));
        functions.add(new Function("去购物", getResources(), R.drawable.shop_icon));
        functions.add(new Function("更多", getResources(), R.drawable.more_icon));
        gridviewAdapter = new MyGridViewAdapter(this, functions);
        gridView.setAdapter(gridviewAdapter);


        recommendBusiness = new ArrayList<Business>();
        recommendBusiness.add(new Business("东湖听涛景区",
                "东湖听涛风景区位于东湖西北岸，是东湖风景区中最早建成开放的景区。该景区建有以纪念爱国诗人屈原为主体的景点群，还有新建的沙滩浴场，是夏夜人们纳凉避暑、戏水休憩的好地方。",
                "http://bbsimg1.tuniucdn.com/data/attachment/forum/201403/22/125635nja9rtaeezep9yr7.jpg",
                142.2f));
        recommendBusiness.add(new Business("巨幕影城",
                "巨幕影城（武汉光谷广场资本大厦店）是目前中国最大的影城、华中第一家“中国巨幕”影城。影城面积16873平方米、11个厅、2500座、巨幕、3D、商业街应有尽有。 巨幕影城（武汉光谷广场资本大厦店）是目前中国电影业态最丰富、电影文化最全面、相关产业最配套的电影文化城，巨幕影城（武汉光谷广场资本大厦店）是目前中国档次最高、技术最先进、内涵最丰富的电影文化中心。 ",
                "http://p0.meituan.net/deal/__41683164__4811680.jpg",
                46.9f));
        recommendBusiness.add(new Business("东湖听涛景区",
                "东湖听涛风景区位于东湖西北岸，是东湖风景区中最早建成开放的景区。该景区建有以纪念爱国诗人屈原为主体的景点群，还有新建的沙滩浴场，是夏夜人们纳凉避暑、戏水休憩的好地方。",
                "http://bbsimg1.tuniucdn.com/data/attachment/forum/201403/22/125635nja9rtaeezep9yr7.jpg",
                142.2f));
        recommendBusiness.add(new Business("巨幕影城",
                "巨幕影城（武汉光谷广场资本大厦店）是目前中国最大的影城、华中第一家“中国巨幕”影城。影城面积16873平方米、11个厅、2500座、巨幕、3D、商业街应有尽有。 巨幕影城（武汉光谷广场资本大厦店）是目前中国电影业态最丰富、电影文化最全面、相关产业最配套的电影文化城，巨幕影城（武汉光谷广场资本大厦店）是目前中国档次最高、技术最先进、内涵最丰富的电影文化中心。 ",
                "http://p0.meituan.net/deal/__41683164__4811680.jpg",
                46.9f));
        recommendBusiness.add(new Business("东湖听涛景区",
                "东湖听涛风景区位于东湖西北岸，是东湖风景区中最早建成开放的景区。该景区建有以纪念爱国诗人屈原为主体的景点群，还有新建的沙滩浴场，是夏夜人们纳凉避暑、戏水休憩的好地方。",
                "http://bbsimg1.tuniucdn.com/data/attachment/forum/201403/22/125635nja9rtaeezep9yr7.jpg",
                142.2f));
        recommendBusiness.add(new Business("巨幕影城",
                "巨幕影城（武汉光谷广场资本大厦店）是目前中国最大的影城、华中第一家“中国巨幕”影城。影城面积16873平方米、11个厅、2500座、巨幕、3D、商业街应有尽有。 巨幕影城（武汉光谷广场资本大厦店）是目前中国电影业态最丰富、电影文化最全面、相关产业最配套的电影文化城，巨幕影城（武汉光谷广场资本大厦店）是目前中国档次最高、技术最先进、内涵最丰富的电影文化中心。 ",
                "http://p0.meituan.net/deal/__41683164__4811680.jpg",
                46.9f));
        recommendBusiness.add(new Business("东湖听涛景区",
                "东湖听涛风景区位于东湖西北岸，是东湖风景区中最早建成开放的景区。该景区建有以纪念爱国诗人屈原为主体的景点群，还有新建的沙滩浴场，是夏夜人们纳凉避暑、戏水休憩的好地方。",
                "http://bbsimg1.tuniucdn.com/data/attachment/forum/201403/22/125635nja9rtaeezep9yr7.jpg",
                142.2f));
        recommendBusiness.add(new Business("巨幕影城",
                "巨幕影城（武汉光谷广场资本大厦店）是目前中国最大的影城、华中第一家“中国巨幕”影城。影城面积16873平方米、11个厅、2500座、巨幕、3D、商业街应有尽有。 巨幕影城（武汉光谷广场资本大厦店）是目前中国电影业态最丰富、电影文化最全面、相关产业最配套的电影文化城，巨幕影城（武汉光谷广场资本大厦店）是目前中国档次最高、技术最先进、内涵最丰富的电影文化中心。 ",
                "http://p0.meituan.net/deal/__41683164__4811680.jpg",
                46.9f));
        recommendBusiness.add(new Business("东湖听涛景区",
                "东湖听涛风景区位于东湖西北岸，是东湖风景区中最早建成开放的景区。该景区建有以纪念爱国诗人屈原为主体的景点群，还有新建的沙滩浴场，是夏夜人们纳凉避暑、戏水休憩的好地方。",
                "http://bbsimg1.tuniucdn.com/data/attachment/forum/201403/22/125635nja9rtaeezep9yr7.jpg",
                142.2f));
        recommendBusiness.add(new Business("巨幕影城",
                "巨幕影城（武汉光谷广场资本大厦店）是目前中国最大的影城、华中第一家“中国巨幕”影城。影城面积16873平方米、11个厅、2500座、巨幕、3D、商业街应有尽有。 巨幕影城（武汉光谷广场资本大厦店）是目前中国电影业态最丰富、电影文化最全面、相关产业最配套的电影文化城，巨幕影城（武汉光谷广场资本大厦店）是目前中国档次最高、技术最先进、内涵最丰富的电影文化中心。 ",
                "http://p0.meituan.net/deal/__41683164__4811680.jpg",
                46.9f));
        recommend = (ListView) findViewById(R.id.id_listview_recommend);
        recommendListAdapter = new MyListViewAdapter(this, recommendBusiness);
        recommend.setAdapter(recommendListAdapter);

    }

    public void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_linearlayout_location:
                showToast("正在重新定位...");
                break;
            case R.id.id_search:
                showToast("搜索");
                break;
        }
    }
}
