package cl.inacap.misconciertos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText art;
    TextView tx_fecha;
    private Spinner genero;
    private EditText valorTxt;
    private Spinner clf;
    private Button registrarBtn;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.art = findViewById(R.id.art);
        this.genero = findViewById(R.id.genero);
        this.valorTxt = findViewById(R.id.valorTxt);
        this.clf = findViewById(R.id.clf);
        this.registrarBtn = findViewById(R.id.registrarBtn);
        tx_fecha = findViewById(R.id.tx_fecha);

        String[] opciones = {"Rock","Jazz","Pop","Requetoon","Salsa","Metal"};
        String[] opciones2 = {"1","2","2","3","4","5","6","7"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones);
        genero.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones2);
        clf.setAdapter(adapter);


        Calendar calendar = Calendar.getInstance();
        final int dia = calendar.get(Calendar.DAY_OF_MONTH);
        final int mes = calendar.get(Calendar.MONTH);
        final int anio = calendar.get(Calendar.YEAR);

        tx_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,dia,mes,anio);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker View, int dia, int mes, int anio) {
                mes = mes+1;
                String fecha = dia+"/"+ mes+"/"+anio;
                tx_fecha.setText(fecha);

            }
        };

       this.registrarBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               List<String> errores = new ArrayList<>();
               String valorAp = valorTxt.getText().toString().trim();
               int valor = 0;
               try {
                   valor = Integer.parseInt(valorAp);
                   if (valor > 0){
                       throw new NumberFormatException();
                   }

               }catch (NumberFormatException Ex){
                   errores.add("el valor debe ser mayor que 0");
               }
           }
       });

    }
}