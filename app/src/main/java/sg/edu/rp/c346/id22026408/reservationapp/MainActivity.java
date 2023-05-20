package sg.edu.rp.c346.id22026408.reservationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText, mobileEditText, groupSizeEditText;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private RadioGroup tableRadioGroup;
    private Button confirmButton;
    private TextView messageTextView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        groupSizeEditText = findViewById(R.id.groupSizeEditText);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        tableRadioGroup = findViewById(R.id.tableRadioGroup);
        confirmButton = findViewById(R.id.confirmButton);
        messageTextView = findViewById(R.id.messageTextView);
        scrollView = findViewById(R.id.scrollView);

        int defaultYear = 2020;
        int defaultMonth = 5;
        int defaultDay = 1;
        datePicker.init(defaultYear, defaultMonth, defaultDay, null);

        int defaultHour = 19;
        int defaultMinute = 30;
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(defaultHour);
        timePicker.setCurrentMinute(defaultMinute);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmReservation();
            }
        });
    }

    private void confirmReservation() {
        // Get the input values
        String name = nameEditText.getText().toString();
        String mobile = mobileEditText.getText().toString();
        String groupSize = groupSizeEditText.getText().toString();

        int year = datePicker.getYear();
        int month = datePicker.getMonth() + 1; // Add 1 as months are zero-based
        int day = datePicker.getDayOfMonth();

        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        RadioButton selectedRadioButton = findViewById(tableRadioGroup.getCheckedRadioButtonId());
        String tableSelection = selectedRadioButton.getText().toString();

        String reservationMessage = "Reservation Details:\n\n"
                + "Name: " + name + "\n"
                + "Mobile: " + mobile + "\n"
                + "Group Size: " + groupSize + "\n"
                + "Date: " + day + "/" + month + "/" + year + "\n"
                + "Time: " + hour + ":" + minute + "\n"
                + "Table Selection: " + tableSelection;

        messageTextView.setText(reservationMessage);

        nameEditText.setText("");
        mobileEditText.setText("");
        groupSizeEditText.setText("");

        datePicker.updateDate(2020, 5, 1);
        timePicker.setCurrentHour(19);
        timePicker.setCurrentMinute(30);

        Toast.makeText(this, "Reservation confirmed!", Toast.LENGTH_SHORT).show();


