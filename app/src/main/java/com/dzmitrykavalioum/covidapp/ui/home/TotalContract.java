package com.dzmitrykavalioum.covidapp.ui.home;

import com.dzmitrykavalioum.covidapp.model.Total;

public interface TotalContract {
    interface PresenterContract {
        Total getTotal();
    }

    interface ViewContract {
        void showTotal(Total total);

        void showLoading();

        void hideLoading();

        void showError (String message);
    }
}
