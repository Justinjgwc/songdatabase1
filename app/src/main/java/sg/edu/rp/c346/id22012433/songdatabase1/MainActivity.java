package sg.edu.rp.c346.id22012433.songdatabase1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShowList;
    RadioGroup radiog;
    RadioButton rad1;
    RadioButton rad2;
    RadioButton rad3;
    RadioButton rad4;
    RadioButton rad5;
    EditText songt;
    EditText singer;
    EditText year;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnInsert = findViewById(R.id.insert);
        btnShowList = findViewById(R.id.showl);
        listView = findViewById(R.id.listView);
        radiog = findViewById(R.id.radiog);
        rad1 = findViewById(R.id.radioButton);
        rad2 = findViewById(R.id.radioButton2);
        rad3 = findViewById(R.id.radioButton3);
        rad4 = findViewById(R.id.radioButton4);
        rad5 = findViewById(R.id.radioButton5);
        songt = findViewById(R.id.songint);
        singer = findViewById(R.id.singerint);
        year = findViewById(R.id.yearint);

        DBHelper db = new DBHelper(MainActivity.this);
        ArrayList<String> taskList = db.getsong();
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listView.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                if (radiog.getCheckedRadioButtonId() == R.id.radioButton) {
                    db.insertSong(songt.getText().toString(), singer.getText().toString(), Integer.parseInt(year.getText().toString()), 1);
                } else if (radiog.getCheckedRadioButtonId() == R.id.radioButton) {
                    db.insertSong(songt.getText().toString(), singer.getText().toString(), Integer.parseInt(year.getText().toString()), 2);
                } else if (radiog.getCheckedRadioButtonId() == R.id.radioButton) {
                    db.insertSong(songt.getText().toString(), singer.getText().toString(), Integer.parseInt(year.getText().toString()), 3);
                } else if (radiog.getCheckedRadioButtonId() == R.id.radioButton) {
                    db.insertSong(songt.getText().toString(), singer.getText().toString(), Integer.parseInt(year.getText().toString()), 4);
                } else if (radiog.getCheckedRadioButtonId() == R.id.radioButton) {
                    db.insertSong(songt.getText().toString(), singer.getText().toString(), Integer.parseInt(year.getText().toString()), 5);
                }
            }
        });
    }

}

