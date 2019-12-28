package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private TextView image1,image2,image3,image4;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1=findViewById(R.id.imageview1);
        imageView2=findViewById(R.id.imageview2);
        imageView3=findViewById(R.id.imageview3);
        imageView4=findViewById(R.id.imageview4);
        image1=findViewById(R.id.img1);
        image2=findViewById(R.id.img2);
        image3=findViewById(R.id.img3);
        image4=findViewById(R.id.img4);


    }

    public void update(View view) {
        DocumentReference user=db.collection("FILES").document("images");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot doc=task.getResult();

                    StringBuilder img1=new StringBuilder("");
                    img1.append(doc.get("image1"));
                    image1.setText(img1.toString());
                    String image1url=image1.getText().toString();
                    Picasso.get().load(image1url).into(imageView1);

                    StringBuilder img2=new StringBuilder("");
                    img2.append(doc.get("image2"));
                    image2.setText(img2.toString());
                    String image2url=image2.getText().toString();
                    Picasso.get().load(image2url).into(imageView2);

                    StringBuilder img3=new StringBuilder("");
                    img3.append(doc.get("image3"));
                    image3.setText(img3.toString());
                    String image3url=image3.getText().toString();
                    Picasso.get().load(image3url).into(imageView3);

                    StringBuilder img4=new StringBuilder("");
                    img4.append(doc.get("image4"));
                    image4.setText(img4.toString());
                    String image4url=image4.getText().toString();
                    Picasso.get().load(image4url).into(imageView4);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
