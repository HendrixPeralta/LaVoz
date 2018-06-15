package com.hdx.lavoz;

import android.content.Intent;
import android.net.Uri;
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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewsDataCollector  extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{


    private static final int RC_PHOTO_PICKER = 2;
    String userName, postTitle, postDate, postCategory, postDescription;
    int postImg;

    Spinner mySpinner;
    ArrayAdapter<CharSequence> arrayAdapter;

    Date date;

    EditText titleEditText;
    EditText descriptionEditText;
    ImageButton publishImageButton;
    ImageButton postImageImageButton;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_card);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Sport");
        storageReference = firebaseStorage.getReference().child("Post_Images");

        titleEditText = findViewById(R.id.input_title_edit_text);
        descriptionEditText = findViewById(R.id.input_description_edit_text);
        publishImageButton = findViewById(R.id.publish_button);
        postImageImageButton = findViewById(R.id.input_add_image);

        mySpinner = findViewById(R.id.input_spinner);
        mySpinner.setOnItemSelectedListener(this);

        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.category_array, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mySpinner.setAdapter(arrayAdapter);

        date = Calendar.getInstance().getTime();
        postDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
        Toast.makeText(this, postDate, Toast.LENGTH_LONG).show();

        postImageImageButton.setOnClickListener(view ->{
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/jpg");
            intent.putExtra(intent.EXTRA_LOCAL_ONLY, false);
            startActivityForResult(Intent.createChooser(intent, "Continua Con"), RC_PHOTO_PICKER);

        });
        publishImageButton.setOnClickListener(view ->{
            postTitle = titleEditText.getText().toString();
            postDescription = descriptionEditText.getText().toString();

            NewsModel newsModel = new NewsModel(null, postTitle, postDate, postCategory, postDescription, 0);
            databaseReference.push().setValue(newsModel);

            finish();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK) {
//            Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
//        } else if (resultCode == RESULT_CANCELED) {
//            Toast.makeText(this, "Sign in canceled!", Toast.LENGTH_SHORT).show();
//        } else
    if (requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();

            // Get a reference to store file at chat_photos/<FILENAME>
            StorageReference photoRef = storageReference.child(selectedImageUri.getLastPathSegment());

            photoRef.putFile(selectedImageUri);
//                    .addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            //When the image has successfully uploaded, get its download URL
//                            photoRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                                @Override
//                                public void onSuccess(Uri uri) {
//                                    Uri dlUri = uri;
//
//                                }
//                            });
//                        }
//                    });
        }
    }
}
