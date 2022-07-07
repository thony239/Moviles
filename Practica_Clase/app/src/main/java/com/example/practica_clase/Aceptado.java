package com.example.practica_clase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.practica_clase.databinding.ActivityAceptadoBinding;

public class Aceptado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAceptadoBinding binding = ActivityAceptadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");

        binding.txtNombre.setText(usuario);
    }
}