package com.mateussantana.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 3;

    Context ctx;

    TextView txt = (TextView) new TextView(ctx);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
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
            return;
        }
        quantity = quantity - 1;
        displayQuantiy(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity, 5);
        String sumary = createOrderSumary("Kaptain Kunal", quantity, price, "Thank you!");
        displayMessage(sumary);
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
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, int pricePerCup) {
        return quantity * pricePerCup;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * @param clientName
     * @param quantity
     * @param total
     * @param message
     */
    private String createOrderSumary(String clientName, int quantity, int total, String message) {
        String sumary = "";
        sumary += "Name: " + clientName + "\n";
        sumary += "Quantity: " + quantity + "\n";
        sumary += "Total: " + total + "\n";
        sumary += message;
        return sumary;
    }
    View textView = (View) findViewById(R.id.title);
    textView. setVisibility(View.GONE);
    final Button btn2 = (Button) findViewById(R.id.btnDate2);
}