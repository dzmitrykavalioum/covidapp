package com.dzmitrykavalioum.covidapp.ui.dashboard;

import com.dzmitrykavalioum.covidapp.model.Country;
import com.dzmitrykavalioum.covidapp.service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryPresenter implements CountriesContract.PresenterContract {

    private  CountriesContract.ViewContract viewContract;
    private List<Country> countries;

    public CountryPresenter (CountriesContract.ViewContract viewContract){
        this.viewContract = viewContract;
    }

    @Override
    public void getCountries() {
        Call<List<Country>> call = NetworkService.cases().getCountriesList();
        viewContract.showLoading();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                countries = response.body();
                viewContract.hideLoading();
                viewContract.showCountries(countries);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                viewContract.hideLoading();
                viewContract.showError(t.getMessage());

            }
        });


    }
}
