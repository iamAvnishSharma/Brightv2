package in.bright.avnish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ChapAdapter extends RecyclerView.Adapter<ChapAdapter.ChapViewHolder> {


    private Context mCtx;
    private List<Chap> chapList;

    public ChapAdapter(Context mCtx, List<Chap> chapList) {
        this.mCtx = mCtx;
        this.chapList = chapList;
    }

    @Override
    public ChapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.chap_list, null);
        return new ChapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChapViewHolder holder, int position) {
        Chap product = chapList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDsc.setText(product.getShortdesc());
    }

    @Override
    public int getItemCount() {
        return chapList.size();
    }

    class ChapViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewDsc;
        ImageView imageView;

        public ChapViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDsc = itemView.findViewById(R.id.textViewDsc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


}
