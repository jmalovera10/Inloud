package papitas.adapters.accounting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import papitas.inloud.R;

/**
 * Created by juanm on 19/07/2017.
 */

public class AccountingNoDataViewHolder extends RecyclerView.ViewHolder {

    private TextView title;

    public AccountingNoDataViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.noDataTitle);
    }

    public void bind(String text, final int position) {
        title.setText(text);
    }

}