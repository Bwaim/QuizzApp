package com.bwaim.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    Button sendButton;
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        /**
         * Callback for the send button
         * @param view the button clicked
         */
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To prevent the Keyboard to appear when the application is launched
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Get all the needed views
        usernameEditText = findViewById(R.id.usernameEditText);
        sendButton = findViewById(R.id.sendButton);

        // Define the callbacks
        sendButton.setOnClickListener(onClickListener);
    }

}
