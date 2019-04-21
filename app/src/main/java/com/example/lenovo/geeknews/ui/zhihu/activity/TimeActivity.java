package com.example.lenovo.geeknews.ui.zhihu.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.geeknews.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeActivity extends AppCompatActivity {

    @BindView(R.id.msv)
    MaterialCalendarView msv;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    private String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ButterKnife.bind(this);

        msv.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Date dateDate = date.getDate();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
                format = sdf.format(dateDate);
            }
        });

        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Integer.parseInt(format)>=20190419){
                    finish();
                }else {
                    EventBus.getDefault().post(format);
                    finish();
                }

            }
        });
    }
}
