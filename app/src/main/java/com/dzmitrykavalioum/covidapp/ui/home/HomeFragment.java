package com.dzmitrykavalioum.covidapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dzmitrykavalioum.covidapp.R;
import com.dzmitrykavalioum.covidapp.model.Total;

public class HomeFragment extends Fragment implements TotalContract.ViewContract {

    private HomeViewModel homeViewModel;
    private TotalPresenter totalPresenter;
    private  TextView tv_cases;
    private  TextView tv_deaths;
    private  TextView tv_recovered;
    private ProgressBar pb_total;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tv_cases = root.findViewById(R.id.tv_total_cases);
        tv_deaths = root.findViewById(R.id.tv_total_deaths);
        tv_recovered = root.findViewById(R.id.tv_total_recovered);
        pb_total = root.findViewById(R.id.pb_total);
        totalPresenter = new TotalPresenter(this);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        totalPresenter.getTotal();
        return root;
    }

    @Override
    public void showTotal(Total total) {
        tv_cases.setText("Cases "+total.getCases().toString());
        tv_deaths.setText("Deaths "+total.getDeaths().toString());
        tv_recovered.setText("Recovered "+total.getRecovered().toString());

    }

    @Override
    public void showLoading() {
        pb_total.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb_total.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }
}
