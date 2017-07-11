package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;

import papitas.concept.Invoice;
import papitas.inloud.R;

/**
 * Created by juanm on 22/06/2017.
 */

public class MyInvoiceRecyclerViewAdapter extends RecyclerView.Adapter{

    private Invoice[] invoices;

    public MyInvoiceRecyclerViewAdapter(Invoice[] invoices) {
        this.invoices = invoices;
    }

    @Override
    public MyInvoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_item_layout, parent, false);
        return new MyInvoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyInvoiceViewHolder){
            MyInvoiceViewHolder mHolder = (MyInvoiceViewHolder) holder;
            Invoice invoice = invoices[position];
            String date = new SimpleDateFormat("dd/MM/yyyy").format(invoice.getDate());
            mHolder.bind(invoice.getTotalCost().toString(), date
                    ,invoice.getTax().toString(),position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return invoices.length;
    }
}
