package edu.sjsu.android.mortgagecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private SeekBar seekBar;
    private CheckBox checkBox;
    //private Button button;
    private TextView textResult;
    private TextView interestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        //button = (Button) findViewById(R.id.button);
        textResult = (TextView) findViewById(R.id.textView);
        interestText = (TextView) findViewById(R.id.annualInterest);


        //Interest Rate: SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int interest = 10;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                interest = progress;
                interestText.setText("" + interest  + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onClick(View view) {

        // if the user accidently click on the button before putting an input amount
        if (text.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number",
                    Toast.LENGTH_LONG).show();
            return;
        }

        //Amount Borrowed: EditText
        float borrowedAmount = Float.parseFloat(text.getText().toString());


        //Interest Rate:
        int annualInterest = seekBar.getProgress();
        float monthlyInterest = (float) (annualInterest)/ 1200;
        //textResult.setText("" + monthlyInterest);

        // Loan Term : Radio Group
        int numberMonth = 0;

        RadioButton years15Button = (RadioButton)
                findViewById(R.id.radioButton);
        RadioButton years20Button = (RadioButton)
                findViewById(R.id.radioButton1);
        RadioButton years30Button = (RadioButton)
                findViewById(R.id.radioButton2);

        if (years15Button.isChecked()) {
            numberMonth = 15 * 12;
        }
        else if (years20Button.isChecked()) {
            numberMonth = 20 * 12;
        }

        else {
            numberMonth = 30 * 12;
        }

        //Taxes and Insurance : CheckBox
        float tax = (float) 0.00;

        if (checkBox.isChecked()){
            tax = (float) (0.001 * borrowedAmount);
        }

        // Calculate monthly payment
        float  monthlyPayment = (float)0.00;

        if (monthlyInterest ==  0.00){
            monthlyPayment = borrowedAmount/numberMonth + tax;
        }
        else {
            monthlyPayment = (float) (borrowedAmount*(monthlyInterest/(1-1/Math.pow(1+monthlyInterest, numberMonth))) + tax);
        }

        textResult.setText(String.format("%.02f", monthlyPayment));
    }
}

