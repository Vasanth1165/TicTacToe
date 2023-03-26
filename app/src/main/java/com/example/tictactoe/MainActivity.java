package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    // 0: O  1: X
    int playerActive=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    public static int count=0;

    boolean gameActive=true;
    int[][] winingPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};
    @SuppressLint("SetTextI18n")
    public void onClickImg(View view){

        ImageView imageView=(ImageView) view;
        imageView.setTranslationY(-500);

        int imgTapped=Integer.parseInt(imageView.getTag().toString());
        if(gameState[imgTapped]==2 && gameActive) {
            count++;
            if(count==9){
                gameActive=false;
            }
            gameState[imgTapped]=playerActive;
            if (playerActive == 0) {
                imageView.setImageResource(R.drawable.zero);
                playerActive = 1;
                TextView status = findViewById(R.id.textView);
                status.setText("X's Turn");
            } else {
                imageView.setImageResource(R.drawable.cross);
                playerActive = 0;
                TextView status = findViewById(R.id.textView);
                status.setText("0's Turn");
            }
            imageView.animate().translationYBy(500).setDuration(100);
            int draw=1;
            for(int[] position:winingPositions){
                if(gameState[position[0]]==gameState[position[1]]
                && gameState[position[1]]==gameState[position[2]]
                && gameState[position[0]]!=2){
                    draw=0;
                    String winner;
                    if(gameState[position[0]]==0) {
                        winner = "0 Won";
                    }else{
                        winner="X Won";
                    }
                    TextView status = findViewById(R.id.textView);
                    status.setText(winner);
                    Button playAgain=findViewById(R.id.button);
                    playAgain.setVisibility(View.VISIBLE);
                    gameActive=false;
                }
                if(count==9 && draw==1){
                    TextView status = findViewById(R.id.textView);
                    status.setText("   Draw ");
                    Button playAgain=findViewById(R.id.button);
                    playAgain.setVisibility(View.VISIBLE);
                    gameActive=false;
                }
            }

        }
    }
    @SuppressLint("SetTextI18n")
    public void playAgain(View view){
        Button playAgain=findViewById(R.id.button);
        playAgain.setVisibility(View.INVISIBLE);

        TextView status = findViewById(R.id.textView);
        status.setText("0's Turn");

        gameActive=true;
        playerActive=0;
        count =0;
        Arrays.fill(gameState, 2);

        ((ImageView) findViewById(R.id.imageView0)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView1)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView2)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView3)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView4)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView5)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView6)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView7)).setImageDrawable(null);
        ((ImageView) findViewById(R.id.imageView8)).setImageDrawable(null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playAgain=findViewById(R.id.button);
        playAgain.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int n=item.getItemId();
        switch(n){
            case R.id.Search:
                Toast.makeText(getApplicationContext(),"Searching",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Settings:
                Toast.makeText(getApplicationContext(),"Settings Clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Rate_us:
                Toast.makeText(getApplicationContext(),"Rating Clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Support:
                Toast.makeText(getApplicationContext(),"Support Clicked",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}