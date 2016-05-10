package com.tb.taobaoguang.global;

/**
 * Created by zxh on 2016/5/9.
 */
public class UrlHelper {


  //访问的接口的地址
  private final static String NET_HOST="http://www.taobpg.com/newsinterface/";

  //返回新闻条目的的接口
  public final static String getNewsItemsUrl(String account,String pwd,String type,int pn){

    StringBuilder  sb = new StringBuilder();

    sb.append(NET_HOST);
    sb.append("sharenewslist");
    sb.append("?account=").append(account);
    sb.append("&pwd=").append(pwd);
    sb.append("&type=").append(type);
    sb.append("&pn=").append(pn + "");


    return sb.toString();
  }


  public final static String getNesDiscussionUrl(String account,String pwd,String newsid,int pn){
    StringBuilder  sb = new StringBuilder();

    sb.append(NET_HOST);
    sb.append("sharenewslist");
    sb.append("?account=").append(account);
    sb.append("&pwd=").append(pwd);
    sb.append("&id=").append(newsid);
    sb.append("&pn=").append(pn + "");


    return sb.toString();
  }


// public static


}
