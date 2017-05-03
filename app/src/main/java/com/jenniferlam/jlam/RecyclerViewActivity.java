package com.jenniferlam.jlam;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by jennifer on 4/26/2017.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[][] places = {
            {"New York", "New York"},
            {"Los Angeles", "California"},
            {"Chicago", "Illinois"},
            {"Houston", "Texas"},
            {"Philadelphia", "Pennsylvania"},
            {"Phoenix", "Arizona"},
            {"San Antonio", "Texas"},
            {"San Diego", "California"},
            {"Dallas", "Texas"},
            {"San Jose", "California"},
            {"Austin", "Texas"},
            {"Jacksonville", "Florida"},
            {"San Francisco", "California"},
            {"Indianapolis", "Indiana"},
            {"Columbus", "Ohio"},
            {"Fort Worth", "Texas"},
            {"Charlotte", "North Carolina"},
            {"Seattle", "Washington"},
            {"Denver", "Colorado"},
            {"El Paso", "Texas"},
            {"Detroit", "Michigan"},
            {"Washington", "District of Columbia"},
            {"Boston", "Massachusetts"},
            {"Memphis", "Tennessee"},
            {"Nashville", "Tennessee"},
            {"Portland", "Oregon"},
            {"Oklahoma City", "Oklahoma"},
            {"Las Vegas", "Nevada"},
            {"Baltimore", "Maryland"},
            {"Louisville", "Kentucky"},
            {"Milwaukee", "Wisconsin"},
            {"Albuquerque", "New Mexico"},
            {"Tucson", "Arizona"},
            {"Fresno", "California"},
            {"Sacramento", "California"},
            {"Kansas City", "Missouri"},
            {"Long Beach", "California"},
            {"Mesa", "Arizona"},
            {"Atlanta", "Georgia"},
            {"Colorado Springs", "Colorado"},
            {"Virginia Beach", "Virginia"},
            {"Raleigh", "North Carolina"},
            {"Omaha", "Nebraska"},
            {"Miami", "Florida"},
            {"Oakland", "California"},
            {"Minneapolis", "Minnesota"},
            {"Tulsa", "Oklahoma"},
            {"Wichita", "Kansas"},
            {"New Orleans", "Louisiana"},
            {"Arlington", "Texas"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_items);
        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.recycleview1);
        recyclerViewLayoutManager = new LinearLayoutManager(context);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);


        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

    }


    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView cityView;
            public TextView stateView;

            public ViewHolder(View v) {
                super(v);
                cityView = (TextView) v.findViewById(R.id.city_name);
                stateView = (TextView) v.findViewById(R.id.state_name);

            }
        }

        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = getLayoutInflater().inflate(R.layout.list_item, parent, false);
            ViewHolder vh = new ViewHolder(item);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.cityView.setText(places[position][0]);
            holder.stateView.setText(places[position][1]);
        }

        @Override
        public int getItemCount() {
            return places.length;
        }

    }
}
