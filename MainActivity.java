package com.example.zainulmustafa.creating_user_interface_in_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.button;
import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private Button clickMe;
    private EditText em;
    private EditText ps;
    private TextView dis;

    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //we deleted setContentView(R.layout.activity_main)
        //this above method tells us that this activity_main is our layout

        //creating a user interface in java
        RelativeLayout zainsLayout = new RelativeLayout(this);
        zainsLayout.setBackgroundColor(Color.GREEN);

        EditText email = new EditText(this);
        email.setId(1);
        email.setBackgroundColor(Color.GREEN);
        email.setTextColor(Color.RED);
        email.setHint("Email");

        EditText pass = new EditText(this);
        pass.setId(2);
        pass.setBackgroundColor(Color.GREEN);
        pass.setTextColor(Color.RED);
        pass.setHint("Password");

        Button redButton = new Button(this);
        redButton.setId(3);
        redButton.setText("Click Me");
        redButton.setTextColor(Color.GREEN);
        redButton.setBackgroundColor(Color.RED);

        TextView display = new TextView(this);
        display.setId(4);
        display.setText("Viewer");
        display.setTextSize(30);
        display.setTextColor(Color.GREEN);
        display.setBackgroundColor(Color.RED);

        //making layout parameter for widget rules
        RelativeLayout.LayoutParams emailAddress = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams password = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams displayDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //giving rules to position the widgets
        displayDetails.addRule(RelativeLayout.ABOVE, email.getId());
        displayDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        displayDetails.setMargins(0,0,0,50);
        // ^ set the display widget
        emailAddress.addRule(RelativeLayout.ABOVE, pass.getId());
        emailAddress.addRule(RelativeLayout.CENTER_HORIZONTAL);
        emailAddress.setMargins(0,0,0,50);
        // ^ set the email widget in the Relative layout ABOVE the password widget
        password.addRule(RelativeLayout.ABOVE, redButton.getId());
        password.addRule(RelativeLayout.CENTER_HORIZONTAL);
        password.setMargins(0,0,0,50);
        // ^ set the pass widget in the Relative layout ABOVE the redButton widget
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        // ^ set the redButton widget in the Relative layout

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());
        // ^ we are converting 200 device independent pixels (DIP); we also need the information about the current display
        //which DisplayMetrics will get us by using get method --> r.getDisplayMetrics()
        //type cast the whole thing to int because the method returns float value
        email.setWidth(px);
        pass.setWidth(px);
        display.setWidth(px);
        //above setWidth function will make widgets above responsive on all screen sizes

        //add these two widgets to our layout
        //adding rule for widget as the second parameter in the addView method
        zainsLayout.addView(display, displayDetails);
        zainsLayout.addView(email, emailAddress);
        zainsLayout.addView(pass, password);
        zainsLayout.addView(redButton, buttonDetails);

        //take this layout and display it as the main UI
        setContentView(zainsLayout);

        //initialize logic
        initialize();
    }

    private void initialize(){
        em = (EditText)findViewById(1);
        ps = (EditText)findViewById(2);
        clickMe = (Button)findViewById(3);
        dis = (TextView)findViewById(4);

        clickMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dis.setText(String.valueOf(num) +" "+ em.getText().toString() +" "+ ps.getText().toString());
                if(num%2 == 1){
                    dis.setBackgroundColor(Color.GREEN);
                    dis.setTextColor(Color.RED);
                }
                else if(num%2 == 0){
                    dis.setBackgroundColor(Color.RED);
                    dis.setTextColor(Color.GREEN);
                }
                num++;
            }
        });
    }
}
