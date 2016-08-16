package com.seniordesign.appmd;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;
import android.content.Context;
import com.seniordesign.appmd.LoginActivity;

import java.util.Calendar;

/**
 * Created by lindsayherron on 8/4/16.
 */


public class CalendarActivity extends AppCompatActivity {
    CalendarView calendar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendar = (CalendarView) findViewById(R.id.nav_calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub
                Calendar c = Calendar.getInstance();
                //Get Current Date Values for DatePicker
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                //System.out.println("the selected " + mDay);
                DatePickerDialog dialog = new DatePickerDialog(CalendarActivity.this,
                        new mDateSetListener(), mYear, mMonth, mDay);
                dialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    public void calClick(View view){
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");

        Calendar cal = Calendar.getInstance();
        long startTime = cal.getTimeInMillis();
        long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

        intent.putExtra(Events.TITLE, "Neel Birthday");
        intent.putExtra(Events.DESCRIPTION,  "This is a sample description");
        intent.putExtra(Events.EVENT_LOCATION, "My Guest House");
        intent.putExtra(Events.RRULE, "FREQ=YEARLY");

        startActivity(intent);
    }

}
