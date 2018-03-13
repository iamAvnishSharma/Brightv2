package in.bright.avnish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Avnish on 14-Mar-18.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {


    private Context mCtx;
    private List<Feed> feedList;

    public FeedAdapter(Context mCtx, List<Feed> feedList) {
        this.mCtx = mCtx;
        this.feedList = feedList;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.feed_list, null);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        Feed product = feedList.get(position);

        holder.textViewFeed.setText(product.getFeed());
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder {

        TextView textViewFeed;

        public FeedViewHolder(View itemView) {
            super(itemView);

            textViewFeed = itemView.findViewById(R.id.textViewFeed);
        }
    }


}
