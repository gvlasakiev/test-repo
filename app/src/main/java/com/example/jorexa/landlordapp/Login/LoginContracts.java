package com.example.jorexa.landlordapp.Login;

import java.util.List;

public interface LoginContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showError(Exception e);
    }

    interface Presenter {
        void subscribe(View view);

        void loadLogin();
    }
}
