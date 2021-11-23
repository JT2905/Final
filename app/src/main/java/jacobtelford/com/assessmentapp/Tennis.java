package jacobtelford.com.assessmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tennis extends AppCompatActivity {

    private int tOneS = 0; //private integers declared and values assigned
    private int tTwoS = 0;
    private int fif = 15;
    private int thi = 30;
    private int fou = 40;
    private int tOneSet = 0;
    private int tOneGame = 0;
    private int tTwoSet = 0;
    private int tTwoGame = 0;
    private int setNum = 1;
    private int gameNum = 1;
    private int undo =1;
    private TextView mShowCountOne; //private TextView components declared and named
    private TextView mShowCountTwo;
    private TextView mSetNum;
    private TextView mGameNum;
    private TextView mtOneSetNum;
    private TextView mtTwoSetNum;
    private TextView mtOneGameNum;
    private TextView mtTwoGameNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis);
        mShowCountOne = (TextView) findViewById(R.id.t1Score); //assigning the private TextView components a physical textview on the activity screen
        mShowCountTwo = (TextView) findViewById(R.id.t2Score);
        mSetNum = (TextView) findViewById(R.id.sNum);
        mGameNum = (TextView) findViewById(R.id.gNum);
        mtOneSetNum = (TextView) findViewById(R.id.t1_SW);
        mtTwoSetNum = (TextView) findViewById(R.id.t2_SW);
        mtOneGameNum = (TextView) findViewById(R.id.t1_GW);
        mtTwoGameNum = (TextView) findViewById(R.id.t2_GW);

    }

    //SCORING CODE
    //Accounts for each combination of points in tennis including 15,30,40 scoring and Advantage situations
    //TEAM 1
    public void tOneP(View view){
        if(tOneS==3&&tTwoS<3){
            tOneS=0;
            tTwoS=0;
            ++tOneGame;
            ++gameNum;
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tOneGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            //if "tOneS" is 3 and "tTwoS" is less than 3, set "tOneS" and "tTwoS" to 0, increase "tOneGame" and "gameNum" by 1, update related TextViews
            undo = 111;
            //set "undo" to 111
        }
        else if(tOneS==3&&tTwoS==3){
            ++tOneS;
            if (mShowCountOne != null)
                mShowCountOne.setText("Adv.");
            //if "tOneS" and "tTwoS" are 3, increase "tOneS" by 1 and update "mShowCountOne" to display "Adv."
            undo = 1010;
            //set "undo" to 1010

        }
        else if(tOneS==3&&tTwoS==4){
            tTwoS=3;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(fou));
            //if "tOneS" is 3 and "tTwoS" is 4, set "tTwoS" to 3 and update "mShowCountTwo" text
            undo = 151;
            //set "undo" to 151

        }
        else if(tOneS==4){
            tOneS=0;
            tTwoS=0;
            ++gameNum;
            ++tOneGame;
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tOneGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            //if "tOneS" is 4, set "tOneS" and "tTwoS" to 0 and update all related TextViews
            undo = 111;
            //set "undo" to 111

        }
        else if(tOneS==0) {
            tOneS = tOneS + 1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(fif));
            //if "tOneS" is 0, increase "tOneS" by 1 and update "mShowCountOne" text
            undo = 1;
            //set "undo" to 1
        }

        else if(tOneS==1) {
            tOneS = tOneS + 1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(thi));
            //if "tOneS" is 1, increase "tOneS" by 1 and update "mShowCountOne" text
            undo = 1;
            //set "undo" to 1
        }

        else if(tOneS==2) {
            tOneS = tOneS + 1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(fou));
            //if "tOneS" is 2, increase "tOneS" by 1 and update "mShowCountOne" text
            undo = 1;
            //set "undo" to 1
        }

        if(tOneGame>=6&&(tOneGame-tTwoGame)>=2){
            tOneGame = 0;
            tTwoGame = 0;
            ++tOneSet;
            ++setNum;
            gameNum = 1;
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tOneGame));
            if (mtTwoGameNum != null)
                mtTwoGameNum.setText(Integer.toString(tTwoGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mtOneSetNum != null)
                mtOneSetNum.setText(Integer.toString(tOneSet));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            if (mSetNum != null)
                mSetNum.setText(Integer.toString(setNum));
            //if "tOneGame" is more than or equal to 6, and the difference between "tOneGame" and "tTwoGame" is more than or equal to 2,
            //increase "tOneSet" by 1, increase "setNum" by 1, set "gameNum" to 1 and update all related TextViews
            undo = 100;
            //set "undo" to 100

        }
    }

    //TEAM 2
    public void tTwoP(View view){
        if(tTwoS==3&&tOneS<3){
            tTwoS=0;
            tOneS=0;
            ++tTwoGame;
            ++gameNum;
            if (mtTwoGameNum != null)
                mtTwoGameNum.setText(Integer.toString(tTwoGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            //if "tTwoS" is 3 and "tOneS" is less than 3, set "tTwoS" and "tOneS" to 0, increase "tTwoGame" and "gameNum" by 1 and update all related TextViews
            undo = 222;
            //set "undo" to 222

        }
        else if(tTwoS==3&&tOneS==3){
            ++tTwoS;
            if (mShowCountTwo != null)
                mShowCountTwo.setText("Adv.");
            //if "tTwoS" and "tOneS" are 3, increase "tTwoS" and update "mShowCountTwo" to display "Adv."
            undo = 2020;
            //set "undo" to 2020
        }
        else if(tTwoS==3&&tOneS==4){
            tOneS=3;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(fou));
            //if "tTwoS" is 3 and "tOneS" is 4, set "tOneS" to 3 and update "mShowCountOne" text
            undo = 252;
            //set "undo" to 252
        }
        else if(tTwoS==4){
            tTwoS=0;
            tOneS=0;
            ++gameNum;
            ++tTwoGame;
            if (mtTwoGameNum != null)
                mtTwoGameNum.setText(Integer.toString(tTwoGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            //if "tTwoS" is 4, set "tTwoS" and "tOneS" to 0, increase "gameNum" and "tTwoGame" by 1 and update all related TextViews
            undo = 222;
            //set "undo" to 222
        }
        else if(tTwoS==0) {
            tTwoS = tTwoS + 1;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(fif));
            //if "tTwoS" is 0, increase "tTwoS" by 1 and update "mShowCountTwo" text
            undo = 2;
            //set "undo" to 2
        }

        else if(tTwoS==1) {
            tTwoS = tTwoS + 1;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(thi));
            //if "tTwoS" is 1, increase "tTwoS" by 1 and update "mShowCountTwo" text
            undo = 2;
            //set "undo" to 2
        }

        else if(tTwoS==2) {
            tTwoS = tTwoS + 1;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(fou));
            //if "tTwoS" is 2, increase "tTwoS" by 1 and update "mShowCountTwo" text
            undo = 2;
            //set "undo" to 2
        }

        if(tTwoGame>=6&&(tTwoGame-tOneGame)>=2){
            tOneGame = 0;
            tTwoGame = 0;
            ++tTwoSet;
            ++setNum;
            gameNum = 1;
            if (mtTwoGameNum != null)
                mtTwoGameNum.setText(Integer.toString(tTwoGame));
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tOneGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mtTwoSetNum != null)
                mtTwoSetNum.setText(Integer.toString(tTwoSet));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            if (mSetNum != null)
                mSetNum.setText(Integer.toString(setNum));
            //if "tTwoGame" is more than or equal to 6, and the difference between "tTwoGame" and "tOe=neGame" is more than or equal to 2,
            //increase "tTwoSet" by 1, increase "setNum" by 1, set "gameNum" to 1 and update all related TextViews
            undo = 200;
            //set "undo" to 200
        }
    }

    //UNDO BUTTON CODE
    public void Undo(View view){
        if(undo == 111&&gameNum>1&&tOneGame>=1){
            gameNum = gameNum -1;
            tOneGame = tOneGame -1;
            tOneS = 0;
            tTwoS = 0;
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tOneGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 111 and "gameNum" is more than 1 and "tOneGame" is more than or equal to 1,
        //decrease "gameNum" and "tOneGame" by 1, set "tOneS" and "tTwoS" to 0, update TextViews
        }

        if(undo == 222&&gameNum>1&&tTwoGame>=1){
            gameNum = gameNum -1;
            tTwoGame = tTwoGame -1;
            tOneS = 0;
            tTwoS = 0;
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tTwoGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 222 and "gameNum" is more than 1 and "tTwoGame" is more than or equal to 1,
        //decrease "gameNum" and "tTwoGame" by 1, set "tOneS" and "tTwoS" to 0, update TextViews
        }

        if(undo==1&&tOneS>0){
            tOneS = tOneS -1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
        //if "undo" is 1 and "tOneS" is more than 0,
        // decrease "tOneS" by 1, update "mShowCountOne" TextView
        }

        if(undo==2&&tTwoS>0){
            tTwoS = tTwoS -1;
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
        //if "undo" is 2 and "tTwoS" is more than 0,
        // decrease "tTwoS" by 1, update "mShowCountTwo" TextView
        }

        if(undo==100&&tOneSet>0&&setNum>0){
            tOneSet = tOneSet -1;
            setNum = setNum -1;
            gameNum = 1;
            tOneS = 0;
            tTwoS = 0;
            tOneGame = 0;
            tTwoGame = 0;
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tOneGame));
            if (mtTwoGameNum != null)
                mtTwoGameNum.setText(Integer.toString(tTwoGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mtOneSetNum != null)
                mtOneSetNum.setText(Integer.toString(tOneSet));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            if (mSetNum != null)
                mSetNum.setText(Integer.toString(setNum));
        //if "undo" is 100 and "tOneSet" and "setNum" are more than 0,
        //decrease "tOneSet" and "setNum" by 1, set "gameNum" to 1, set "tOneS" "tTwoS" "tOneGame" and "tTwoGame" to 0, update TextViews
        }

        if(undo==200&&tTwoSet>0&&setNum>0){
            tTwoSet = tTwoSet -1;
            setNum = setNum -1;
            gameNum = 1;
            tOneS = 0;
            tTwoS = 0;
            tOneGame = 0;
            tTwoGame = 0;
            if (mtOneGameNum != null)
                mtOneGameNum.setText(Integer.toString(tOneGame));
            if (mtTwoGameNum != null)
                mtTwoGameNum.setText(Integer.toString(tTwoGame));
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(tOneS));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(tTwoS));
            if (mtTwoSetNum != null)
                mtTwoSetNum.setText(Integer.toString(tTwoSet));
            if (mGameNum != null)
                mGameNum.setText(Integer.toString(gameNum));
            if (mSetNum != null)
                mSetNum.setText(Integer.toString(setNum));
        //if "undo" is 200 and "tTwoSet" and "setNum" are more than 0,
        //decrease "tTwoSet" and "setNum" by 1, set "gameNum" to 1, set "tOneS" "tTwoS" "tOneGame" and "tTwoGame" to 0, update TextViews
        }

        if(undo==151){
            tOneS = 3;
            tTwoS = 3;
            undo = 1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(fou));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(fou));
        //if "undo" is 151, set "tOneS" and "tTwoS" to 3, set "undo" to 1 and update TextViews
        }

        if(undo==252){
            tOneS = 3;
            tTwoS = 3;
            undo = 2;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(fou));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(fou));
        //if "undo" is 252, set "tOneS" and "tTwoS" to 3, set "undo" to 2 and update TextViews
        }

        if(undo==1010){
            tOneS = 3;
            tTwoS = 3;
            undo = 1;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(fou));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(fou));
        //if "undo" is 1010, set "tOneS" and "tTwoS" to 3, set "undo" to 1 and update TextViews
        }

        if(undo==2020){
            tOneS = 3;
            tTwoS = 3;
            undo = 2;
            if (mShowCountOne != null)
                mShowCountOne.setText(Integer.toString(fou));
            if (mShowCountTwo != null)
                mShowCountTwo.setText(Integer.toString(fou));
        //if "undo" is 2020, set "tOneS" and "tTwoS" to 3, set "undo" to 2 and update TextViews
        }

        if(tOneS == 0){
            mShowCountOne.setText(Integer.toString(tOneS));
        }
        if(tTwoS == 0){
            mShowCountTwo.setText(Integer.toString(tTwoS));
        //if score is 0, set the TextView to the score
        }
        if(tOneS == 1){
            mShowCountOne.setText(Integer.toString(fif));
        }
        if(tTwoS == 1){
            mShowCountTwo.setText(Integer.toString(fif));
        //if score is 1, set the TextView to "fif" value (15)
        }
        if(tOneS == 2){
            mShowCountOne.setText(Integer.toString(thi));
        }
        if(tTwoS == 2){
            mShowCountTwo.setText(Integer.toString(thi));
        //if score is 2, set the TextView to "thi" value (30)
        }
        if(tOneS == 3){
            mShowCountOne.setText(Integer.toString(fou));
        }
        if(tTwoS == 3){
            mShowCountTwo.setText(Integer.toString(fou));
        //if score is 3, set the TextView to "fou" value (40)
        }
        if(tOneS == 4){
            mShowCountOne.setText("Adv.");
        }
        if(tTwoS == 4){
            mShowCountTwo.setText("Adv.");
        //if score is 4, set the TextView to "Adv."
        }
    }

    public void SettingsClick (View view){ //public function "SettingsClick"
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        //Moves to Settings activity
    }
}