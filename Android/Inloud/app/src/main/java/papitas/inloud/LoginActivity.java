package papitas.inloud;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener{

    private static final int RC_SIGN_IN = 9001;

    private static final String TAG = "LoginActivity";


    /**
     * Reference to Facebook's login button
     */
    private LoginButton loginFacebookButton;

    /**
     * Reference to Facebook's callBackManager
     */
    private CallbackManager callbackManager;

    /**
     * Reference to GoogleApiClient
     */
    private GoogleApiClient mGoogleApiClient;

    /**
     * Reference to Google's login button
     */
    private Button loginGoogleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(android.R.style.Theme_Holo_Light_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Facebook Login Setup
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        loginFacebookButton = (LoginButton) findViewById(R.id.loginFacebookButton);
        loginFacebookButton.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday"));
        loginFacebookButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("LoginActivity", response.toString());

                                // Application code
                                try {
                                    String email = object.getString("email");
                                    String birthday = object.getString("birthday");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                // 01/31/1980 format
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();
                goToMain(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this,"Login failed. Try checking your internet connection",Toast.LENGTH_LONG).show();
            }
        });
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken!=null){
            goToMain(accessToken);
        }

        //Google Login Setup
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        findViewById(R.id.loginGoogleButton).setOnClickListener(this);
    }

    /**
     * Method that goes from login activity to main activity of the app
     * @param loginResult Parameter from which the user information is obtained
     */
    private void goToMain(AccessToken loginResult){
        Intent intent = new Intent(this, InloudMainActivity.class);
        intent.putExtra("loginSource","facebook");
        intent.putExtra("token",loginResult.getToken());
        startActivity(intent);
        finish();
    }

    /**
     * Method that goes from login activity to main activity of the app
     * @param loginResult Parameter from which the user information is obtained
     */
    private void goToMain(GoogleSignInAccount loginResult){
        Intent intent = new Intent(this, InloudMainActivity.class);
        intent.putExtra("loginSource","google");
        intent.putExtra("token",loginResult.getIdToken());
        intent.putExtra("userID",loginResult.getId());
        intent.putExtra("userName",loginResult.getDisplayName());
        intent.putExtra("userEmail",loginResult.getEmail());
        intent.putExtra("userPhoto",loginResult.getPhotoUrl());
        startActivity(intent);
        finish();
    }

    /**
     * Method used to login a user with google account
     */
    private void googleSignIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    /**
     * Method used to handle google's sign in result
     * @param result GoogleSignIn's result
     */
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            goToMain(acct);
        } else {
            // Signed out, show unauthenticated UI.

        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if(requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }else{
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(LoginActivity.this,"Login failed. Try checking your internet connection",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginGoogleButton:
                googleSignIn();
                break;
        }
    }


}
