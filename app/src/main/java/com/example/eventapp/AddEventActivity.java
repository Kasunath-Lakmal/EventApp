package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEventActivity extends AppCompatActivity {

//    2.Intialized
    private EditText edittitle, editDescription;
    private Button add;
// 8. steps DbHandler object ekk hada ganna oni. (ADD EVENT METHOD EKA CALL KIRIMATA)
    private DbHandler dbHandler;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        edittitle = findViewById(R.id.addtitle);
        editDescription = findViewById(R.id.addDescription);
        add = findViewById(R.id.addbutton);
 //8. steps INITIALIZED THE OBJECT
        context = this;
        dbHandler = new DbHandler(context);


// 5.Steps
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserTitle = edittitle.getText().toString();
                String UserDescription = editDescription.getText().toString();
                long started = System.currentTimeMillis();
   //model class eke object ekk create kirima(input karana data model eke constructor ekata  pass kirima)
    //eventModel object athule all user input data and model class ekema thiyena variable and method tikath thiyenavawa.
                EventModel eventModel = new EventModel(UserTitle, UserDescription, started, 0 );
//9 . call the addEvent method.
                dbHandler.addEvent(eventModel);
//ADD EVENT AFTER MOVE THE MAIN ACTIVITY
                startActivity(new Intent(context,MainActivity.class));

            }
        });


    }
}

//6. Steps- go to the DbHandler class