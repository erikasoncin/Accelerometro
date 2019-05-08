package com.example.its_d6;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class Acc2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc2);
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //
        // final ProgressBar barX =(ProgressBar) findViewById(R.id.BarX);
        final ProgressBar barX = (ProgressBar) findViewById(R.id.BarX);
        final ProgressBar barY =(ProgressBar) findViewById(R.id.BarY);
        final ProgressBar barZ =(ProgressBar) findViewById(R.id.BarZ);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.i("ACC", " "
                        +"X: "+event.values[0]
                        +"Y: "+event.values[1]
                        +"Z: "+event.values[2]);// array con 3 valori
                //coordinare accelometro

                int x = Math.abs(Math.round(event.values[0]*500)+5000);
                Log.i("X ", x+" "+barX);
                barX.setProgress(x); //  vedere che intervallo di valore restituisce

                int y = Math.abs(Math.round(event.values[1]*500)+5000);
                barY.setProgress(y);

                int z = Math.abs(Math.round(event.values[2]*500)+5000);
                barZ.setProgress(z);

                Log.i("ACC-IN ", x+"\t"+y+"\t"+z);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener(sensorEventListener, sensor, sensorManager.SENSOR_DELAY_NORMAL);




    }
}
