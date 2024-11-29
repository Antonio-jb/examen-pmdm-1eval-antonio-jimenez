package com.examantonio.examenpmdm.fragmentos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.examantonio.examenpmdm.MainActivity;
import com.examantonio.examenpmdm.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Tercero extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tercero, container, false);


        Button button = view.findViewById(R.id.buttonAlert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });

        return view;

    }

    private void alertDialog() {
        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(getContext())
                .setIcon(R.drawable.logo)
                .setTitle("Antonio Jimenez")
                .setMessage("Hola, muy buenas profe.")
                .setPositiveButton("Aprobar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Aprobado.", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Reprobar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Reprobado.", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
    }
}
