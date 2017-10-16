package proj.elitepick.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import proj.elitepick.R;
import proj.elitepick.UserActivity;
import proj.elitepick.fragments.home.CardViewAdapter;
import proj.elitepick.fragments.home.FeedProperties;
import proj.elitepick.viewpager.HomeActiviy;
import proj.elitepick.wishbook.AddToWishBook;

public class ProductDetail extends AppCompatActivity {

    private ImagePagerAdapter adapter;
    List<String> urls = new ArrayList<>();

    final int[] icons = {R.drawable.product, R.drawable.sd, R.drawable.product, R.drawable.sd, R.drawable.sd, R.drawable.sd};

    private ArrayList<FeedProperties> os_versions;
    @Bind(R.id.view_pager)
    ViewPager imagesPager;

    @Bind(R.id.thumbnails)
    ViewGroup thumbnails;

    @Bind(R.id.product_name)
    TextView productNameView;

    @Bind(R.id.fab_wish)
    FloatingActionButton fab_wish;

 @Bind(R.id.morebybrand)
 RecyclerView morebybrand;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        final String[] versions = {"", "", "", "",
                "", ""};
        ButterKnife.bind(this);

        fab_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent=new Intent(ProductDetail.this, AddToWishBook.class);
                startActivity(intent);
            }
        });
        morebybrand.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        os_versions = new ArrayList<FeedProperties>();

        for (int i = 0; i < versions.length; i++) {
            FeedProperties feed = new FeedProperties();

            feed.setTitle(versions[i]);
            feed.setThumbnail(icons[i]);
            os_versions.add(feed);
        }
        CardViewAdapter cardViewAdapter=new CardViewAdapter(os_versions);
        morebybrand.setAdapter(cardViewAdapter);

        urls.add("https://i.pinimg.com/736x/81/d2/92/81d292674157ed5556caef2f608e449f--outdoor-wood-pallet-furniture-pallet-lounge-outdoor.jpg");
        urls.add("http://www.homedepot.com/hdus/en_US/DTCCOMNEW/fetch/Category_Pages/Outdoor/Patio_Furniture/outdoor-dining-furniture.jpg");
        urls.add("https://cbsla.files.wordpress.com/2016/06/rendered32.jpg");
        initAdapter();
        initImages();
       /* setProductText();
        setBrandText();
        setPriceText();
        setQuantityText();
        setDescriptionText();*/
    }
    private void initAdapter() {
        adapter = new ImagePagerAdapter();

        adapter.setUrls(urls);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.productshare,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(ProductDetail.this, HomeActiviy.class);
                intent.putExtra("One", 2);// One is your argument

                startActivity(intent);



                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void generateThumbnail(String url, final int position, int size) {
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(size, size));
        imageView.setBackgroundResource(R.drawable.thumbnail_bg);
        Picasso.with(this).load(url).fit().centerInside().into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                imagesPager.setCurrentItem(position, true);
            }
        });
        thumbnails.addView(imageView);
    }
    private void initImages() {
        imagesPager.setAdapter(adapter);
        imagesPager.setPageTransformer(true, new ZoomOutPageTransformer());
        int size = getResources().getDimensionPixelSize(R.dimen.product_thumbnails_image_size);

        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
                    generateThumbnail(url, i, size);
        }
    }



    static class ImagePagerAdapter extends PagerAdapter {
        private List<String> urls;

        @Override
        public int getCount() {
            if (urls == null) {
                return 0;
            }

            return urls.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = container.getContext();
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(android.R.color.white);
            Picasso.with(context).load(urls.get(position)).fit().centerInside().into(imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }
    }
