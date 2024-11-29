package com.examantonio.examenpmdm;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.examantonio.examenpmdm.manager.Paginador;
import com.examantonio.examenpmdm.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.favButton) {

            ViewPager viewPager = binding.viewPager;
            int currentItem = viewPager.getCurrentItem();
            Paginador paginadorFragmentos = (Paginador) viewPager.getAdapter();
            Fragment currentFragment = getSupportFragmentManager().getFragments().get(currentItem);

            String fragmentName = "";

            if (currentFragment != null) {

                fragmentName = currentFragment.getClass().getSimpleName();
            } else {
                fragmentName = "Fragmento no disponible";
            }


            Toast.makeText(this, "¡Estás viendo el fragmento: " + fragmentName + "!", Toast.LENGTH_SHORT).show();

        }

        if (id == R.id.fragmentosButton) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (id == R.id.myCodeButton) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/Antonio-jb"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public class Alerta {

        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                .setIcon(R.drawable.logo)
                .setTitle("Antonio Jimenez")
                .setMessage("Hola, muy buenas profe.")
                .setPositiveButton("Aprobar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Aprobado.", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Reprobar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Reprobado.", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
    }
}