package comm;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {

  protected void onCreate(Bundle arg0) {
    super.onCreate(arg0);
    ActivityCollector.addActivity(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    ActivityCollector.removeActivity(this);
  }
  @Override
  protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
  }
  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
  }
  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // TODO Auto-generated method stub
    super.onSaveInstanceState(outState);
  }
}
