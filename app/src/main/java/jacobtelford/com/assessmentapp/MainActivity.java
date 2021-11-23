package jacobtelford.com.assessmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private int tOneS = 0; //private integers declared and values assigned
    private int tTwoS = 0;
    private int tOneTO = 3;
    private int tTwoTO = 3;
    private int tOneF = 0;
    private int tTwoF = 0;
    private int PerNum = 1;
    private int undo = 0;
    private int Mclock = 2;
    private int Sclock = 0;
    private TextView mtOneTO; //private TextView components declared and named
    private TextView mtTwoTO;
    private TextView mShowCountOne;
    private TextView mShowCountTwo;
    private TextView mtOneF;
    private TextView mtTwoF;
    private TextView mPerNum;
    private TextView MtextView;
    private TextView StextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCountOne = (TextView) findViewById(R.id.t1Score); //assigning the private TextView components a physical textview on the activity screen
        mShowCountTwo = (TextView) findViewById(R.id.t2Score);
        mtOneTO = (TextView) findViewById(R.id.t1_SW);
        mtTwoTO = (TextView) findViewById(R.id.t2_SW);
        mtOneF = (TextView) findViewById(R.id.t1_GW);
        mtTwoF = (TextView) findViewById(R.id.t2_GW);
        mPerNum = (TextView) findViewById(R.id.sNum);
        MtextView = (TextView) findViewById(R.id.text_view);
        StextView = (TextView) findViewById(R.id.shot);
    }

    public void MtimerClick(View view){ //public function "MtimerClick"
        if(Mclock == 0){
            startMTimer();
            startSHTimer();
            //if the "Mclock" value is 0, execute the "startMTimer" and "startSHTimer" functions
        }
        else if(Mclock == 2){
            startMTimer();
            startSHTimer();
            //if the "Mclock" value is 2, execute the "startMTimer" and "startSHTimer" functions
        }
    }


    //MAIN TIMER CODE
    private void startMTimer(){ //private function "startMTimer"
        long Mduration = TimeUnit.MINUTES.toMillis(10); //declares the duration in minutes

        new CountDownTimer(Mduration, 1000) { //counts down in 1000 milliseconds per second
            @Override
            public void onTick(long l) { //public function "onTick"
                String sDurationM = String.format(Locale.ENGLISH, "%02d:%02d"
                        ,TimeUnit.MILLISECONDS.toMinutes(l)
                        ,TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                //declares sDurationM as a string that displays the time remaining in Minute:Second form (00:00)
                MtextView.setText(sDurationM); //sets "MtextView" to sDurationM
                Mclock = 1; //sets "Mclock" to 1

            }

            @Override
            public void onFinish() { //public function called "onFinish"
                if(PerNum<4) {
                    Toast.makeText(getApplicationContext()
                            , "END OF QUARTER", Toast.LENGTH_LONG).show();
                    ++PerNum;
                    if (mPerNum != null)
                        mPerNum.setText(Integer.toString(PerNum));
                    StextView.setText("24");
                    MtextView.setText("10:00");
                    //if "PerNum" is less than 4, generate a toast that says - "END OF QUARTER", increase "PerNum" by 1, update "PerNum" text, set "StextView" to "24", set "MtextView" to "10:00"


                }
                else if(PerNum==4){
                    Toast.makeText(getApplicationContext()
                            , "END OF GAME", Toast.LENGTH_LONG).show();
                    //if "PerNum" is 4, generate a toast that says - "END OF GAME"
                }
                Mclock = 0; //set "Mclock" to 0
            }

        }.start(); //start the countdown
    }

    public void SHtimerClick(View view){ //public function "SHTimerClick"
        if(Sclock == 0 && Mclock == 1){
            startSHTimer();
        } //if "Sclock" is 0, and "Mclock" is 1, execute the function "startSHTimer"
    }

    //SHOT CLOCK TIMER CODE
    private void startSHTimer(){ //private function called "startSHTimer"
        long SHduration = TimeUnit.SECONDS.toMillis(24); //set the duration of the countdown (SHduration) to 24 seconds

        new CountDownTimer(SHduration, 1000) { //initiate a new countdown using that duration, and countdown in 1000 milliseconds per second
            @Override
            public void onTick(long l) { //public function "onTick"
                StextView.setText("" + l/1000);
                Sclock = 1;
                //set "StextView" to the time remaining (l) divided by 1000 to display seconds instead of millis

            }

            @Override
            public void onFinish() { //public function "onFinish"
                Sclock = 0;
                StextView.setText("24");
                //set "Sclock" to 0 and "StextView" to "24"
            }

        }.start(); //start countdown
    }

    //SCORING CODE
    //All public functions
    public void tOneOne(View view){
        tOneS=tOneS+ 1;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
        undo = 11;
        //increase "tOneS" by 1, update "mShowCountOne" text, set "undo" integer to 11
    }

    public void tTwoOne(View view){
        tTwoS=tTwoS+ 1;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
        undo = 21;
        //increase "tTwoS" by 1, update "mShowCountTwo" text, set "undo" integer to 21
    }

    public void tOneTwo(View view){
        tOneS=tOneS+ 2;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
        undo = 12;
        //increase "tOneS" by 2, update "mShowCountOne" text, set "undo" integer to 12
    }

    public void tTwoTwo(View view){
        tTwoS=tTwoS+ 2;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
        undo = 22;
        //increase "tTwoS" by 2, update "mShowCountTwo" text, set "undo" integer to 22
    }

    public void tOneThree(View view){
        tOneS=tOneS+ 3;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
        undo = 13;
        //increase "tOneS" by 3, update "mShowCountOne" text, set "undo" integer to 13
    }

    public void tTwoThree(View view){
        tTwoS=tTwoS+ 3;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
        undo = 23;
        //increase "tTwoS" by 3, update "mShowCountTwo" text, set "undo" integer to 23
    }

    //TIMEOUT CODE
    public void tOneTOs(View view){
        if(tOneTO>0){
        tOneTO=tOneTO-1;
        //if "tOneTO" is more than 0, decrease "tOneTO" by 1
        if(mtOneTO != null)
            mtOneTO.setText(Integer.toString((tOneTO)));}
        //update "tOneTO text
        else if(tOneTO==0)
        {
        }
        //if "tOneTO" is 0,do nothing
        undo = 10;
        //set "undo" to 10
    }

    //same as above but replace every "One" with "Two" as this is code for Team 2, not Team 1
    public void tTwoTOs(View view){
        if(tTwoTO>0){
        tTwoTO=tTwoTO-1;
        if (mtTwoTO != null)
            mtTwoTO.setText(Integer.toString(tTwoTO));}
        else if(tTwoTO==0)
        {
        }
        undo = 20;
        //set "undo" to 20
    }

    //FOULS CODE
    public void tOneFs(View view){
        ++tOneF;
        if(mtOneF != null)
            mtOneF.setText(Integer.toString((tOneF)));
        undo = 1;
        //increase "tOneF" by 1, update "mtOneF" text and set "undo" to 1
    }

    public void tTwoFs(View view){
        ++tTwoF;
        if (mtTwoF != null)
            mtTwoF.setText(Integer.toString(tTwoF));
        undo = 2;
        //increase "tTwoF" by 1, update "mtTwoF" text and set "undo" to 2
    }

    //PERIOD CODE
    public void perNum(View view){
        if(PerNum<4){
        ++PerNum;
        if (mPerNum != null)
            mPerNum.setText(Integer.toString(PerNum));}
        //if "PerNum" is less than 4, increase "PerNum" and update "mPerNum" text
        else if(PerNum==4)
        {
        }
        //if "perNum" is 4, do nothing
        undo = 5;
        //set "undo" to 5
    }

    //UNDO BUTTON CODE
    public void Undo(View view){
        if(undo==11&&tOneS>0){
            tOneS=tOneS-1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 11 and "tOneS" is more than 0, decrease "tOneS" by 1, update "mShowCountOne" text
        }
        if(undo==12&&tOneS>1){
            tOneS=tOneS-2;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 12 and "tOneS" is more than 1, decrease "tOneS" by 2, update "mShowCountOne" text
        }
        if(undo==13&&tOneS>2){
            tOneS=tOneS-3;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 13 and "tOneS" is more than 2, decrease "tOneS" by 3, update "mShowCountOne" text
        }
        if(undo==21&&tTwoS>0){
            tTwoS=tTwoS-1;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 11 and "tTwoS" is more than 0, decrease "tTwoS" by 1, update "mShowCountTwo" text
        }
        if(undo==22&&tTwoS>1){
            tTwoS=tTwoS-2;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 12 and "tTwoS" is more than 1, decrease "tTwoS" by 2, update "mShowCountTwo" text
        }
        if(undo==23&&tTwoS>2){
            tTwoS=tTwoS-3;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 13 and "tTwoS" is more than 2, decrease "tTwoS" by 3, update "mShowCountTwo" text
        }
        if(undo==10&&tOneTO<3){
            tOneTO=tOneTO+1;
            if(mtOneTO != null)
                mtOneTO.setText(Integer.toString((tOneTO)));
        //if "undo" is 10 and "tOneTO" is less than 3, increase "tOneTO" by 1 and update "mtOneTO" text
        }
        if(undo==20&&tTwoTO<3){
            tTwoTO=tTwoTO+1;
            if(mtTwoTO != null)
                mtTwoTO.setText(Integer.toString((tTwoTO)));
        //if "undo" is 20 and "tTwoTO" is less than 3, increase "tTwoTO" by 1 and update "mtTwoTO" text
        }
        if(undo==1&&tOneF>0){
            tOneF=tOneF-1;
            if(mtOneF != null)
                mtOneF.setText(Integer.toString((tOneF)));
        //if "undo" is 1 and "tOneF" is more than 0, decrease "tOneF" by 1, update "mtOneF" text
        }
        if(undo==2&&tTwoF>0){
            tTwoF=tTwoF-1;
            if(mtTwoF != null)
                mtTwoF.setText(Integer.toString((tTwoF)));
        //if "undo" is 2 and "tTwoF" is more than 0, decrease "tTwoF" by 1, update "mtTwoF" text
        }
        if(undo==5&&PerNum>1){
            PerNum=PerNum-1;
            if (mPerNum != null)
                mPerNum.setText(Integer.toString(PerNum));
        //if "undo" is 5 and "PerNum" is more than 1, decrease "PerNum" by 1, update "mPerNum" text
        }
    }

    public void SettingsClick (View view){ //public function "SettingsClick"
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        //moves to Settings activity
    }
}