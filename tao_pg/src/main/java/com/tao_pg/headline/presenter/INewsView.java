package com.tao_pg.headline.presenter;

import java.util.List;

/**
 * Created by SX on 2016/4/23.
 */
public interface INewsView {
  void onFail();
  void onSuccess(List datas);
}
