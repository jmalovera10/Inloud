package papitas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import papitas.inloud.R;

/**
 * Created by juanm on 22/06/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter{

    private String[] items;

    public RecyclerViewAdapter(String[] items) {
        this.items = items;
    }

    @Override
    public TextItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_view, parent, false);
        return new TextItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TextItemViewHolder){
            TextItemViewHolder mHolder = (TextItemViewHolder) holder;
            mHolder.bind(items[position],position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
