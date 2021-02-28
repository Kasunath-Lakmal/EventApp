package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    1. Intialized
    private  ListView listView;
    private Button eventAdd;
    private TextView eventCount;
    private Context context;
//11. CREATE DbHandler class object(VARIABLE EKA DEFINE KARA GENIMA)
    private DbHandler dbHandler;
 //15. LIST TYPE EKE VARIABLE EKK CREATE KARA GENIMA
    private List<EventModel> elist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.addList);
        eventAdd = findViewById(R.id.addevent);
        eventCount = findViewById(R.id.countdisplay);
        context = this;
//12. INITIALIZED THE VARIABLE
        dbHandler = new DbHandler(this);
//16 .INITIALIZED THE VARIABLE
        elist = new ArrayList<>();
//17 .CALL THE getAllEvents() METHOD FROM DbHandler CLASS(= lakunen wam peththe thiyenne, array list eken ena values variable ekata dama vidiayai)
 //DEN DbHandler eken dena listView eka MainActivity eka peththeta aran thiyenne[den thiyena data source eka].
        elist =  dbHandler.getAllEvents();
 //NOW CREATE ARRAY ADAPTER[18. STEPS]
 //25. SET THE ADPATER for LISTVIEW(MainActivity ListView)
                                                //(context,resource eka, ArrayList eka)
        EventAdapter adapter = new EventAdapter(context,R.layout.row_layout,elist);
//26. den main activity eke thiyena ListView ekata adapater eka set karanna onii..
        listView.setAdapter(adapter);
//    3. Steps
        eventAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,AddEventActivity.class));
            }
        });

//13. GET COUNT FROM TABLE
        int countEvent = dbHandler.eventCount();
        eventCount.setText(" you have " + countEvent + " events " );
 //NOW DISPLAY THE COUNT
    }
}