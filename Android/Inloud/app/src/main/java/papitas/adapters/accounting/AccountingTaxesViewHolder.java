package papitas.adapters.accounting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import papitas.adapters.LabelFormatter;
import papitas.concept.Invoice;
import papitas.inloud.InloudMainActivity;
import papitas.inloud.R;

/**
 * Created by juanm on 15/07/2017.
 */

public class AccountingTaxesViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private BarChart barChart;
    private View view;

    public AccountingTaxesViewHolder(View v) {
        super(v);
        view = v;
        title = (TextView) v.findViewById(R.id.expensesTitle);
        barChart = (BarChart) v.findViewById(R.id.barChart);
    }

    public void bind(String text, final int position) {
        title.setText(text);
        List<Invoice> invoices = InloudMainActivity.getInvoices();
        List<BarEntry> entries = new ArrayList<>();
        final ArrayList<String> labels = new ArrayList<String>();

        //Parsing data from all invoices
        for (int i = 0; i < invoices.size(); i++) {
            Invoice invoice = invoices.get(i);
            entries.add(new BarEntry((float)i, invoice.getTax().floatValue()));
            String date = new SimpleDateFormat("dd").format(invoice.getDate());
            labels.add(date);
        }

        //Creating chart dataset
        BarDataSet dataset = new BarDataSet(entries,"Expense Value");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(dataset);
        data.setBarWidth(0.9f);

        //Setting X-Axis data
        barChart.getXAxis().setValueFormatter(new LabelFormatter(labels));

        //Adding chart dataset
        barChart.setData(data);
        barChart.setFitBars(false);
        Description desc = new Description();
        desc.setText("");
        barChart.setDescription(desc);
        barChart.invalidate();

    }

}
