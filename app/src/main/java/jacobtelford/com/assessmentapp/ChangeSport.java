package jacobtelford.com.assessmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChangeSport extends AppCompatActivity {

    public static int sport = 1; //public integer "sport" set to 1.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_sport);
    }

    public void BkBall (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        sport = 1;
        //public function"BkBall" goes to the MainActivity screen and sets "sport" to 1
    }

    public void Tns (View view){
        Intent intent = new Intent(this, Tennis.class);
        startActivity(intent);
        sport = 4;
        //public function"Tns" goes to the Tennis screen and sets "sport" to 4
    }

    public void Scr (View view){
        Intent intent = new Intent(this, Soccer.class);
        startActivity(intent);
        sport = 5;
        //public function"Scr" goes to the Soccer screen and sets "sport" to 5
    }

    public void RL (View view){
        Intent intent = new Intent(this, Rugby.class);
        startActivity(intent);
        sport = 7;
        //public function"RL" goes to the Rugby screen and sets "sport" to 7
    }
}