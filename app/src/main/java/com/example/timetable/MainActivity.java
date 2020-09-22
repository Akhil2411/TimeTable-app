package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar =findViewById(R.id.ToolbarMain);            //initialising the toolbar and the list view
        listView =findViewById(R.id.lvMain);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);                            //for Bringing the toolbar in the xml layout to the main activity in an interactive way
        getSupportActionBar().setTitle("Timetable App");
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.Main);                   //initialising the sting array from strings.xml
        String[] description = getResources().getStringArray(R.array.Description);      //initialising the description array from strings.xml

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);      //creating an object of the class
        listView.setAdapter(simpleAdapter);                                                     //setting the cardview inside the listview
    }



    //Adapter is generally a bridge between UI and the data source.it helps us to fill in data inside the ui components.
    //it pulls data from the databse or array
    //it sends data to adpterview and adapter view sends it to view
    //In final stage view shows data on different view like list view, grid view , spinner,recycler view etc
    //an adapter provides a simple view..To customize it we use base adapter

    public class SimpleAdapter extends BaseAdapter{         //BaseAdapter is an abstract class

        private Context mContext;                           //intialising a context variable
        private LayoutInflater layoutInflater;              //Instantiates a layout XML file into its corresponding View objects.

        private TextView title;
        private TextView description;

        private String[] titleArray;
        private String[] descriptionArray;                 //title,description and image keep changing in each lists...so we use array
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description){           //constructor created to initialise the variables


            mContext = context;
            titleArray = title;
            descriptionArray = description;


            layoutInflater = LayoutInflater.from(context);                   //get the layout from the context given(main activity)


        }


        @Override
        public int getCount() {
            return titleArray.length;                           //returns the length of the title ARRAY
        }

        @Override
        public Object getItem(int position) {

            return titleArray[position];                     //returns the position of the title array......titleArray[0],titleArray[1],titleArray[2]..
        }

        @Override
        public long getItemId(int position) {

            return position;                                   //returns position............0,1,2,3...
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {



            if(convertView == null){



                convertView = layoutInflater.inflate(R.layout.main_activity_single_item, null);        //change the view from layout main to singleitem


            }

            title = convertView.findViewById(R.id.tvMain);                  //title id given in single item

            description = convertView.findViewById(R.id.tvDescription);    //description id given in single item


            imageView = convertView.findViewById(R.id.ivMain);            //image id given in single item

            title.setText(titleArray[position]);                      //get the text from strings.xml and set it in place of title in each list

            description.setText(descriptionArray[position]);          //get the text from strings.xml and set it in place of title in each list





            if(titleArray[position].equalsIgnoreCase("Timetable")){            //setting images


                imageView.setImageResource(R.drawable.timetable);


            }else if(titleArray[position].equalsIgnoreCase("Subjects")){


                imageView.setImageResource(R.drawable.book);


            }else if(titleArray[position].equalsIgnoreCase("Faculty")){


                imageView.setImageResource(R.drawable.contact);


            }else{


                imageView.setImageResource(R.drawable.settings);
            }

            return convertView;

        }
    }

}
