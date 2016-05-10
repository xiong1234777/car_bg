package com.tb.taobaoguang;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.tb.taobaoguang.fragment.NewsItemFrag;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import comm.ActivityCollector;
import comm.BaseActivity;
import comm.utils.XutilsHelper;
import comm.view.TabView;

public class MainActivity extends BaseActivity {

  private DrawerLayout mDrawerLayout = null;
  private ImageView iv_book_image = null;
  @ViewInject(R.id.tab_view)
  private TabView m_tab_view;

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    x.view().inject(this);
    //设置 toolbar
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    //设置 DrawerLayout
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


    //开关
    ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
            R.string.drawer_open, R.string.drawer_close);

    mDrawerToggle.syncState();

    //添加开关事件
    mDrawerLayout.addDrawerListener(mDrawerToggle);

    //设置NavigationView点击事件
    NavigationView  mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
    setupDrawerContent(mNavigationView);


    List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    String [] type_names = XutilsHelper.getResArr(R.array.news_type_name);
    String [] types = XutilsHelper.getResArr(R.array.news_type);

    for (int i = 0; i <type_names.length ; i++) {
      titles.add(type_names[i]);
    }

    for (int i = 0; i <types.length ; i++) {
      fragments.add(NewsItemFrag.insatnce(types[i]));
    }

    //设置tab
    m_tab_view.setTandC(titles,fragments,getSupportFragmentManager(), TabLayout.MODE_SCROLLABLE);

  }
  
  private void setupDrawerContent(NavigationView mNavigationView) {
  
    mNavigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                  case R.id.navigation_item_example:
                    switchToExample();
                    break;
                  case R.id.navigation_item_blog:
                    switchToBlog();
                    break;
                  case R.id.navigation_item_about:
                    switchToAbout();
                    break;
                
                }
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
              }
            });
  }
  
  private void switchToAbout() {
  }
  
  private void switchToBlog() {
  }
  
  
  private void switchToExample() {
    
  }
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.action_settings) {
      ActivityCollector.finshAll();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
