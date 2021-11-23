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

public class Rugby extends AppCompatActivity {

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
        setContentView(R.layout.activity_rugby);
        mShowCountOne = (TextView) findViewById(R.id.t1Score); //assigning the private TextView components a physical textview on the activity screen
        mShowCountTwo = (TextView) findViewById(R.id.t2Score);
        mHalfNum = (TextView) findViewById(R.id.sNum);
        textView = (TextView) findViewById(R.id.text_view);
    }

    public void timerClick(View view){ //public "timerClick" function
        if(Mclock == 0){
            startTimer();
            // if "Mclock" is 0, execute "startTimer" function
        }
        else if(Mclock == 2){
            startTimer();
            // if "Mclock" is 2, execute "startTimer" function
        }
    }

    //MAIN COUNTDOWN CODE
    //Same as MainActivity.java code with the exception of the Shot Clock code, aswell as slight renaming of functions
    //Same as Soccer.java code
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

            //Rugby is in 2 halves instead of 4 quarters, unlike Basketball in MainActivity
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
    //Same as MainActivity code but replace the 3point score with a 4point score, and exclude Fouls and Timeouts code
    public void tOneOne(View view){
        tOneS=tOneS+ 1;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
        undo = 11;
    }

    public void tTwoOne(View view){
        tTwoS=tTwoS+ 1;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
        undo = 21;
    }

    public void tOneTwo(View view){
        tOneS=tOneS+ 2;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
        undo = 12;
    }

    public void tTwoTwo(View view){
        tTwoS=tTwoS+ 2;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
        undo = 22;
    }

    public void tOneFour(View view){
        tOneS=tOneS+ 4;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
        undo = 14;
    }

    public void tTwoFour(View view){
        tTwoS=tTwoS+ 4;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
        undo = 24;
    }

    public void halNum(View view){
        if(HalfNum<2){
            ++HalfNum;
            if (mHalfNum != null)
                mHalfNum.setText(Integer.toString(HalfNum));}
        //if "HalfNum" is less than 2, increase "HalfNum" by 1 and update "mHalfNum" text
        else if(HalfNum==2)
        {
        }
        //if "HalfNum" is 2, do nothing
        undo = 5;
        //set "undo" to 5
    }

    //UNDO BUTTON CODE
    public void Undo(View view){
        if(undo==11&&tOneS>0){
            tOneS=tOneS-1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 11 and "tOneS" is more than 0, decrease "tOneS" by 1 and update "mShowCountOne" text
        }
        if(undo==12&&tOneS>1){
            tOneS=tOneS-2;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 12 and "tOneS" is more than 1, decrease "tOneS" by 2 and update "mShowCountOne" text
        }
        if(undo==14&&tOneS>3){
            tOneS=tOneS-4;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 14 and "tOneS" is more than 3, decrease "tOneS" by 4 and update "mShowCountOne" text
        }
        if(undo==21&&tTwoS>0){
            tTwoS=tTwoS-1;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 21 and "tTwoS" is more than 0, decrease "tTwoS" by 1 and update "mShowCountTwo" text
        }
        if(undo==22&&tTwoS>1){
            tTwoS=tTwoS-2;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 22 and "tTwoS" is more than 1, decrease "tTwoS" by 2 and update "mShowCountTwo" text
        }
        if(undo==24&&tTwoS>3){
            tTwoS=tTwoS-4;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 24 and "tTwoS" is more than 3, decrease "tTwoS" by 4 and update "mShowCountTwo" text
        }

        if(undo==5&&HalfNum>1){
            HalfNum=HalfNum-1;
            if (mHalfNum != null)
                mHalfNum.setText(Integer.toString(HalfNum));
        //if "undo" is 5 and "HalfNum" is more than 1, decrease "HalfNum" by 1, update "mHalfNum" text
        }
    }

    public void SettingsClick (View view) { //public function "SettingsClick"
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        //moves to Settings activity
    }
}