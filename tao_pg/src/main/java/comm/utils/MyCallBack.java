package comm.utils;


import org.xutils.common.Callback;

/**
 * Created by xiaohu on 2016/3/26.
 * 我的回调接口
 */
public  class MyCallBack<T> implements Callback.ProgressCallback<T>{


    @Override
    public void onWaiting() {

    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onLoading(long total, long current, boolean isDownloading) {

    }

    @Override
    public void onSuccess(T result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        UiTools.showToast(ex.getMessage());
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
