package com.dzmitrykavalioum.covidapp.ui.dashboard;

import com.dzmitrykavalioum.covidapp.model.Country;

import java.util.List;

public interface CountriesContract {
    interface PresenterContract {
        void getCountries();
    }

    interface ViewContract {
        void showCountries(List<Country> countries);

        void showLoading();

        void hideLoading();

        void showMessage(String message);


        void showError(String message);
    }
}
