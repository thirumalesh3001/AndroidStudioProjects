package com.example.thirumaleshila.mvpsimpleexample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.thirumaleshila.mvpsimpleexample.R;
import com.example.thirumaleshila.mvpsimpleexample.adapters.MoviesAdapter;
import com.example.thirumaleshila.mvpsimpleexample.models.MovieResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  MainViewInterface{
    @BindView(R.id.rvMovies)
    RecyclerView rvMoviess;

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;
    //RecyclerView rvMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //rvMovies = (RecyclerView) findViewById(R.id.rvMovies);

        setupMVP();
        setupViews();
        getMovieList();
    }
    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvMoviess.setLayoutManager(manager);
        rvMoviess.setHasFixedSize(true);

    }

    private void getMovieList() {

        mainPresenter.getMovies();

    }
    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this,s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayMovies(MovieResponse movieResponse) {
        if(movieResponse!=null) {
            Log.d(TAG,movieResponse.getResults().get(1).getTitle());
            adapter = new MoviesAdapter(movieResponse.getResults(), MainActivity.this);
            rvMoviess.setAdapter(adapter);
        }else{
            Log.d(TAG,"Movies response null");
        }
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }
}
