package com.dzmitrykavalioum.covidapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dzmitrykavalioum.covidapp.R;
import com.dzmitrykavalioum.covidapp.interfades.ItemClickListener;
import com.dzmitrykavalioum.covidapp.model.Country;

import com.dzmitrykavalioum.covidapp.ui.countryitem.CountryItemActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CountriesRvAdapter extends RecyclerView.Adapter<CountriesRvAdapter.ViewHolder> {
    private List<Country> countries;
    private Context context;


    public CountriesRvAdapter(List<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        context = parent.getContext();

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countries.get(position);

//        String urlImage = country.getVideo1();
//        if (urlImage != "") {
//            Picasso.get().load(urlImage).into(holder.iv_lathe);
//        } else {
//            holder.iv_lathe.setImageResource(R.drawable.ic_menu_camera);
//        }
        holder.tv_country_name.setText(country.getCountry());
        holder.tv_cases.setText(country.getCases().toString());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent  =new Intent(context, CountryItemActivity.class);
                intent.putExtra(Country.class.getSimpleName(),countries.get(position));
                context.startActivity(intent);
            }
        });
        holder.tv_position.setText(position+"");



    }


    @Override
    public int getItemCount() {
        return countries.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        private ItemClickListener itemClickListener;
        private AdapterView.OnItemClickListener clickListener;
        private TextView tv_country_name;
        private TextView tv_cases;
        private TextView tv_position;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_country_name = itemView.findViewById(R.id.tv_country_name);
            tv_cases = itemView.findViewById(R.id.tv_country_cases);
            tv_position = itemView.findViewById(R.id.tv_position);
            itemView.setOnClickListener(this::onClick);




        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }




        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
