package valeri.com.drawingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeri on 15-1-31.
 */
public class DrawingView extends View {


    public List<Point> point = new ArrayList<>();
    Paint paint = new Paint();



    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        canvas.drawPath(path,paint);


    }

    Path path = new Path();
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

               // point.clear();
                //path = new Path();
                path.moveTo(event.getX(), event.getY());

                break;
            case MotionEvent.ACTION_MOVE:
                Point screenLocation = new Point();

                screenLocation.x = (int) event.getX();
                screenLocation.y = (int) event.getY();
                path.lineTo(screenLocation.x, screenLocation.y);
                point.add(screenLocation);
                invalidate();

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return true;
    }
}
