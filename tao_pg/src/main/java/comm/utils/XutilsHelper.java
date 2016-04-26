package comm.utils;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiaohu on 2016/3/26.
 */
public class XutilsHelper {

  //请求参数信息

  //doget请求
  public static void fetch(RequestParams params, int type, final MyCallBack
          callBack) {
    if (type == 0) {
      //get
      x.http().get(params, callBack);
      
    } else if (type == 1) {
      //post
      x.http().post(params, callBack);
    }
    
  }
  
  //dopost
  
  
  public static String getResStr(int strid) {
    return x.app().getString(strid);
  }

  public static String[] getResArr(int arr_id) {
    return x.app().getApplicationContext().getResources().getStringArray(arr_id);
  }
}
