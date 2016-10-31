package com.example.psshami.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int logo[]={R.drawable.logo1,R.drawable.logo2,R.drawable.logo3,R.drawable.logo4,R.drawable.logo5};
    String answer[]={"apple","nike","flipkart","pizza Hut","sbi"};

    Button bsubmit,bnext,bplayagain;
    TextView tvscore;
    ImageView ivlogo,ivverdict;
    EditText etans;
    int score = 0;
    int cur_pos = 0 ;
    boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //finding widgets
        bsubmit = (Button)findViewById(R.id.bsubmit);
        bnext = (Button)findViewById(R.id.bnext);
        etans = (EditText)findViewById(R.id.etans);
        tvscore = (TextView)findViewById(R.id.tvscore);
        ivverdict = (ImageView)findViewById(R.id.ivverdict);
        ivlogo = (ImageView)findViewById(R.id.ivlogo);
        bplayagain = (Button)findViewById(R.id.bplayagain);
        bplayagain.setVisibility(View.INVISIBLE);
        ivlogo.setImageResource(logo[cur_pos]);
        bsubmit.setVisibility(View.VISIBLE);
        bnext.setVisibility(View.INVISIBLE);
        ivverdict.setVisibility(View.INVISIBLE);
        tvscore.setText(score+"");


        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivverdict.setVisibility(View.VISIBLE);
                bsubmit.setVisibility(View.INVISIBLE);
                bnext.setVisibility(View.VISIBLE);
                String input = etans.getText().toString();
                if(input.equalsIgnoreCase(answer[cur_pos])){
                    //CORRECT ANSWER
                    ivverdict.setImageResource(R.drawable.greentick);
                    score += 100;
                    correct = true;
                }
                else{
                    correct  = false;
                    ivverdict.setImageResource(R.drawable.wrong);
                    score -= 50;
                    if(score <= 0){
                        ivlogo.setImageResource(R.drawable.lose);
                        etans.setVisibility(View.INVISIBLE);
                        bsubmit.setVisibility(View.INVISIBLE);
                        bnext.setVisibility(View.INVISIBLE);
                        bplayagain.setVisibility(View.VISIBLE);
                    }
                }
                tvscore.setText(score+"");
            }
        });

        //clicking on next button for next image
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_pos++;
                etans.setText("");
                ivverdict.setVisibility(View.INVISIBLE);
                if(cur_pos > 4 ) {
                    ivlogo.setImageResource(R.drawable.you_win);
                    etans.setVisibility(View.INVISIBLE);
                    bplayagain.setVisibility(View.VISIBLE);
                }
                else {
                    ivlogo.setImageResource(logo[cur_pos]);
                    bsubmit.setVisibility(View.VISIBLE);// alternatively changing visibility of submit and next buttons
                    bnext.setVisibility(View.INVISIBLE);//
                }

            }
        });

        bplayagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_pos = 0 ;
                score = 0 ;
                tvscore.setText(score+"");
                etans.setVisibility(View.VISIBLE);
                bplayagain.setVisibility(View.INVISIBLE);
                ivlogo.setImageResource(logo[cur_pos]);
                bsubmit.setVisibility(View.VISIBLE);
                bnext.setVisibility(View.INVISIBLE);
                ivverdict.setVisibility(View.INVISIBLE);
            }
        });
    }
}
