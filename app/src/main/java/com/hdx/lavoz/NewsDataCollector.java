package com.hdx.lavoz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewsDataCollector  extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    String userName, postTitle, postDate, postCategory, postDescription;
    int postImg;

    Spinner mySpinner;
    ArrayAdapter<CharSequence> arrayAdapter;

    Date date;

    EditText titleEditText;
    EditText descriptionEditText;
    ImageButton publishImageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_card);

        titleEditText = findViewById(R.id.input_title_edit_text);
        descriptionEditText = findViewById(R.id.input_description_edit_text);
        publishImageButton = findViewById(R.id.publish_button);

        mySpinner = findViewById(R.id.input_spinner);
        mySpinner.setOnItemSelectedListener(this);

        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.category_array, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mySpinner.setAdapter(arrayAdapter);

        date = Calendar.getInstance().getTime();
        postDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
        Toast.makeText(this, postDate, Toast.LENGTH_LONG).show();

        publishImageButton.setOnClickListener(view ->{
            postTitle = titleEditText.getText().toString();
            postDescription = descriptionEditText.getText().toString();
            Log.d("TITLE", postTitle);
            Log.d("DESCRIPTION", postDescription);
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        postCategory = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, postCategory, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

    }
}
