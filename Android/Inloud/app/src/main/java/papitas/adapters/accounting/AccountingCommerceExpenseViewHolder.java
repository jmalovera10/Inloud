package papitas.adapters.accounting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import papitas.inloud.R;

/**
 * Created by juanm on 15/07/2017.
 */

public class AccountingCommerceExpenseViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private PieChart pieChart;
    private View view;

    public AccountingCommerceExpenseViewHolder(View v) {
        super(v);
        view = v;
        title = (TextView) v.findViewById(R.id.expensesCommerceTitle);
        pieChart = (PieChart) v.findViewById(R.id.pieChart);
    }

    public void bind(String text, final int position) {
        title.setText(text);
        String[] dates = view.getResources().getStringArray(R.array.invoiceDummyDate);
        String[] values = view.getResources().getStringArray(R.array.invoiceDummyValue);
        List<PieEntry> entries = new ArrayList<>();
        final ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < 3; i++) {
            entries.add(new PieEntry((Float.parseFloat(values[i])),(float)i));
            labels.add(dates[i].split("-")[2]);
        }

        //Creating chart dataset
        PieDataSet dataset = new PieDataSet(entries,"Expenses by Commerce");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataset);

        //Adding chart dataset
        pieChart.setData(data);
        pieChart.animateY(2000);
        Description desc = new Description();
        desc.setText("");
        pieChart.setDescription(desc);
        pieChart.invalidate();

    }

}