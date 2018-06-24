package com.example.thirumaleshila.mvpsimpleexample.MainActivityContract;

public interface MainActivityContractt {

    public interface View {
        void displaySum();
    }

    public interface Presenter
    {
        int doSum(int a, int b);

    }
}
