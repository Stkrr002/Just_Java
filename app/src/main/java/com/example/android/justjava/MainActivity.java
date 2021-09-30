package com.example.android.justjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 1;
    String s = "thank you";



    @SuppressLint("SetTextI18n")
    public void inc(View view) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        if(quantity<100)
        {quantity += 1;
        quantityTextView.setText("" + quantity);}
        else
            Toast.makeText(this, "cannot order more that 100_cups", Toast.LENGTH_SHORT).show();

    }

    public void dec(View view) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        if(quantity>1)
        {quantity -= 1;
        quantityTextView.setText("" + quantity);}
        else
            Toast.makeText(this, "cannot order less that 1_cup", Toast.LENGTH_SHORT).show();

    }
    public void reciept(View view)
    {
        EditText email= (EditText) findViewById(R.id.email);
        String e=email.getText().toString();
        String ee[]={e};
        String subject="*SUNBUCKS CAFETARIA*";
        EditText Ename= (EditText) findViewById(R.id.name);
        String name=Ename.getText().toString();
        name+="\n"+"Amount: "+net+"\nQuantity: "+quantity+"\nThank You!";
        composeEmail(ee,subject,name);
    }
    public void composeEmail(String[] addresses, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT , text);
      //  intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void SubmitOrder(View view) {



        displayPrice(quantity * 2, s);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")


    /**
     * This method displays the given price on the screen.
     */
int net=0;
    private void displayPrice(int number, String ss) {


        CheckBox ch = (CheckBox) findViewById(R.id.topping);
        if(ch.isChecked())
            number+=(quantity*1);
        net=number;
        EditText Ename= (EditText) findViewById(R.id.name);
        String name=Ename.getText().toString();


        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        if(quantity<=0)
            priceTextView.setText("kindly order at least one cup"+"\n"+" "+ss);
        else {
            if (ch.isChecked())
                priceTextView.setText("Name : " + name + "\nQuantity : " + quantity + "\nAmount to pay : ₹" + number + "\n" + "Cream added" + " \n" + ss);
            else
                priceTextView.setText("Name : " + name + "\nQuantity : " + quantity + "\nAmount to pay : ₹" + number + "\n" + ss);
        }



    }

};
