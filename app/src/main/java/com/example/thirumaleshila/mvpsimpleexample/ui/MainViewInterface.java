package com.example.thirumaleshila.mvpsimpleexample.ui;

import com.example.thirumaleshila.mvpsimpleexample.models.MovieResponse;

public interface MainViewInterface {
    void showToast(String s);
    void displayMovies(MovieResponse movieResponse);
    void displayError(String s);
}
