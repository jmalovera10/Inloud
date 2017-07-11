package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private ImageView image;


    public MyInvoiceViewHolder(View v) {
        super(v);
        value = (TextView) v.findViewById(R.id.invoiceValue);
        date = (TextView) v.findViewById(R.id.invoiceDate);
        tax = (TextView) v.findViewById(R.id.invoiceTax);
        image = (ImageView) v.findViewById(R.id.itemImage);
        linearLayout = (LinearLayout) v.findViewById(R.id.listingMaster);
    }

    public void bind(String pValue,String pDate, String pTax, final int position) {
        value.setText("Tot: "+pValue);
        date.setText(pDate);
        tax.setText("Tax: "+pTax);
        image.setImageResource(R.drawable.invoice);
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
