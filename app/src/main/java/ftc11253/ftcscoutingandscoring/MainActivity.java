package ftc11253.ftcscoutingandscoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    int pointValue2 = 0; // the total amount of points that both teams have earned
    boolean latestCache = false; // thingy to make sure undo works
    boolean jewel1b = false; // boolean to see if the jewel has been knocked off for team 1
    boolean jewel2b = false; // boolean to see if the jewel has been knocked off for team 2
    int team1 = 0; // total amount of points for team number 1
    int team2 = 0; // total amount of points for team number 2
    int teamN1 = 0; // the number for team number 1
    int teamN2 = 0; // the number for team number 2

    // members of undo function

    int team1Cache = 0; // i might add array stacking
    int team2Cache = 0; // to this part later

    // A few things to understand about the undo cache system
    // Works by having a cache for each of the teams.
    // A boolean dictates which team was most recently updated
    // When the undo function is executed, it will undo according to what team was most recently edited.

    // events for team 1 buttons

    public void jewelTeam1(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team1 = team1 + 30; // add the points
        team1Cache = 30;
        update();
        latestCache = false;

    }
    public void glyphTeam1(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team1 = team1 + 15; // add the points
        team1Cache = 15;
        update();
        latestCache = false;

    }
    public void glyphBonusTeam1(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team1 = team1 + 30; // add the points
        team1Cache = 30;
        update();
        latestCache = false;

    }
    public void parkTeam1(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team1 = team1 + 10; // add the points
        team1Cache = 10;
        update();
        latestCache = false;

    }

    // events for team 2 buttons

    public void jewelTeam2(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team2 = team2 + 30; // add the points
        team2Cache = 30;
        update();
        latestCache = true;

    }
    public void glyphTeam2(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team2 = team2 + 15; // add the points
        team2Cache = 15;
        update();
        latestCache = true;

    }
    public void glyphBonusTeam2(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team2 = team2 + 30; // add the points
        team2Cache = 30;
        update();
        latestCache = true;

    }
    public void parkTeam2(View v){ // function for the button click

        Button button = (Button) v; // some button thing or whatever
        team2 = team2 + 10; // add the points
        team2Cache = 10;
        update();
        latestCache = true;

    }

    public void undoButton(View v){ // function for the button click

        undo();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalPointsText = findViewById(R.id.textView14); // find totalPointText
        team1PointsText = findViewById(R.id.textView15); // find team1PointsText
        team2PointsText = findViewById(R.id.textView16); // find team2PointsText
        init();
    }

    public void init(){

        update();

    }

    TextView totalPointsText;
    TextView team1PointsText;
    TextView team2PointsText;

    public void update(){ // simply updates all of the text values

        pointValue2 = team1+team2; // does some QUICK MATHS

        totalPointsText.setText("Total Points: "+pointValue2); // display total points
        team1PointsText.setText("Team 1 Points: "+team1); // display team 1 points
        team2PointsText.setText("Team 2 Points: "+team2); // display team 2 points

    }

    public void undo(){ // undo function in case of score error

        if (latestCache){
            team2 = team2 - team2Cache;
            team2Cache = 0;
            update();
        } else {
            team1 = team1 - team1Cache;
            team1Cache = 0;
            update();
        }

    }

    public void reset(){ // reset function in case op wants to reset



    }

}
