package com.spherebox.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.BLACK);
        getWindow().setNavigationBarColor(Color.BLACK);

        setContentView(new SphereView());
    }

    class SphereView extends View {

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        SphereView() {
            super(MainActivity.this);
            setBackgroundColor(Color.BLACK);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            float cx = getWidth() / 2f;
            float cy = getHeight() / 2f;
            float r = Math.min(getWidth(), getHeight()) * 0.25f;

            // White sphere
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(cx, cy, r, paint);

            // Three colored circles
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);

            paint.setColor(Color.RED);
            canvas.drawOval(
                cx - r, cy - r * 0.35f,
                cx + r, cy + r * 0.35f,
                paint
            );

            paint.setColor(Color.GREEN);
            canvas.save();
            canvas.rotate(60, cx, cy);
            canvas.drawOval(
                cx - r, cy - r * 0.35f,
                cx + r, cy + r * 0.35f,
                paint
            );
            canvas.restore();

            paint.setColor(Color.MAGENTA);
            canvas.save();
            canvas.rotate(-60, cx, cy);
            canvas.drawOval(
                cx - r, cy - r * 0.35f,
                cx + r, cy + r * 0.35f,
                paint
            );
            canvas.restore();

            // Yellow box
            paint.setColor(Color.YELLOW);
            paint.setStrokeWidth(3);

            float box = r * 1.15f;

            canvas.drawRect(
                cx - box,
                cy - box,
                cx + box,
                cy + box,
                paint
            );
        }
    }
}
