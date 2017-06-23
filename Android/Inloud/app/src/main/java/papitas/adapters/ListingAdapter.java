package papitas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import papitas.inloud.R;

/**
 * Created by juanm on 22/06/2017.
 */

public class ListingAdapter extends ArrayAdapter<String> {

    private ArrayList<String> dataset;

    private Context contexto;

    public ListingAdapter(Context context, int textViewResourceId, ArrayList<String> dataset) {
        super(context, textViewResourceId, dataset);
        this.dataset = dataset;
        contexto=context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.listing_view, null);
        }
        String lip = dataset.get(position);
        if (lip != null) {
            TextView fecha = (TextView) v.findViewById(R.id.fechaNoticia);
            TextView username = (TextView) v.findViewById(R.id.tituloNoticia);
            TextView capitulo = (TextView) v.findViewById(R.id.dependenciaNoticia);
            ImageView imagen = (ImageView) v.findViewById(R.id.imagen_noticia);
            if (username != null) {
                username.setText(lip);
            }
            if (imagen != null){
                imagen.setImageResource(R.mipmap.ic_launcher);
            }
            if (fecha != null){
                fecha.setText(lip);
            }
            if (capitulo != null){
                capitulo.setText(lip);
            }
        }
        return v;
    }
}
