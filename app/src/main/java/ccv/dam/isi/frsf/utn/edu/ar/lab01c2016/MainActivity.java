package ccv.dam.isi.frsf.utn.edu.ar.lab01c2016;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static ccv.dam.isi.frsf.utn.edu.ar.lab01c2016.LogicaModelo.calcularInteres;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button) findViewById(R.id.button);
        final SeekBar  seekbar = (SeekBar) findViewById(R.id.seekBar);
        final double tasa1 = Double.parseDouble(this.getString(R.string.ceroA5000m30));
        final double tasa2 = Double.parseDouble(this.getString(R.string.ceroA5000MI30));
        final double tasa3 = Double.parseDouble(this.getString(R.string.cincomilA99999m30));
        final double tasa4 = Double.parseDouble(this.getString(R.string.cincomilA99999MI30));
        final double tasa5 = Double.parseDouble(this.getString(R.string.mas99999m30));
        final double tasa6 = Double.parseDouble(this.getString(R.string.mas99999MI30));



        boton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                if (((TextView) findViewById(R.id.importeValor)).getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Debe colocar un monto a invertir.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double tasa = 0;
                    TextView textoMonto = (TextView) findViewById(R.id.montoCalculado);
                    TextView mensajeExito = (TextView) findViewById(R.id.mensajeExito);
                    mensajeExito.setVisibility(View.VISIBLE);
                    double monto = Double.parseDouble(((TextView) findViewById(R.id.importeValor)).getText().toString());
                    int dias = ((SeekBar) findViewById(R.id.seekBar)).getProgress();
                    if (monto > 0) {
                        if (dias < 30 && monto <= 5000) tasa = tasa1;
                        else if (dias >= 30 && monto <= 5000) tasa = tasa2;
                        else if (dias < 30 && monto < 99999) tasa = tasa3;
                        else if (dias >= 30 && monto < 99999) tasa = tasa4;
                        else if (dias < 30 && monto >= 99999) tasa = tasa5;
                        else tasa = tasa6;
                        textoMonto.setText("$" + String.format("%.2f", calcularInteres(dias, monto, tasa) ));
                        textoMonto.setVisibility(View.VISIBLE);

                        mensajeExito.setText("Plazo fijo realizado. Recibira " + textoMonto.getText().toString() + " al vencimiento.");
                        mensajeExito.setTextColor(Color.GREEN);
                    } else {
                        mensajeExito.setText("Ingrese un monto mayor a $0");
                        mensajeExito.setTextColor(Color.RED);
                    }
                }
            }

            }  );


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                TextView textoSeekBar = (TextView) findViewById(R.id.textoSeekBar);
                textoSeekBar.setText(String.valueOf(progress));

            }
        });
    }


}
