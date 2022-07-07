package com.example.practica_clase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.practica_clase.databinding.ActivityAceptadoBinding;
import com.example.practica_clase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegistrar.setOnClickListener(view -> {
            String usuario = binding.txtNombre.getText().toString();


            String clave = binding.txtClave.getText().toString();
            String clave2= binding.txtClave2.getText().toString();
            Context context = MainActivity.this;
            if (binding.txtNombre.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Campo nombre vacio, llenar por favor",Toast.LENGTH_SHORT).show();
            }else if (binding.txtClave.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Campo clave vacio, llenar por favor",Toast.LENGTH_SHORT).show();
            }else if (binding.txtClave2.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Campo repetir clave vacio, llenar por favor",Toast.LENGTH_SHORT).show();
            }else
            if (clave.equals(clave2)){

                abrirActividaddetalle(usuario);
            }else{
                Toast.makeText(MainActivity.this,"Las claves no coinciden",Toast.LENGTH_SHORT).show();
                binding.txtClave2.setText("");
            }
        });

    }
    private void abrirActividaddetalle(String nom){
        Intent intents = new Intent(this,Aceptado.class);
        intents.putExtra("usuario",nom);
        startActivity(intents);
    }
}