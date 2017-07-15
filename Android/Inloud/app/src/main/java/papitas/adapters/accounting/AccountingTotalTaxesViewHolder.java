package papitas.adapters.accounting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

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
        String[] values = view.getResources().getStringArray(R.array.invoiceDummyTax);
        double val = 0;

        for (int i = 0; i < values.length; i++) {
            val += Double.parseDouble(values[i]);
        }
        DecimalFormat format = new DecimalFormat("#,###,###.00");
        String formatted = format.format(val);
        total.setText("$ "+formatted);
    }

}