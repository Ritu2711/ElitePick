package proj.elitepick.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import proj.elitepick.R;
import proj.elitepick.UserActivity;
import proj.elitepick.fragments.ProductDetail;
import proj.elitepick.viewpager.HomeActiviy;

public class WishbookActivity extends AppCompatActivity {

    String title="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishbook);

        title=getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(WishbookActivity.this, UserActivity.class);


                startActivity(intent);



                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
