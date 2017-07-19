package papitas.inloud;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import papitas.concept.Invoice;

public class InvoiceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        Invoice invoice = (Invoice) extras.getSerializable("invoice");

        if(invoice!=null) {

            //set serial id
            TextView complete = (TextView) findViewById(R.id.serialId);
            complete.setText("" + invoice.getSerialID() + "");

            if(invoice.getDate()!=null) {
                //set date
                complete = (TextView) findViewById(R.id.date);
                complete.setText("" + invoice.getDate().toString() + "");

                //set time
                complete = (TextView) findViewById(R.id.date);
                complete.setText("" + invoice.getDate().toString() + "");
            }

            if(invoice.getCommerce()!=null) {
                //set company name
                complete = (TextView) findViewById(R.id.companyName);
                complete.setText("" + invoice.getCommerce().getName() + "");

                //set company address
                complete = (TextView) findViewById(R.id.address);
                complete.setText("" + invoice.getCommerce().getAddress() + "");

                //set company nit
                complete = (TextView) findViewById(R.id.nit);
                complete.setText("" + invoice.getCommerce().getNit() + "");
            }

            //set total cost
            complete = (TextView) findViewById(R.id.totalCost);
            complete.setText("" + invoice.getTotalCost() + "");

            //set  tax
            complete = (TextView) findViewById(R.id.tax);
            complete.setText("" + invoice.getTax() + "");
        }



    }
}
