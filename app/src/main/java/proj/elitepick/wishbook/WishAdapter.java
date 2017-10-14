package proj.elitepick.wishbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import proj.elitepick.R;
import proj.elitepick.user.WishbookActivity;

/**
 * Created by sai on 14/10/17.
 */

public class WishAdapter extends RecyclerView.Adapter<WishAdapter.MyViewHolder> {
    ArrayList arrayList;
    Context context;
    private final ClickListener listener;

    public WishAdapter(ArrayList arrayList, Context context,ClickListener listener) {
        this.arrayList = arrayList;
        this.context = context;
        this.listener = listener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //we call inflator over here...
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.wishbookgrid,parent,false);

        return new MyViewHolder(v,context,arrayList,listener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Beanclass getSet= (Beanclass) arrayList.get(position);
        holder.textView.setText(getSet.getName());


    }

    @Override
    public int getItemCount() {

        //return the size of arraylist
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView option,imgwish;
        Context ctx;
        private WeakReference<ClickListener> listenerRef;
        ArrayList<Beanclass> arrayList=new ArrayList();
        public MyViewHolder(View itemView,Context context,ArrayList al,ClickListener listener) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);

            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.wishname);
            option = (ImageView) itemView.findViewById(R.id.option);
            imgwish = (ImageView) itemView.findViewById(R.id.imgwish);
            option.setOnClickListener(this);
            imgwish.setOnClickListener(this);
            arrayList=al;
            ctx=context;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == option.getId()) {
                Toast.makeText(v.getContext(), "Option", Toast.LENGTH_SHORT).show();
            }
            if (v.getId() == imgwish.getId()) {

                Beanclass beanclass=arrayList.get(getAdapterPosition());

                Intent intent=new Intent(ctx, WishbookActivity.class);
                intent.putExtra("title",beanclass.getName());
                ctx.startActivity(intent);

            }
            listenerRef.get().onPositionClicked(getAdapterPosition());


        }
    }
    public interface ClickListener {

        void onPositionClicked(int position);

        void onLongClicked(int position);
    }
}