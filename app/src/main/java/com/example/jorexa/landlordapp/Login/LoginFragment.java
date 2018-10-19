package com.example.jorexa.landlordapp.Login;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.async.testAsyncRunner;
import com.example.jorexa.landlordapp.http.OkHttpHttpRequester;
import com.example.jorexa.landlordapp.models.TestUser;
import com.example.jorexa.landlordapp.parsers.GsonJsonParser;
import com.example.jorexa.landlordapp.parsers.base.JsonParser;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContracts.View {

    private LoginContracts.Presenter mPresenter;
    private OkHttpHttpRequester mHttpRequester;
    private JsonParser<TestUser> mJsonParser;

    @Inject
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadLogin();
    }

    @Override
    public void setPresenter(LoginContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void loadLogin() {

        final OkHttpClient client = new OkHttpClient();
        mHttpRequester = new OkHttpHttpRequester();
        String url = "http://echo.jsontest.com/key/value/one/two";
        //final Request request = new Request.Builder().get().url(url).build();

        mJsonParser = new GsonJsonParser<>(TestUser.class, TestUser[].class);

        //TestUser user = mJsonParser.fromJson("");

        testAsyncRunner.runInBackground(() -> {
            //Response response = null;
            try {
                String body = mHttpRequester.get(url);
                //TestUser user = new TestUser();
                TestUser user = mJsonParser.fromJson(body);
                //response = client.newCall(request).execute();
                //String body = response.body().string();

                int g = 5;
            } catch (IOException e) {
                e.printStackTrace();
            }

            int a = 2;
        });

        Toast.makeText(getContext(),
                "Test Login...",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Exception e) {

    }
}
