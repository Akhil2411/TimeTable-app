package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timetable.Utils.LetterImageView;

public class WeekActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar =findViewById(R.id.ToolbarWeek);            //initialising the toolbar and the list view
        listView =findViewById(R.id.lvWeek);
    }


    private void initToolbar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Week");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);           //for back arrow

    }

    private void setupListView(){

        String[] week=getResources().getStringArray(R.array.Week);

        WeekAdapter adapter=new WeekAdapter(this,R.layout.activity_week_single_item,week);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:break;
                    case 1:break;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 5:break;
                    default:break;

                }
            }
        });


    }

    public class WeekAdapter extends ArrayAdapter {


        private int resource;                             //resource is the layout you need
        private LayoutInflater layoutInflater;
        private  String[] week = new String[]{};


        public WeekAdapter(Context context, int resource,String[] objects) {
            super(context, resource,objects);

            this.resource=resource;
            this.week=objects;


            layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        //alt+0->override methods->getView


        @Override
        public View getView(int position,  View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView==null){
                holder = new ViewHolder();
                convertView=layoutInflater.inflate(resource,null);
                holder.ivLogo=convertView.findViewById(R.id.ivLetter);
                holder.tvWeek=convertView.findViewById(R.id.tvWeek);

                convertView.setTag(holder);

            }else{
                holder=(ViewHolder) convertView.getTag();      //for optimisation
            }
            holder.ivLogo.setOval(true);          //get oval image
            holder.ivLogo.setLetter(week[position].charAt(0));  //give the image letter
            holder.tvWeek.setText(week[position]); //give the day


            return convertView;

        }

        class ViewHolder{
            //inject the elements of the new layout to be put in the week activity
            //consider it as a box which contains the elements

            private LetterImageView ivLogo;
            private TextView tvWeek;
        }




    }




    //alt+0
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}























