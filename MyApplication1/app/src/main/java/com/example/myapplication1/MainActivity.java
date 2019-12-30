package com.example.myapplication1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the providers
        providers= Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
//                new AuthUI.IdpConfig.PhoneBuilder().build(),
//                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        showSignInOption();

        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(MainActivity.this,SampleActivity.class));
            finish();
        }

    }

    private void showSignInOption() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTheme(R.style.MyTheme)
                .setLogo(R.drawable.iconfinder_location)
                .build(),MY_REQUEST_CODE
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MY_REQUEST_CODE){
            IdpResponse response=IdpResponse.fromResultIntent(data);
            if(resultCode==RESULT_OK){
                //Get user
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
//                Toast.makeText(this,""+user.getEmail()+" , name : "+user.getDisplayName(),Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,SampleActivity.class));
                finish();
            }
            else{
                Toast.makeText(this,""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
