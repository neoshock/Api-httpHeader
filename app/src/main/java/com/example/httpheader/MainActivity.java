package com.example.httpheader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVerListado = findViewById(R.id.btnVerListado);
        btnVerListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitRequest();
            }
        });
    }

    private void retrofitRequest(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://covid-19-data.p.rapidapi.com/help/").
                addConverterFactory(GsonConverterFactory.create()).build();
        ApiCovid service = retrofit.create(ApiCovid.class);
        Call<List<Pais>> callData = service.getPais();

        TextView listadoPaises = findViewById(R.id.listCountries);

        callData.enqueue(new Callback<List<Pais>>() {
            @Override
            public void onResponse(Call<List<Pais>> call, Response<List<Pais>> response) {
                List<Pais> paises = response.body();
                String responseCountries = "";
                for (Pais pais : paises){
                    responseCountries += String.format("Nombre: '%1$s' \n CodigoZip1: '%2$s' \n " +
                            "CodigoZip2: '%3$s' \n Latitud: '%4$s' \n Logintud: '%5$s' \n\n",
                            pais.getName(), pais.getAlpha2code(), pais.getAlpha3code(),
                            Double.toString(pais.getLatitude()), Double.toString(pais.getLongitude()));
                }
                listadoPaises.setText(responseCountries);
            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Hubo un error", Toast.LENGTH_LONG).show();
            }
        });
    }
}