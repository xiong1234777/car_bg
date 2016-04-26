package com.tao_pg.headline.presenter;

import android.text.TextUtils;
import android.util.ArrayMap;

import com.google.gson.reflect.TypeToken;
import com.tao_pg.headline.bean.NewsInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;

import java.util.List;
import java.util.Map;

import comm.BaseP;
import comm.utils.DataTools;
import comm.utils.MyCallBack;
import comm.utils.UiTools;
import comm.utils.XutilsHelper;

/**
 * Created by SX on 2016/4/23.
 */
public class NewsPresenter extends BaseP<INewsView> {
  StringBuilder m_sb_tpg_host = null;
  //请求参数
  Map<String, String> m_mapParam = null;
  List<NewsInfo> m_news_info_list = null;

  
  public void fetchNews(String type, int pn) {
    
    if (m_mapParam == null) {
      
      m_mapParam = new ArrayMap<>();
      m_mapParam.clear();
      
    }


    m_sb_tpg_host = new StringBuilder("http://www.taobpg.com/newsinterface/");


//    //设置请求参数
    m_sb_tpg_host.append("sharenewslist").
            append("?account=").append("taobpg").append("&type=").append(type).
            append("&pwd=").append("123").
            append("&pn=").append(pn + "");


    LogUtil.e(m_sb_tpg_host.toString());

    XutilsHelper.fetch(new RequestParams(m_sb_tpg_host.toString()), 0, new MyCallBack<String>() {
      
      @Override
      public void onSuccess(String result) {

        super.onSuccess(result);

        if (TextUtils.isEmpty(result)) {
          return;
        }
        
        try {
          JSONObject obj = new JSONObject(result);
          int status = obj.getInt("status");
          
          if (status == 1) {
            JSONArray array = obj.getJSONArray("list");

            if (m_news_info_list != null) {
              m_news_info_list.clear();
            }

            m_news_info_list = DataTools.getGosn().fromJson(array.toString(), new
                    TypeToken<List<NewsInfo>>() {
                    }.getType());
            
            if (isAttached()) {
              getView().onSuccess(m_news_info_list);
            }


          } else {
            if (status == 0) {
              UiTools.showToast("已经加载到底");

            } else {
              UiTools.showToast("错误码:" + status);
            }
            if (isAttached()) {
              getView().onFail();
            }
          }
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onError(Throwable ex, boolean isOnCallback) {
        super.onError(ex, isOnCallback);
        if (isAttached()) {
          getView().onFail();
        }
      }
    });
  }
}
