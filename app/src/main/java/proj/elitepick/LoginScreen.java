package proj.elitepick;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class LoginScreen extends AppCompatActivity {
String title="Create An Account";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


       getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.cardview_light_background)));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'>Create An Account</font>"));

    }
}
