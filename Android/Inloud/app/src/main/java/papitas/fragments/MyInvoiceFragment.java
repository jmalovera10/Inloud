package papitas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import papitas.adapters.invoices.MyInvoiceRecyclerViewAdapter;
import papitas.concept.Invoice;
import papitas.concept.Item;
import papitas.inloud.R;

/**
 * A fragment representing a list of Items.
 * interface.
 */
public class MyInvoiceFragment extends Fragment {


    private RecyclerView recyclerView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyInvoiceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_my_invoice, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] values = getResources().getStringArray(R.array.invoiceDummyValue);
        String[] taxes = getResources().getStringArray(R.array.invoiceDummyTax);
        String[] dates = getResources().getStringArray(R.array.invoiceDummyDate);
        String[] items = getResources().getStringArray(R.array.invoiceDummyItems);
        Invoice[] invoices = new Invoice[values.length];

        long id = 0;

        for (int i = 0; i < values.length; i++) {
            Invoice invoice = new Invoice();
            invoice.setId(id++);
            invoice.setTotalCost(Double.parseDouble(values[i].toString()));
            invoice.setTax(Double.parseDouble(taxes[i].toString()));
            List<Item> pItems = new ArrayList<Item>();
            int l = Integer.parseInt(items[i]);
            for (int j = 0; j < l; j++) {
                pItems.add(new Item());
            }
            invoice.setItems(pItems);
            try {
                DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                Date pDate = dateformat.parse(dates[i]);
                long time = pDate.getTime();
                invoice.setDate(new Timestamp(time));
            }catch (Exception e){
                e.printStackTrace();
            }
            invoices[i] = invoice;
        }
        MyInvoiceRecyclerViewAdapter adapter = new MyInvoiceRecyclerViewAdapter(invoices);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_my_invoice);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(true);
    }
}
