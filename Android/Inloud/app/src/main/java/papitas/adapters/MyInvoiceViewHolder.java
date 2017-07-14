package papitas.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    public void bind(String pValue,String pDate, String pTax, String pItems,final int position) {
        value.setText("$ "+pValue);
        date.setText(pDate);
        tax.setText("$ "+pTax);
        items.setText(pItems);
        image.setImageResource(R.drawable.invoice);
        Bitmap bm = BitmapFactory.decodeResource(view.getResources(),R.drawable.invoice);
        RoundImage roundedImage = new RoundImage(bm);
        image.setImageDrawable(roundedImage);
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
