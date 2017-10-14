package proj.elitepick.fragments.home.products;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import proj.elitepick.R;


/**
 * Created by sai on 20/9/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList arrayList;
    Context context;


    public MyAdapter(ArrayList arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //we call inflator over here...
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new MyViewHolder(v,context,arrayList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        GetSet getSet= (GetSet) arrayList.get(position);
        holder.textView.setText(getSet.getText());
        holder.img1.setImageResource(getSet.getImg());


    }

    @Override
    public int getItemCount() {

        //return the size of arraylist
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView img1;
        Context ctx;
        ArrayList<GetSet> arrayList=new ArrayList();
        public MyViewHolder(View itemView,Context context,ArrayList al) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.text1);
            img1 = (ImageView) itemView.findViewById(R.id.img1);
            arrayList=al;
            ctx=context;
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            GetSet data=arrayList.get(position);
            Toast.makeText(ctx, ""+data.getText(), Toast.LENGTH_SHORT).show();



        }
    }
}