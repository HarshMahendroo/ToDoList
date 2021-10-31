package com.example.mycrudoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class ActivityReminder extends AppCompatActivity {
TimePicker timepicker;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        timepicker=(TimePicker)findViewById(R.id.timePicker);
        //Uncomment the below line of code for 24 hour view
        timepicker.setIs24HourView(true);
        btn=findViewById(R.id.buttonalarm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour=Integer.parseInt(timepicker.getCurrentHour().toString());
                int min=Integer.parseInt(timepicker.getCurrentMinute().toString());
                Intent i =new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_HOUR,hour);
                i.putExtra(AlarmClock.EXTRA_MINUTES,min);
                i.putExtra(AlarmClock.EXTRA_MESSAGE,"ToDoList");
                startActivity(i);
            }
        });
    }
}