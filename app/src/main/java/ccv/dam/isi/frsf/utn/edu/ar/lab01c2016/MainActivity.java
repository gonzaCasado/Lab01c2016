package ccv.dam.isi.frsf.utn.edu.ar.lab01c2016;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonn = (Button) findViewById(R.id.button);


        botonn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acciones a realizar

                }
            });



    }


}
