package papitas.adapters.accounting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import papitas.inloud.InloudMainActivity;
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

            case 1: if(InloudMainActivity.getInvoices().size()!=0){
                        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_barchart_card, parent, false);
                        return new AccountingExpensesViewHolder(view);
                    }else{
                        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_no_data_avaible, parent, false);
                        return new AccountingNoDataViewHolder(view);
                    }

            case 2: view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_value_card, parent, false);
                return new AccountingTotalTaxesViewHolder(view);

            case 3: if(InloudMainActivity.getInvoices().size()!=0){
                        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_barchart_card, parent, false);
                        return new AccountingTaxesViewHolder(view);
                    }else{
                        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_no_data_avaible, parent, false);
                        return new AccountingNoDataViewHolder(view);
                    }

            case 4: view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_piechart_card, parent, false);
                return new AccountingCommerceExpenseViewHolder(view);

            default: view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounting_barchart_card, parent, false);
                return new AccountingExpensesViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //Determines the holder type and binds it with the correspondent data
        switch (holder.getItemViewType()){

            //Setting data for total expenses
            case 0: AccountingTotalExpensesViewHolder mHolder = (AccountingTotalExpensesViewHolder) holder;
                    mHolder.bind(items[position],position);
                break;

            //Setting data for historical expenses
            case 1: if(InloudMainActivity.getInvoices().size()!=0){
                        AccountingExpensesViewHolder tHolder = (AccountingExpensesViewHolder) holder;
                        tHolder.bind(items[position],position);
                    }
                    else{
                        AccountingNoDataViewHolder tHolder = (AccountingNoDataViewHolder) holder;
                        tHolder.bind(items[position],position);
                    }
                break;

            //Setting data for total taxes
            case 2:AccountingTotalTaxesViewHolder eHolder = (AccountingTotalTaxesViewHolder) holder;
                eHolder.bind(items[position],position);
                break;

            //Setting data for historical taxes
            case 3: if(InloudMainActivity.getInvoices().size()!=0) {
                        AccountingTaxesViewHolder qHolder = (AccountingTaxesViewHolder) holder;
                        qHolder.bind(items[position], position);
                    }else{
                        AccountingNoDataViewHolder qHolder = (AccountingNoDataViewHolder) holder;
                        qHolder.bind(items[position],position);
                    }
                break;

            //Setting data for historical expenses by commerce
            case 4: AccountingCommerceExpenseViewHolder xHolder = (AccountingCommerceExpenseViewHolder) holder;
                xHolder.bind(items[position],position);
                break;

            //Default if none
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