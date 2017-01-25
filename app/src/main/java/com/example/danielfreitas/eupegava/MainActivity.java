package com.example.danielfreitas.eupegava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        if(AccessToken.getCurrentAccessToken() == null){
            goToLogin();
        }

    }

    private void goToLogin() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }

    public void logout(View view) {
        Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT);
        LoginManager.getInstance().logOut();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
