package papitas.inloud;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.sql.Timestamp;
import java.util.Random;

import papitas.adapters.ViewPagerAdapter;
import papitas.concept.Client;
import papitas.concept.Invoice;

public class InloudMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.OnConnectionFailedListener {

    /**
     * Constant that models the status of QR result from QR scanner
     */
    public static final int QR_CODE_RESULT = 2001;

    /**
     * Attribute that makes a reference to the user who is using the app
     */
    private Client user;

    /**
     * Attribute that references the google api client
     */
    private GoogleApiClient mGoogleApiClient;

    //UI Management

    /**
     * Attribute that references the tabbed layout of the main activity
     */
    private TabLayout tabLayout;

    /**
     * Attribute that references the pager of the tab layout
     */
    private ViewPager viewPager;

    /**
     * Attribute that models the adapter for the view pager
     */
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_inloud_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InloudMainActivity.this,ScannerActivity.class);
                startActivityForResult(intent,QR_CODE_RESULT);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Google session controller
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient =  new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //Retrieve user data from login
        user = new Client();
        Bundle extras = getIntent().getExtras();
        switch (extras.getString("loginSource")){
            case "facebook":

                break;
            case "google":
                //user.setId(Long.parseLong(extras.getString("userID")));
                user.setName(extras.getString("userName"));
                user.setEmail(extras.getString("userEmail"));
                if(user.getEmail()==null||user.getName()==null) {
                    Toast.makeText(this, "" + user.getName() + user.getEmail(), Toast.LENGTH_LONG).show();
                }
                break;
        }

        //UI Management

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inloud_main, menu);
        TextView txtClient = (TextView)findViewById(R.id.clientName);
        txtClient.setText(user.getName());
        TextView txtEmail = (TextView)findViewById(R.id.clientEmail);
        txtEmail.setText(user.getEmail());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        item.setChecked(false);

        if (id == R.id.nav_addInvoice) {
            Intent intent = new Intent(InloudMainActivity.this,ScannerActivity.class);
            startActivityForResult(intent,QR_CODE_RESULT);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout){

            new AlertDialog.Builder(this)
                    .setTitle("Logout")
                    .setMessage("Do you really want to logout?")
                    .setIcon(R.drawable.ic_logout)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {
                            if(whichButton==AlertDialog.BUTTON_POSITIVE){
                                //Facebook Logout
                                LoginManager.getInstance().logOut();
                                returnToLogin();
                                //Google Logout
                                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                                        new ResultCallback<Status>() {
                                            @Override
                                            public void onResult(Status status) {

                                            }
                                        });
                            }
                            returnToLogin();
                        }})
                    .setNegativeButton(android.R.string.no, null).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Method that returns to login activity when a logout is done
     */
    private void returnToLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(InloudMainActivity.this,"Login failed. Try checking your internet connection",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==QR_CODE_RESULT){
            if(resultCode==RESULT_OK){
                //Gets the scanned QR code
                String url = data.getData().toString();
                Toast.makeText(this,url,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void startInvoiceDetail(int position){

        Intent intent = new Intent(InloudMainActivity.this,InvoiceDetailActivity.class);

        //TODO: fetch invoice here
        Invoice invoice = new Invoice();
        invoice.setId(new Long(position));

        //change random value: TODO
        Random random = new Random();
        invoice.setSerialID(Math.abs(random.nextLong()));

        //date TODO
       // invoice.setDate(new Timestamp(Long.parseLong(getResources().getStringArray(R.array.invoiceDummyDate)[position])));

        //Tax
        invoice.setTax(Double.parseDouble(getResources().getStringArray(R.array.invoiceDummyTax)[position]));

        //Total cost
        invoice.setTotalCost(Double.parseDouble(getResources().getStringArray(R.array.invoiceDummyValue)[position]));

        //Set items: TODO

        intent.putExtra("invoice", invoice);
        startActivity(intent);
    }
}
