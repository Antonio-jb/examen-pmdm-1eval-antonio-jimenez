package com.examantonio.examenpmdm.fragmentos;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.examantonio.examenpmdm.R;

public class Segundo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_segundo, container, false);

      // SharedPreferences preferences = getContext().getSharedPreferences("Usuario", MODE_PRIVATE);
      // String nombre = preferences.getString("username", "anonimo");
      // preferences.getString(savedUsername);
      // TextView segundoTexto = findViewById(R.id.segundoTexto);
      // segundoTexto.setText(savedUsername));

        }
}

