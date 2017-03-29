package pl.snowdog.moesampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import pl.snowdog.interfaces.IRepositoryView;
import pl.snowdog.model.Repository;
import pl.snowdog.presenter.RepositoryPresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepositoryActivity extends AppCompatActivity implements IRepositoryView {

    private List<Repository> mAllRepositories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        RepositoryPresenter repositoryPresenter = new RepositoryPresenter(this);
        repositoryPresenter.getRepositories(AndroidSchedulers.mainThread(), Schedulers.newThread());
    }

    @Override
    public void showRepositories(List<Repository> allRepositories) {
        mAllRepositories = allRepositories;
    }
}
