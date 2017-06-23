package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import papitas.inloud.R;

/**
 * Created by juanm on 22/06/2017.
 */

public class TextItemViewHolder extends RecyclerView.ViewHolder{

    private TextView fecha;
    private TextView username;
    private TextView capitulo;
    private ImageView imagen;


    public TextItemViewHolder(View v) {
        super(v);
        fecha = (TextView) v.findViewById(R.id.fechaNoticia);
        username = (TextView) v.findViewById(R.id.tituloNoticia);
        capitulo = (TextView) v.findViewById(R.id.dependenciaNoticia);
        imagen = (ImageView) v.findViewById(R.id.imagen_noticia);
    }

    public void bind(String text) {
        fecha.setText(text);
        username.setText(text);
        capitulo.setText(text);
        imagen.setImageResource(R.mipmap.ic_launcher);
    }
}
