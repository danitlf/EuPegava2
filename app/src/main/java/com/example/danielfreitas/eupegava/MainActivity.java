package com.example.danielfreitas.eupegava;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        //lucas esteve aqui
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.danielfreitas.eupegava",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

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
