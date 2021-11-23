package jacobtelford.com.assessmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void Back2HomeClick (View view){ //public function "Back2HomeClick"
        if(ChangeSport.sport ==1){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);}
        //if "sport" value from ChangeSport.java is 1, go to the MainActivity activity

        if(ChangeSport.sport ==4){
            Intent intent = new Intent(this, Tennis.class);
            startActivity(intent);}
        //if "sport" value from ChangeSport.java is 4, go to the Tennis activity

        if(ChangeSport.sport ==5){
            Intent intent = new Intent(this, Soccer.class);
            startActivity(intent);}
        //if "sport" value from ChangeSport.java is 5, go to the Soccer activity

        if(ChangeSport.sport ==7){
            Intent intent = new Intent(this, Rugby.class);
            startActivity(intent);}
        //if "sport" value from ChangeSport.java is 7, go to the Rugby activity
    }

    public void ChangeSportClick (View view){ //public function "ChangeSportClick"
        Intent intent = new Intent(this, ChangeSport.class);
        startActivity(intent);
        //Go to the ChangeSport activity
    }
}