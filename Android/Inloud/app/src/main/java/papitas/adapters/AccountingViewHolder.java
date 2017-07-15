package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import papitas.inloud.R;

/**
 * Created by juanm on 8/07/2017.
 */

public class AccountingViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private BarChart barChart;
    private View view;

    public AccountingViewHolder(View v) {
        super(v);
        view = v;
        title = (TextView) v.findViewById(R.id.accountingTitle);
        barChart = (BarChart) v.findViewById(R.id.barChart);
    }

    public void bind(String text, final int position) {
        title.setText(text);
        String[] dates = view.getResources().getStringArray(R.array.invoiceDummyDate);
        String[] values = view.getResources().getStringArray(R.array.invoiceDummyValue);
        List<BarEntry> entries = new ArrayList<>();
        final ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < 7; i++) {
            entries.add(new BarEntry((float)i, Float.parseFloat(values[i])));
            labels.add(dates[i].split("-")[2]);
        }

        //Creating chart dataset
        BarDataSet dataset = new BarDataSet(entries,"Expense Value");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(dataset);
        data.setBarWidth(0.9f);

        //Setting X-Axis data
        barChart.getXAxis().setValueFormatter(new LabelFormatter(labels));
        XAxis xAxis = barChart.getXAxis();

        //Adding chart dataset
        barChart.setData(data);
        barChart.setFitBars(false);
        Description desc = new Description();
        desc.setText("");
        barChart.setDescription(desc);
        barChart.invalidate();

    }

}
