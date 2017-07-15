package papitas.adapters.accounting;

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
    public int getItemViewType(int position){
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Determines the holder type and sets the correspondent layout
        View view = null;
        switch (viewType){
            case 0: view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_value_card, parent, false);
                return new AccountingTotalExpensesViewHolder(view);

            case 1: view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_expenses_card, parent, false);
                return new AccountingExpensesViewHolder(view);

            case 2: view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_value_card, parent, false);
                return new AccountingTotalTaxesViewHolder(view);

            default: view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_expenses_card, parent, false);
                return new AccountingExpensesViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //Determines the holder type and binds it with the correspondent data
        switch (holder.getItemViewType()){
            case 0: AccountingTotalExpensesViewHolder mHolder = (AccountingTotalExpensesViewHolder) holder;
                    mHolder.bind(items[position],position);
                break;

            case 1: AccountingExpensesViewHolder tHolder = (AccountingExpensesViewHolder) holder;
                    tHolder.bind(items[position],position);
                break;

            case 2: AccountingTotalTaxesViewHolder eHolder = (AccountingTotalTaxesViewHolder) holder;
                    eHolder.bind(items[position],position);
                break;

            default:AccountingExpensesViewHolder sHolder = (AccountingExpensesViewHolder) holder;
                    sHolder.bind(items[position],position);
                break;
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