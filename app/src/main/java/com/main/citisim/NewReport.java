package com.main.citisim;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class NewReport extends AppCompatActivity {

    //vars
    private Button backToReports;
    private Button addImage;
    private Button submitImage;
    ImageView image;
    private static final int PICK_IMAGE=100;
    Uri imageUri;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_report);

        image=(ImageView)findViewById(R.id.image) ;
        backToReports=(Button)findViewById(R.id.backToReports);
        backToReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap2();
            }
        });

        addImage=(Button)findViewById(R.id.addImage);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        submitImage=(Button)findViewById(R.id. submitImage);
        submitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getDeviceLocation();


            }
        });


    }





    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            image.setImageURI(imageUri);
            //aici imaginea trebuie rotita
            //aici imaginea trebuie rotita
            //aici imaginea trebuie rotita
            //aici imaginea trebuie rotita
            }



        }





    public void openMap2(){
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

}
