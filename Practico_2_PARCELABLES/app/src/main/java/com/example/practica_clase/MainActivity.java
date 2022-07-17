package com.example.practica_clase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.practica_clase.databinding.ActivityAceptadoBinding;
import com.example.practica_clase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
static float valoracion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegistrar.setOnClickListener(view -> {
            String nombre = binding.txtNombre.getText().toString();
            String clave = binding.txtClave.getText().toString();
            String clave2= binding.txtClave2.getText().toString();
            Context context = MainActivity.this;
            if (nombre.isEmpty()){
                Toast.makeText(MainActivity.this,"Campo nombre vacio, llenar por favor",Toast.LENGTH_SHORT).show();
            }else if (clave.isEmpty()||clave.length()<5){
                Toast.makeText(MainActivity.this,"Campo clave vacio, llenar por favor, mayor a 5",Toast.LENGTH_SHORT).show();
            }else if (clave2.isEmpty()||clave2.length()<5){
                Toast.makeText(MainActivity.this,"Campo repetir clave vacio, llenar por favor, mayor a 5",Toast.LENGTH_SHORT).show();
            }else
                
            if (clave.equals(clave2)){
                int cont1 = clave.length();
                char[] conteo = clave.toCharArray();
                int cont=0;
                for(int i=0; i<conteo.length; i++){
                    if( (conteo[i] >=33 && conteo[i]<=47) || (conteo[i] >=58 && conteo[i]<=64) || (conteo[i] >=91 && conteo[i]<=96) || (conteo[i] >=123 && conteo[i]<=126) ){
                        cont++;
                    }
                }
                if (cont>=4 && cont1>=12){
                    valoracion=5;
                }else if(cont>=2 && cont1>=10){
                    valoracion=4;
                }else if(cont>=1 && cont1>=8) {
                    valoracion = 3;
                }else if(cont1>=8) {
                    valoracion = 2;
                }else{
                    valoracion=1;
                }
                abrirActividaddetalle(nombre,clave,valoracion);

            }else{
                Toast.makeText(MainActivity.this,"Las claves no coinciden",Toast.LENGTH_SHORT).show();
                binding.txtClave2.setText("");
            }



        });

    }
    private void abrirActividaddetalle(String nom,String clave,float valoracion){
        Intent intents = new Intent(this,Aceptado.class);
        Usuario usu = new Usuario(nom,clave,valoracion);
        intents.putExtra(Aceptado.USUARIO_KEY,usu);
        startActivity(intents);
    }
}