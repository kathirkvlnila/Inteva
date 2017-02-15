package com.android.inteva;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContentResolverCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class DashBoardActivity extends AppCompatActivity {

    // UI references.
    private ImageButton mImgLogoutView;
    private TextView mTxtTitleView;
    private ImageSwitcher mImageSwitcherView;
    private Gallery mGalleryView;
    private Button mBtnViewSpec;

    private TextView mTxtSlideSunRoofTitle;
    private LinearLayout mLytSlideSunRoofView;

    private TextView mTxtPanoramicRoofTitle;
    private LinearLayout mLytPanoramicRoofView;


    int[] mResources = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,};
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        mContext = this;
        mImageSwitcherView = (ImageSwitcher) findViewById(R.id.imgSwitcherId);
        mGalleryView = (Gallery) findViewById(R.id.galleryId);
        mTxtTitleView = (TextView) findViewById(R.id.homeTitleId);

        // Buttons
        mImgLogoutView = (ImageButton) findViewById(R.id.logoutBtnId);
        mBtnViewSpec = (Button) findViewById(R.id.btnViewSpec);

        // Slide SunRoof
        mTxtSlideSunRoofTitle = (TextView) findViewById(R.id.firstTitleId);
        mLytSlideSunRoofView = (LinearLayout) findViewById(R.id.slideSunroofLytId);

        // Panoramic Roof System
        mTxtPanoramicRoofTitle = (TextView) findViewById(R.id.secondTitleId);
        mLytPanoramicRoofView = (LinearLayout) findViewById(R.id.panoramicRoofId);

        //

        mTxtTitleView.setText("Roof Systems");

        mImageSwitcherView.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT));
                imageView.setBackgroundColor(0xFFffffff);

                return imageView;
            }
        });
        mImageSwitcherView.setInAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left));
        mImageSwitcherView.setOutAnimation(AnimationUtils.loadAnimation(mContext, android.R.anim.slide_out_right));

        mGalleryView.setAdapter(new ImageAdapter(mContext));
        mGalleryView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mImageSwitcherView.setImageResource(mResources[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void setListners(){

    }

    View.OnClickListener _OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.logoutBtnId:

                    break;

                case R.id.btnViewSpec:

                    break;

                default:
                    break;

            }
        }
    };

    /**
     * Gallery Image Adapter
     */
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mResources.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = new ImageView(mContext);

            imageView.setImageResource(mResources[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(470, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            int padding = dipToPx(mContext, 5);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setBackgroundResource(R.drawable.item_selector);

            return imageView;
        }

        private int dipToPx(Context context, int dip) {
            return (int) (dip * context.getResources().getDisplayMetrics().density);
        }


    }

}
