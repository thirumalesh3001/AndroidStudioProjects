package com.example.thirumaleshila.mvpsimpleexample.MainActivityPresenter;

import com.example.thirumaleshila.mvpsimpleexample.MainActivityContract.MainActivityContractt;

public class MainActivityPresenterr implements MainActivityContractt.Presenter {

    private final MainActivityContractt.View view;

    public MainActivityPresenterr(MainActivityContractt.View view) {
        this.view = view;
    }

    @Override
    public int doSum(int a, int b) {
        return a + b;
    }


}
