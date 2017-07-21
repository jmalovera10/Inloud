package papitas.adapters.invoices;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import papitas.adapters.RoundImage;
import papitas.concept.Invoice;
import papitas.inloud.InloudMainActivity;
import papitas.inloud.R;

/**
 * Created by juanm on 22/06/2017.
 */

public class MyInvoiceViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout linearLayout;
    private TextView value;
    private TextView date;
    private TextView tax;
    private TextView items;
    private ImageView image;
    private View view;

    public MyInvoiceViewHolder(View v) {
        super(v);
        view = v;
        value = (TextView) v.findViewById(R.id.invoiceValue);
        date = (TextView) v.findViewById(R.id.invoiceDate);
        tax = (TextView) v.findViewById(R.id.invoiceTax);
        items = (TextView) v.findViewById(R.id.invoiceItems);
        image = (ImageView) v.findViewById(R.id.itemImage);
        linearLayout = (LinearLayout) v.findViewById(R.id.listingMaster);
    }

    public void bind(Invoice invoice, final int position) {
        DecimalFormat format = new DecimalFormat("#,###,###.00");
        String formatted = format.format(invoice.getTotalCost());
        value.setText("$ "+formatted);
        formatted = format.format(invoice.getTax());
        tax.setText("$ "+formatted);

        String dDate = new SimpleDateFormat("dd/MM/yyyy").format(invoice.getDate());
        date.setText(dDate);
        items.setText(""+invoice.getItems().size());

        //we are setting the image here! (probably can be avoided)
        Bitmap bm = BitmapFactory.decodeResource(view.getResources(),invoice.getCommerce().getImage());
        RoundImage roundedImage = new RoundImage(bm);
        image.setImageDrawable(roundedImage);

        //
        linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(view.getContext()instanceof InloudMainActivity){
                    InloudMainActivity main = (InloudMainActivity) view.getContext();
                    main.startInvoiceDetail(position);
                }
            }
        });
    }

}
