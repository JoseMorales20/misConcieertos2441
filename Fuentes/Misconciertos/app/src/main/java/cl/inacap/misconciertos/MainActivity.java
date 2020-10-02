package cl.inacap.misconciertos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cl.inacap.misconciertos.dao.EventosDAO;
import cl.inacap.misconciertos.dao.EventosDAOLista;
import cl.inacap.misconciertos.dto.Evento;

public class MainActivity extends AppCompatActivity {
    private EditText nombreTxt;
    TextView fechaTxt;
    private Spinner genero;
    private EditText valorTxt;
    private Spinner clf;
    private Button registrarBtn;
    DatePickerDialog.OnDateSetListener setListener;
    private List<Evento> eventos;
    private EventosDAO eventosDAO = EventosDAOLista.getInstance();
    private ListView visorlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nombreTxt = findViewById(R.id.nombreTxt);
        this.genero = findViewById(R.id.genero);
        this.valorTxt = findViewById(R.id.valorTxt);
        this.clf = findViewById(R.id.clf);
        this.registrarBtn = findViewById(R.id.registrarBtn);
        fechaTxt = findViewById(R.id.fechaTxt);
        eventos = eventosDAO.getAll();
        visorlv = findViewById(R.id.visorlv);






        String[] opciones = {"Rock","Jazz","Pop","Reguetoon","Salsa","Metal"};
        final String[] opcines2 = {"1","2","3","4","5","6","7"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones);
        genero.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opcines2);
        clf.setAdapter(adapter1);


        final Calendar calendar = Calendar.getInstance();
        final int dia = calendar.get(Calendar.DAY_OF_MONTH);
        final int mes = calendar.get(Calendar.MONTH);
        final int anio = calendar.get(Calendar.YEAR);



        fechaTxt.setOnClickListener(new View.OnClickListener() {
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
                fechaTxt.setText(fecha);

            }
        };


       this.registrarBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               List<String> errores = new ArrayList<>();





           }
       });


    }
}