package proj.elitepick.user;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import proj.elitepick.R;
import proj.elitepick.wishbook.Beanclass;
import proj.elitepick.wishbook.WishAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    RelativeLayout nowishbook;

    ArrayList<Beanclass> arrayList=new ArrayList<>();
    RecyclerView recyclerwish;
    FloatingActionButton addwishlist;

    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile, container, false);
        addwishlist=v.findViewById(R.id.addwishlist);
        nowishbook=v.findViewById(R.id.nowishbook);

        recyclerwish=v.findViewById(R.id.recyclerwish);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerwish.setLayoutManager(layoutManager);

        addwishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

                alert.setTitle("Add Wishbook");

// Set an EditText view to get user input

                alert.setMessage("");
                final EditText input = new EditText(getActivity());
                alert.setView(input);

                alert.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        nowishbook.setVisibility(View.GONE);
                        String value = input.getText().toString();
                        Beanclass beanclass=new Beanclass(value);
                        arrayList.add(beanclass);
                        WishAdapter myAdapter=new WishAdapter(arrayList, getActivity(), new WishAdapter.ClickListener() {
                            @Override
                            public void onPositionClicked(int position) {

                            }

                            @Override
                            public void onLongClicked(int position) {

                            }
                        });
                        recyclerwish.setAdapter(myAdapter);

// Do something with value!

                    }
                });
                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // String value = input.getText();
// Do something with value!
                    }
                });
                alert.setCancelable(false);
                alert.show();
            }
        });
        return v;
    }

}
