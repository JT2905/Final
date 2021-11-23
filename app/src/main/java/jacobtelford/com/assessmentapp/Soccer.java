package jacobtelford.com.assessmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Soccer extends AppCompatActivity {

    private int tOneS = 0; //private integers declared and values assigned
    private int tTwoS = 0;
    private int HalfNum = 1;
    private int undo = 0;
    private int Mclock = 2;
    private TextView mShowCountOne; //private TextView components declared and named
    private TextView mShowCountTwo;
    private TextView mHalfNum;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer);
        mShowCountOne = (TextView) findViewById(R.id.t1Score); //assigning the private TextView components a physical textview on the activity screen
        mShowCountTwo = (TextView) findViewById(R.id.t2Score);
        mHalfNum = (TextView) findViewById(R.id.sNum);
        textView = (TextView) findViewById(R.id.text_view);
    }

    //Same as Rugby.java code
    public void timerClick(View view){
        if(Mclock == 0){
            startTimer();
        }
        else if(Mclock == 2){
            startTimer();
        }
    }

    //MAIN COUNTDOWN CODE
    //Same as Rugby.java code
    private void startTimer(){
        long duration = TimeUnit.MINUTES.toMillis(10);

        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                String sDurationM = String.format(Locale.ENGLISH, "%02d:%02d"
                        ,TimeUnit.MILLISECONDS.toMinutes(l)
                        ,TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                textView.setText(sDurationM);
                Mclock = 1;

            }

            @Override
            public void onFinish() {
                if(HalfNum==1) {
                    Toast.makeText(getApplicationContext()
                            , "END OF HALF", Toast.LENGTH_LONG).show();
                    ++HalfNum;
                    if (mHalfNum != null)
                        mHalfNum.setText(Integer.toString(HalfNum));
                    textView.setText("10:00");


                }
                else if(HalfNum==2){
                    Toast.makeText(getApplicationContext()
                            , "END OF GAME", Toast.LENGTH_LONG).show();
                }
                Mclock = 0;
            }

        }.start();
    }

    //SCORING CODE
    //Same as MainActivity.java and Rugby.java codes, but only using 1point score option, no fouls and no timeouts
    public void tOneG(View view){
        tOneS=tOneS+ 1;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
        undo = 11;
        Toast toast = Toast.makeText(this, "GOOOAAALLL", Toast.LENGTH_LONG);
        toast.show();
        //Generate toast that says "GOOOAAALLL"
    }

    public void tTwoG(View view){
        tTwoS=tTwoS+ 1;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
        undo = 21;
        Toast toast = Toast.makeText(this, "GOOOAAALLL", Toast.LENGTH_LONG);
        toast.show();
    }

    //Same as Rugby.java code
    public void halNum(View view){
        if(HalfNum<2){
            ++HalfNum;
            if (mHalfNum != null)
                mHalfNum.setText(Integer.toString(HalfNum));}
        else if(HalfNum==2)
        {
        }
        undo = 5;
    }

    //UNDO BUTTON CODE
    public void Undo(View view){
        if(undo==11&&tOneS>0){
            tOneS=tOneS-1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 11 and "tOneS" is more than 0, decrease "tOneS" by 1 and update "mShowCountOne" text
        }

        if(undo==21&&tTwoS>0){
            tTwoS=tTwoS-1;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 21 and "tTwoS" is more than 0, decrease "tTwoS" by 1 and update "mShowCountTwo" text
        }

        if(undo==5&&HalfNum>1){
            HalfNum=HalfNum-1;
            if (mHalfNum != null)
                mHalfNum.setText(Integer.toString(HalfNum));
        //Same as Rugby.java code
        }
    }

    public void SettingsClick (View view){ //public function "SettingsClick"
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        //moves to Settings activity
    }
}