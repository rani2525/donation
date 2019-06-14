package com.example.donationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPickerDonation;
    private TextView amount ;
    private TextView donationTotal;
    private TextView total;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button buttonDonate;
    public String donationType;
    int donation_total = 0;

    //create an array list of object Donation
    ArrayList<Donation> DonationArrayList = new ArrayList<>();
    //declaring a new donation object which we will pass our id and amount into
    Donation d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        numberPickerDonation = findViewById(R.id.numberPickerDonation);
        amount = findViewById(R.id.amount);
        donationTotal = findViewById(R.id.donationTotal);
        total = findViewById(R.id.total);

        numberPickerDonation.setMinValue(0);
        numberPickerDonation.setMaxValue(100);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        Button buttonDonate = findViewById(R.id.buttonDonate);
        buttonDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onRadioButtonClicked(radioButton);


            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addDonation();
            }
        });
    }
    public void addDonation()
    {
        int donation = numberPickerDonation.getValue();
        String donationId = "Donation " + Integer.toString(DonationArrayList.size() + 1);


        d = new Donation(donationId, donationType, donation);

        if(donation != 0){

//use breakpoint to actually see whats inside and stops right there, really useful for debugging
            DonationArrayList.add(d);

            //if donation is not zero
            donation_total += donation;


            String donationTotalString = "$" + donation_total;
            donationTotal.setText(donationTotalString);



        }else {
            //if it is 0$
            //add a toast message to the user asking for the user to make donation greater than 0


        }
    }
    //inflate: takes the menu xml code and converting it into a view object

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(!DonationArrayList.isEmpty()) {
//saving our array list objects into this bundle
            Bundle b = new Bundle();
            b.putParcelableArrayList("myKey", DonationArrayList);
            Intent i = new Intent(this, ViewDonations.class);

            i.putExtras(b);

            startActivity(i);

        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Donate First", Toast.LENGTH_LONG);
            toast.show();
        }
//return statement must be outside of this if method
        return super.onOptionsItemSelected(item);
    }

    //the method muse be public, must return void and define a view as a parameter which will be only one as only one is checked
    public void onRadioButtonClicked(View view) {


        //Is the button clicked
        boolean checked = ((RadioButton)view).isChecked();


                   switch(view.getId()){
                       case R.id.radio_paypal :
                           if(checked)
                               donationType = "PayPal";
                               break;
                       case R.id.radio_direct :
                           if(checked)
                               donationType = "Direct";
                               break;



        }

    }
}
