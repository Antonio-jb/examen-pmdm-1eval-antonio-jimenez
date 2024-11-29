package com.examantonio.examenpmdm.manager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.examantonio.examenpmdm.fragmentos.Primero;
import com.examantonio.examenpmdm.fragmentos.Segundo;
import com.examantonio.examenpmdm.fragmentos.Tercero;

public class Paginador extends FragmentPagerAdapter {

    private final Context mContext;

    public Paginador(Context context, FragmentManager fm) {
        super (fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Primero();
            case 1:
                return new Segundo();
            case 2:
                return new Tercero();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}