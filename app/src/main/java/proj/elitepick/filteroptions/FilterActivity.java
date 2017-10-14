package proj.elitepick.filteroptions;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import proj.elitepick.R;


public class FilterActivity extends AppCompatActivity {
  RangeBar rangebar;
    Typeface fonts1;
    Toolbar toolbar;
    ImageView ic_close;


    LinearLayout linear1,linear2, linear3, linear4, linear5, linear6, linear7, linear8;
    TextView ss, m, l, xl, xxl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        fonts1 =  Typeface.createFromAsset(FilterActivity.this.getAssets(), "fonts/MavenPro-Regular.ttf");
toolbar= (Toolbar) findViewById(R.id.toolbar2);
        ic_close=toolbar.findViewById(R.id.ic_close);
        ic_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button t5 =(Button)findViewById(R.id.rang1);
        t5.setTypeface(fonts1);
        Button t6 =(Button)findViewById(R.id.rang2);
        t6.setTypeface(fonts1);





        ss = (TextView) findViewById(R.id.ss);
        m = (TextView) findViewById(R.id.m);
        l = (TextView) findViewById(R.id.l);
        xl = (TextView) findViewById(R.id.xl);


        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("28", "1");

            }
        });


        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("29", "2");

            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("30", "3");

            }
        });
        xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("31", "4");

            }
        });





        rangebar = (RangeBar) findViewById(R.id.rangebar1);



        final Button leftIndexValue = (Button) findViewById(R.id.rang1);
        final Button rightIndexValue = (Button) findViewById(R.id.rang2);

        // Sets the display values of the indices
        rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex,
                                              String leftPinValue, String rightPinValue) {
                leftIndexValue.setText("$" + leftPinIndex);
                rightIndexValue.setText("$" + rightPinIndex);
            }

        });


    }
    private void clickb(String s , String t) {


        ss.setBackgroundResource(R.drawable.sizeround1);
        ss.setTextColor(Color.parseColor("#585858"));
        m.setBackgroundResource(R.drawable.sizeround1);
        m.setTextColor(Color.parseColor("#585858"));
        l.setBackgroundResource(R.drawable.sizeround1);
        l.setTextColor(Color.parseColor("#585858"));
        xl.setBackgroundResource(R.drawable.sizeround1);
        xl.setTextColor(Color.parseColor("#585858"));





        if(t.equalsIgnoreCase("1")) {
            ss.setBackgroundResource(R.drawable.sizeround2);
            ss.setTextColor(Color.parseColor("#ffffff"));


        }
        else if(t.equalsIgnoreCase("2")){
            m.setBackgroundResource(R.drawable.sizeround2);
            m.setTextColor(Color.parseColor("#ffffff"));


        }

        else if(t.equalsIgnoreCase("3")){
            l.setBackgroundResource(R.drawable.sizeround2);
            l.setTextColor(Color.parseColor("#ffffff"));



        }
        else if(t.equalsIgnoreCase("4")){
            xl.setBackgroundResource(R.drawable.sizeround2);
            xl.setTextColor(Color.parseColor("#ffffff"));



        }









    }
}
