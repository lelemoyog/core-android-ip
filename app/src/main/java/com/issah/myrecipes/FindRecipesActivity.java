package com.issah.myrecipes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindRecipesActivity extends AppCompatActivity {



    GridView gridView;
    Integer[] image = {
            R.drawable.bbq,R.drawable.bergers,R.drawable.british,R.drawable.coffee,
            R.drawable.fastfood,R.drawable.fishdish,R.drawable.glutenfree,R.drawable.noodlesoup,
            R.drawable.scandinavian,R.drawable.vegan
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findrecipes);


        
        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new ImageArrayAdapter(this));
    }




    private class ImageArrayAdapter extends BaseAdapter {

        private Context mContext;

        public ImageArrayAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View covertView, ViewGroup parent) {
            ImageView imageView;

            if(covertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(150,150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0,16,0,16);

            }else {
                imageView = (ImageView) covertView;
            }
            imageView.setImageResource(image[position]);
            return  imageView;
        }
    }
}
