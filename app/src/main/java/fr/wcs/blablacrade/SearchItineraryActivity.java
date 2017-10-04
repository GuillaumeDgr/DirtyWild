package fr.wcs.blablacrade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText editTextDepart = (EditText) findViewById(R.id.editTextDepart);
        final EditText editTextDest = (EditText) findViewById(R.id.editTextDest);
        final EditText editTextDate = (EditText) findViewById(R.id.editTextDate);
        Button send = (Button) findViewById(R.id.send);

        // Button Search
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String editTextDepartContent = editTextDepart.getText().toString();
            String editTextDestContent = editTextDest.getText().toString();
            String editTextDateContent = editTextDate.getText().toString();

            if (editTextDepartContent.isEmpty() || editTextDestContent.isEmpty()) {
                Toast error = Toast.makeText(getApplicationContext(), getResources().getString(R.string.form_error),
                        Toast.LENGTH_SHORT);
                error.show();
            } else {
                Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                SearchRequestModel searchRequest = new SearchRequestModel(editTextDepartContent, editTextDestContent, editTextDateContent);
                intent.putExtra("searchRequest", searchRequest);
                SearchItineraryActivity.this.startActivity(intent);
            }
            }
        });

        // Date Picker
        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view,int year,int month,int day){
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                UpdateLabel(editTextDate, calendar);
            }};
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,
                    dateListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    private void UpdateLabel(EditText editText, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        editText.setText(sdf.format(myCalendar.getTime()));
    }
}
