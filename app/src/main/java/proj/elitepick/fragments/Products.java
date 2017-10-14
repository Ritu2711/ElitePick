package proj.elitepick.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import proj.elitepick.R;
import proj.elitepick.filteroptions.FilterActivity;
import proj.elitepick.fragments.home.products.ExpandableHeightGridView;
import proj.elitepick.fragments.home.products.GetSet;
import proj.elitepick.fragments.home.products.GridviewAdapter;
import proj.elitepick.fragments.home.products.MyAdapter;
import proj.elitepick.wishbook.Beanclass;

/**
 * A simple {@link Fragment} subclass.
 */
public class Products extends Fragment {
    LinearLayout filter;
    ExpandableHeightGridView gridview;
    private ArrayList<proj.elitepick.fragments.home.products.Beanclass> beanclassArrayList;
    private GridviewAdapter gridviewAdapter;
    RecyclerView recyclerView;
    private View view;
    ArrayList<GetSet> al=new ArrayList();

    private int[] IMAGEgrid = {R.drawable.product, R.drawable.product,R.drawable.product, R.drawable.product,R.drawable.product,R.drawable.product};
    private String[] TITLeGgrid = {"Min 70% off", "Min 50% off", "Min 45% off",  "Min 60% off", "Min 70% off", "Min 50% off"};
    private String[] DIscriptiongrid = {"Wrist Watch", "Wrist Watch", "Wrist Watch","Wrist Watch", "Wrist Watch", "Wrist Watch"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!", "Explore Now!","Grab Now!"};


    public Products() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_products, container, false);
        gridview = (ExpandableHeightGridView)view.findViewById(R.id.gridview);
        filter = (LinearLayout)view.findViewById(R.id.filter);
        recyclerView = (RecyclerView)view.findViewById(R.id.newRecycle);
        GetSet g1=new GetSet(R.drawable.product,"BedRoom  Furniture");
        GetSet g2=new GetSet(R.drawable.product,"LivingRoom Furniture");
        GetSet g3=new GetSet(R.drawable.product,"Modular Kitchen Furniture");
        GetSet g4=new GetSet(R.drawable.product,"Home Office Furniture");
        GetSet g5=new GetSet(R.drawable.product,"Outdoor Kids Furniture");


        al.add(g1);
        al.add(g2);
        al.add(g3);
        al.add(g4);
        al.add(g5);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);
            }
        });
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        beanclassArrayList= new ArrayList<proj.elitepick.fragments.home.products.Beanclass>();
        MyAdapter myAdapter=new MyAdapter(al,getActivity());
        recyclerView.setAdapter(myAdapter);
        for (int i= 0; i< IMAGEgrid.length; i++) {

            proj.elitepick.fragments.home.products.Beanclass beanclass = new proj.elitepick.fragments.home.products.Beanclass(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
            beanclassArrayList.add(beanclass);

        }
        gridviewAdapter = new GridviewAdapter(getActivity(), beanclassArrayList);
        gridview.setExpanded(true);

        gridview.setAdapter(gridviewAdapter);
        return view;
    }

}
