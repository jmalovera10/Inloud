package papitas.adapters.accounting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import papitas.concept.Invoice;
import papitas.inloud.InloudMainActivity;
import papitas.inloud.R;

/**
 * Created by juanm on 15/07/2017.
 */

public class AccountingTotalTaxesViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView total;
    private View view;

    public AccountingTotalTaxesViewHolder(View v) {
        super(v);
        view = v;
        title = (TextView) v.findViewById(R.id.totalExpensesTitle);
        total = (TextView) v.findViewById(R.id.totalExpenses);
    }

    public void bind(String text, final int position) {
        title.setText(text);
        List<Invoice> invoices = InloudMainActivity.getInvoices();
        double val = 0;

        for (int i = 0; i < invoices.size(); i++) {
            val += invoices.get(i).getTax();
        }
        DecimalFormat format = new DecimalFormat("#,###,###");
        String formatted = format.format(val);
        total.setText("$ "+formatted);
    }

}