package com.dzmitrykavalioum.covidapp.ui.home;

import android.view.View;

import com.dzmitrykavalioum.covidapp.model.Total;
import com.dzmitrykavalioum.covidapp.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TotalPresenter implements TotalContract.PresenterContract {

    private TotalContract.ViewContract view;
    private Total total;

    public  TotalPresenter (TotalContract.ViewContract view){
        this.view = view;
    }

    @Override
    public Total getTotal() {
        Call<Total> call = NetworkService.cases().getTotal();
        view.showLoading();
        call.enqueue(new Callback<Total>() {
            @Override
            public void onResponse(Call<Total> call, Response<Total> response) {
                total = response.body();
                view.hideLoading();
                view.showTotal(total);
            }

            @Override
            public void onFailure(Call<Total> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());

            }
        });

        return total;
    }
}
