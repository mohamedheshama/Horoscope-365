package eg.emad.horoscope365.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import eg.emad.horoscope365.Model.HomeItem;
import eg.emad.horoscope365.Properities;
import eg.emad.horoscope365.R;

/**
 * Created by emad on 2/10/19.
 */

public class ProperitiesHomeRecycler extends RecyclerView.Adapter<ProperitiesHomeRecycler.MyViewHolder>{
    ArrayList<HomeItem> homeItems = new ArrayList<>();
    Context context;

    public ProperitiesHomeRecycler(ArrayList<HomeItem> homeItems, Context context) {
        this.homeItems = homeItems;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.home_recycler_item, parent, false);
        return new ProperitiesHomeRecycler.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(homeItems.get(position).getTitle());
        Picasso.get().load(homeItems.get(position).getImgPath()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView img;
        Intent intent;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textHomeItem1);
            img= itemView.findViewById(R.id.imageHomeItem1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(context, Properities.class);
                    intent.putExtra("borgName",homeItems.get(getAdapterPosition()).getTitle());
                    intent.putExtra("borgIndex",getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
