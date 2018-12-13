package fr.wildcodeschool.liftsimulator;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int DELAY = 3000;
    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button floor0 = findViewById(R.id.button_0);
        floor0.setOnClickListener(this);
        Button floor1 = findViewById(R.id.button_1);
        floor1.setOnClickListener(this);
        Button floor2 = findViewById(R.id.button_2);
        floor2.setOnClickListener(this);
        Button floor3 = findViewById(R.id.button_3);
        floor3.setOnClickListener(this);
        Button floor4 = findViewById(R.id.button_4);
        floor4.setOnClickListener(this);
        Button floor5 = findViewById(R.id.button_5);
        floor5.setOnClickListener(this);
        Button floor6 = findViewById(R.id.button_6);
        floor6.setOnClickListener(this);
        Button floor7 = findViewById(R.id.button_7);
        floor7.setOnClickListener(this);
        Button floor8 = findViewById(R.id.button_8);
        floor8.setOnClickListener(this);
        Button floor9 = findViewById(R.id.button_9);
        floor9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button_0:
                goToFloor(0);
                break;
            case R.id.button_1:
                goToFloor(1);
                break;
            case R.id.button_2:
                goToFloor(2);
                break;
            case R.id.button_3:
                goToFloor(3);
                break;
            case R.id.button_4:
                goToFloor(4);
                break;
            case R.id.button_5:
                goToFloor(5);
                break;
            case R.id.button_6:
                goToFloor(6);
                break;
            case R.id.button_7:
                goToFloor(7);
                break;
            case R.id.button_8:
                goToFloor(8);
                break;
            case R.id.button_9:
                goToFloor(9);
                break;
        }
    }

    private void goToFloor(Integer floor){
        if(!isLiftMoving && floor != currentFloor){
            moveNextFloor(floor);
        }
    }

    private void moveNextFloor (Integer floor){
        if(floor != currentFloor){
            isLiftMoving = true;
            new MoveLift().execute(floor);
        }
    }


    class MoveLift extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground(Integer... floors) {
            SystemClock.sleep(DELAY);
            isLiftMoving = false;
            return floors[0];
        }

        @Override
        protected void onPostExecute(Integer floor) {

            currentFloor = (floor > currentFloor) ? currentFloor +1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            moveNextFloor(floor);
        }
    }
}