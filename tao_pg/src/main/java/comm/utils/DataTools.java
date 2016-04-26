package comm.utils;

import com.google.gson.Gson;

/**
 * Created by SX on 2016/4/23.
 */
public class DataTools {

  public static class DataToolsHolder{
    public static final Gson mGosn = new Gson();
  }

  public static Gson getGosn(){
    return DataToolsHolder.mGosn;
  }
}
