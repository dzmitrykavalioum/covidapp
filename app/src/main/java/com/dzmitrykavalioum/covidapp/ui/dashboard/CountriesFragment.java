package com.dzmitrykavalioum.covidapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dzmitrykavalioum.covidapp.R;
import com.dzmitrykavalioum.covidapp.adapters.CountriesRvAdapter;
import com.dzmitrykavalioum.covidapp.model.Country;

import java.util.List;

public class CountriesFragment extends Fragment  implements  CountriesContract.ViewContract{

    private CountriesViewModel countriesViewModel;
    private RecyclerView rv_countries;
    private CountriesRvAdapter countriesRvAdapter;
    private List<Country> countries;
    private CountryPresenter countryPresenter;
    private LinearLayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countriesViewModel =
                ViewModelProviders.of(this).get(CountriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countries, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        countriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        rv_countries = root.findViewById(R.id.rv_countries);

        countryPresenter = new CountryPresenter(this);
        layoutManager = new LinearLayoutManager(root.getContext());
        itemAnimator = new DefaultItemAnimator();
        countryPresenter.getCountries();



        return root;
    }

    @Override
    public void showCountries(List<Country> countries) {
        if (countries!=null){
            countriesRvAdapter = new CountriesRvAdapter(countries,getContext());
            rv_countries.setAdapter(countriesRvAdapter);
            rv_countries.setLayoutManager(layoutManager);
            rv_countries.setItemAnimator(itemAnimator);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showError(String message) {

    }
}
