package com.bwaim.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int NB_QUESTIONS = 10;
    private EditText m_usernameEditText;

    /**
     * The send button listener
     */
    private View.OnClickListener sendOnClickListener = new View.OnClickListener() {

        /**
         * Callback for the click on the send button
         * @param view the button clicked
         */
        @Override
        public void onClick(View view) {

            if (isUsernameFilled()) {
                int nbRightAnswers = checkAnswers();
                displayResult(nbRightAnswers);

            } else {
                Toast.makeText(getApplicationContext(), R.string.usernameEmpty, Toast.LENGTH_SHORT).show();
            }

        }
    };

    /**
     * The reset button listener
     */
    private View.OnClickListener resetOnClickListener = new View.OnClickListener() {
        /**
         * Callback for the click on the reset button
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
        m_usernameEditText = findViewById(R.id.usernameEditText);
        Button sendButton = findViewById(R.id.sendButton);
        Button resetButton = findViewById(R.id.resetButton);

        // Define the callbacks
        sendButton.setOnClickListener(sendOnClickListener);
        resetButton.setOnClickListener(resetOnClickListener);
    }

    /**
     * Check if the username is filled or not
     *
     * @return true if the username is not empty
     */
    private boolean isUsernameFilled() {
        String username = m_usernameEditText.getText().toString();
        return !"".equals(username);
    }

    /**
     * Check the answers
     *
     * @return the number of right answers
     */
    private int checkAnswers() {
        int nbRightAnswers = 0;

        // Question 1
        if (checkAnswerCheckBox(1, new boolean[]{true, true, false, true})) {
            nbRightAnswers++;
        }

        // Question 2
        if (checkAnswerRadioButton(2,
                getResources().getIdentifier("q2c4", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        // Question 3
        if (checkAnswerCheckBox(3, new boolean[]{true, true, true, true})) {
            nbRightAnswers++;
        }

        // Question 4
        if (checkAnswerRadioButton(4,
                getResources().getIdentifier("q4c1", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        // Question 5
        if (checkAnswerRadioButton(5,
                getResources().getIdentifier("q5c2", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        // Question 6
        if (checkAnswerRadioButton(6,
                getResources().getIdentifier("q6c2", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        // Question 7
        if (checkAnswerRadioButton(7,
                getResources().getIdentifier("q7c3", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        // Question 8
        if (checkAnswerRadioButton(8,
                getResources().getIdentifier("q8c1", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        // Question 9
        if (checkAnswerRadioButton(9,
                getResources().getIdentifier("q9c1", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        // Question 10
        if (checkAnswerRadioButton(10,
                getResources().getIdentifier("q10c4", "id", getPackageName()))) {
            nbRightAnswers++;
        }

        return nbRightAnswers;
    }

    /**
     * Display the result message
     *
     * @param nbRightAnswers, the number of right answers
     */
    private void displayResult(int nbRightAnswers) {
        String name = m_usernameEditText.getText().toString();
        String message = getString(R.string.resultMessage, name, nbRightAnswers, NB_QUESTIONS);

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        // Get the view used by the message in the toast to center the text
        TextView view = toast.getView().findViewById(android.R.id.message);
        if (view != null) view.setGravity(Gravity.CENTER);
        toast.show();
    }

    /**
     * check if the answer of the question questionNumber is right
     *
     * @param questionNumber the number of the question
     * @param rightWrongTab  tab with the correct answer of the question
     * @return true if the answer is correct, else false
     */
    private boolean checkAnswerCheckBox(int questionNumber, boolean[] rightWrongTab) {
        boolean answerRight = true;

        // iterate on the choice while the answer is right
        for (int i = 1; i <= rightWrongTab.length && answerRight; ++i) {
            // get dynamically the view
            String resourceName = "q" + questionNumber + "c" + i;
            int id = getResources().getIdentifier(resourceName, "id", getPackageName());
            CheckBox cbx = findViewById(id);

            // check if the checkbox is on the right state
            answerRight = cbx.isChecked() == rightWrongTab[i - 1];
        }

        return answerRight;
    }

    /**
     * check if the answer of the question questionNumber is right
     *
     * @param questionNumber the number of the question
     * @param idRightAnswer  the View id of the right answer
     * @return true if the answer is correct, else false
     */
    private boolean checkAnswerRadioButton(int questionNumber, int idRightAnswer) {
        String radioGroupName = "q" + questionNumber;
        int radioGroupId = getResources().getIdentifier(radioGroupName, "id", getPackageName());
        RadioGroup radioGroup = findViewById(radioGroupId);

        return radioGroup.getCheckedRadioButtonId() == idRightAnswer;
    }

}
