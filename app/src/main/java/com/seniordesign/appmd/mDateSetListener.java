package com.seniordesign.appmd;

import android.app.DatePickerDialog;
import android.content.ClipboardManager;
import android.widget.DatePicker;

/**
 * Created by Javier Ceballos-Leon on 8/16/2016.
 */


public class mDateSetListener implements DatePickerDialog.OnDateSetListener {
    //@Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth, ClipboardManager v) {
        // TODO Auto-generated method stub
        // getCalender();
        int mYear = year;
        int mMonth = monthOfYear;
        int mDay = dayOfMonth;
        v.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(mMonth + 1).append("/").append(mDay).append("/")
                .append(mYear).append(" "));
        System.out.println(v.getText().toString());


    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}
