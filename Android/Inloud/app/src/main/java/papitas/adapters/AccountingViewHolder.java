package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import papitas.inloud.R;

/**
 * Created by juanm on 8/07/2017.
 */

public class AccountingViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView value;


    public AccountingViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.accountingTitle);
        value = (TextView) v.findViewById(R.id.accountingValue);
    }

    public void bind(String text, final int position) {
        title.setText(text);
        value.setText(text);
    }

}
