package com.example.sensorhello;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.widget.RelativeLayout;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView xText, yText, zText, statusText;
    //RelativeLayout currentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        //currentLayout = findViewById(R.id.activity_accelerometer);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(this, mAccelerometer,mSensorManager.SENSOR_DELAY_NORMAL);
        xText = (TextView)findViewById(R.id.x);
        yText = (TextView)findViewById(R.id.y);
        zText = (TextView)findViewById(R.id.z);
        statusText = (TextView)findViewById(R.id.status);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        if(event.values[1] >= 9){
            statusText.setText("Down!");
            //statusText.setTextColor(Color.RED);
            //currentLayout.setBackgroundColor(Color.RED);
        } else if(event.values[1] > 4 && event.values[1] < 8){
            statusText.setText("AWESOME");
            //status.setTextColor(Color.GREEN);
            //currentLayout.setBackgroundColor(Color.GREEN);
        } else if(event.values[1] < 3){
            statusText.setText("Up!");
            //statusText.setTextColor(Color.RED);
            //currentLayout.setBackgroundColor(Color.RED);
        }

    }

}