package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import papitas.inloud.R;

/**
 * Created by juanm on 8/07/2017.
 */

public class AccountingRecyclerViewAdapter extends RecyclerView.Adapter{

    private String[] items;

    public AccountingRecyclerViewAdapter(String[] items) {
        this.items = items;
    }

    @Override
    public AccountingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_card, parent, false);
        return new AccountingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof AccountingViewHolder){
            AccountingViewHolder mHolder = (AccountingViewHolder) holder;
            mHolder.bind(items[position],position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}