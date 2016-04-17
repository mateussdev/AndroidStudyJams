package com.mateussantana.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffes", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantiy(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffes", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantiy(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.whipped_cream_checkbox)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.whipped_cream_checkbox)).isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String name = ((EditText) findViewById(R.id.name_edit_text)).getText().toString();
        String priceMessage = createOrderSumary(name, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantiy(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream check is coffee with whippedCream
     * @param addChocolate    check is coffee with chocolate
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param name            of custumer
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate    is whether or not the user wants whipped cream topping
     * @param price           of the order
     * @return text summary
     */
    private String createOrderSumary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "";
        priceMessage += "Name: " + name + "\n";
        priceMessage += "Quantity: " + quantity + "\n";
        priceMessage += "Add whipped cream ? " + addWhippedCream + "\n";
        priceMessage += "Add chocolate ? " + addChocolate + "\n";
        priceMessage += "Total: " + price + "\n";
        priceMessage += "Thank you!";
        return priceMessage;
    }
}