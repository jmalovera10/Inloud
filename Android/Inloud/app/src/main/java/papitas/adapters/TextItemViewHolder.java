package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import papitas.inloud.InloudMainActivity;
import papitas.inloud.R;

/**
 * Created by juanm on 22/06/2017.
 */

public class TextItemViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout linearLayout;
    private TextView title;
    private TextView subTitle;
    private TextView subSubTitle;
    private ImageView image;


    public TextItemViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.itemTitle);
        subTitle = (TextView) v.findViewById(R.id.subTitItem);
        subSubTitle = (TextView) v.findViewById(R.id.subSubTitItem);
        image = (ImageView) v.findViewById(R.id.itemImage);
        linearLayout = (LinearLayout) v.findViewById(R.id.listingMaster);
    }

    public void bind(String text, final int position) {
        title.setText(text);
        subTitle.setText(text);
        subSubTitle.setText(text);
        image.setImageResource(R.mipmap.ic_launcher);
        linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
    }

}
