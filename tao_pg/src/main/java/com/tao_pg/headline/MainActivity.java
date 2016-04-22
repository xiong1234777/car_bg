package com.tao_pg.headline;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private DrawerLayout mDrawerLayout = null;
  private ImageView iv_book_image = null;

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //设置 toolbar
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //设置 DrawerLayout
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

    iv_book_image = (ImageView) findViewById(R.id.iv_book_image);
    iv_book_image.setImageResource(R.drawable.ic_launcher);

    //开关
    ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
            R.string.drawer_open, R.string.drawer_close);

    mDrawerToggle.syncState();

    //添加开关事件
    mDrawerLayout.addDrawerListener(mDrawerToggle);

    //设置NavigationView点击事件
    NavigationView  mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
    setupDrawerContent(mNavigationView);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"你好",Toast.LENGTH_LONG).show();
                  }
                }).show();
      }
    });
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
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
