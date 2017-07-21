package papitas.adapters.invoices;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.List;

import papitas.concept.Invoice;
import papitas.inloud.R;

/**
 * Created by juanm on 22/06/2017.
 */

public class MyInvoiceRecyclerViewAdapter extends RecyclerView.Adapter{

    private List<Invoice> invoices;

    public MyInvoiceRecyclerViewAdapter(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(invoices.size()!=0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_item_layout, parent, false);
            return new MyInvoiceViewHolder(view);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_no_data_avaible, parent, false);
            return new MyInvoiceNoDataViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(invoices.size()!=0){
            MyInvoiceViewHolder mHolder = (MyInvoiceViewHolder) holder;
            Invoice invoice = invoices.get(position);
            mHolder.bind(invoice,position);
        }else{
            MyInvoiceNoDataViewHolder mHolder = (MyInvoiceNoDataViewHolder) holder;
            mHolder.bind();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return invoices.size()==0?1:invoices.size();
    }
}
