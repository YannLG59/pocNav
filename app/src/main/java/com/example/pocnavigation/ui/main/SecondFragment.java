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

public class SecondFragment extends Fragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment, container, false);
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

    @OnClick(R.id.goThirdButton)
    void onGoThirdClick() {
        Fragment moveFrag = new ThirdFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, moveFrag, "ThirdFragment")
                .addToBackStack("ThirdFragment")
                .commit();
    }
}
