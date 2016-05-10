package com.tb.taobaoguang;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.lzyzsd.circleprogress.CircleProgress;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import comm.BaseActivity;
import comm.utils.UiTools;

/**
 * Created by zxh on 2016/4/25.
 */
public class NewsDetailActivity extends BaseActivity {


  private WebView mWeb = null;

  @ViewInject(R.id.circle_progress)
  private CircleProgress mProgress;

  @ViewInject(R.id.lv_discussion)
  private ListView lv_discussion;

  private Toolbar toolbar = null;

  @TargetApi(Build.VERSION_CODES.M)
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_news_detail);
    x.view().inject(this);

    //初始化toolBar
    initToolBar();

    //获取网页的地址
    String url = getIntent().getStringExtra("url");

    if (null == url) {
      UiTools.showToast("加载失败");
      return;
    }


    //初始化webView
    initWebView(url);

    //获取评论列表
    getDiscussion();

    lv_discussion.setAdapter(new ArrayAdapter<String>(this,android.R.layout
            .simple_list_item_1,
            new String[]{"还是社会"}){});

  }

  private void initToolBar() {
    toolbar= (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }

  //获取评论列表
  private void getDiscussion() {

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    //先哦会webView
    if (mWeb != null) {
      mWeb.clearHistory();
      mWeb.clearCache(true);
      mWeb.destroy();
      mWeb = null;
    }
  }

  
  private void initWebView(String url) {

    //初始化 webView
    mWeb = new WebView(this);

    mWeb.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
            AbsListView.LayoutParams
                    .MATCH_PARENT));

    //把webView 添加到最前面
    lv_discussion.addHeaderView(mWeb);
    //设置webView
    WebSettings settings = mWeb.getSettings();
    settings.setJavaScriptEnabled(true);// 表示支持js
    settings.setTextSize(WebSettings.TextSize.NORMAL);

    mWeb.setWebViewClient(new WebViewClient() {

      /**
       * 网页开始加载
       */
      @Override
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        System.out.println("网页开始加载");
        mProgress.setVisibility(View.VISIBLE);
      }

      /**
       * 网页加载结束
       */
      @Override
      public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        System.out.println("网页开始结束");

        mProgress.setVisibility(View.GONE);

      }

      /**
       * 所有跳转的链接都会在此方法中回调
       */
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // tel:110
        System.out.println("跳转url:" + url);
        view.loadUrl(url);

        return true;
      }
    });

    mWeb.setWebChromeClient(new WebChromeClient() {

      /**
       * 进度发生变化
       */
      @Override
      public void onProgressChanged(WebView view, int newProgress) {
        mProgress.setProgress(newProgress);
        super.onProgressChanged(view, newProgress);
      }

      /**
       * 获取网页标题
       */
      @Override
      public void onReceivedTitle(WebView view, String title) {

        toolbar.setTitle(title);

        super.onReceivedTitle(view, title);
      }
    });

    // 加载网页
    mWeb.loadUrl(url);
  }
}
