package comm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.cjj.Util;
import com.tb.taobaoguang.R;

/**
 * Created by zxh on 2016/5/10.
 */
public class MyWare extends View {

  private Paint mPaint;

  public MyWare(Context context) {
    super(context);
    initView(context);
  }

  public MyWare(Context context, AttributeSet attrs) {
    super(context, attrs);
    initView(context);
  }

  public MyWare(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initView(context);
  }


  private void initView(Context context) {
    if (mPaint == null) {
      mPaint = new Paint();
    }

    mPaint.setColor(context.getResources().getColor(R.color.b_green));

    mPaint.setAntiAlias(true);

    mPaint.setStyle(Paint.Style.STROKE);

    mPaint.setStrokeWidth(Util.px2dip(context,48));

  }

  //重写


  @Override
  protected void onDraw(Canvas canvas) {
//    super.onDraw(canvas);

    //获取屏幕的宽高 然后 将圆放在中心

    //画圆
    canvas.drawCircle(100,100, 50, mPaint);
  }
}
