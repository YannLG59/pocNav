package com.example.pocnavigation.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pocnavigation.R;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ThirdFragment extends Fragment {

    private Unbinder unbinder;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.third_fragment, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.goMainButton)
    void onGoMainClick() {
        MainFragment mainFragment = (MainFragment) getActivity().getSupportFragmentManager().findFragmentByTag("MainFragment");
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(mainFragment);
        fragmentTransaction.attach(mainFragment);
        fragmentTransaction.commit();
    }


    @OnClick(R.id.goSecondButton)
    void onGoSecondClick() {
        getActivity().onBackPressed();
    }
}
