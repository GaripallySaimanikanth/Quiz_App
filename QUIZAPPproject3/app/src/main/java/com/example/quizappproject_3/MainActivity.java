package com.example.quizappproject_3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private ScrollView scrollView;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private RadioButton radioButtonquestion1;
    private RadioButton radioButtonquestion2;
    private RadioButton radioButtonquestion3;
    private RadioButton radioButtonquestion4;
    private RadioButton radioButtonquestion5;
    private CheckBox checkQ7Choice1;
    private CheckBox checkQ7Choice2;
    private CheckBox checkQ7Choice3;
    private CheckBox checkQ7Choice4;
    private EditText editTextquestion6;
    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        radioButtonquestion1 = (RadioButton) findViewById(R.id.radioq1ans);
        radioButtonquestion2= (RadioButton) findViewById(R.id.radioq4ans);
        radioButtonquestion3 = (RadioButton) findViewById(R.id.radioq4ans);
        radioButtonquestion4 = (RadioButton) findViewById(R.id.radioq4ans);
        radioButtonquestion5 = (RadioButton) findViewById(R.id.radioq4ans);
        editTextquestion6 = (EditText) findViewById(R.id.edit_text_ans6);
        checkQ7Choice2 = (CheckBox) findViewById(R.id.check_q7_ans1);
        checkQ7Choice3 = (CheckBox) findViewById(R.id.check_q7_ans2);
        checkQ7Choice1 = (CheckBox) findViewById(R.id.check_q7_wrng1);
        checkQ7Choice4 = (CheckBox) findViewById(R.id.check_q7_wrng2);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);
    }

    public void submit(View v) {
        String answerSix = getResources().getString(R.string.answer6);
        String wrongAnswers = "Check :";
        if (radioButtonquestion1.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q1\n";
        }
        if (radioButtonquestion2.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q2\n";
        }
        if (radioButtonquestion3.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q3\n";
        }

        if (radioButtonquestion4.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q4\n";
        }

        if (radioButtonquestion5.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q5\n";
        }

        if (answerSix.equals(editTextquestion6.getText().toString())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q6\n";
        }

        if (!(checkQ7Choice1.isChecked()) && checkQ7Choice2.isChecked() && checkQ7Choice3.isChecked() && !(checkQ7Choice4.isChecked())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q7\n";
        }
        if (correctAnswers == 7) {
            Toast.makeText(this, "Congrats, All Answers Correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + correctAnswers + " /7\n" + wrongAnswers, Toast.LENGTH_LONG).show();
        }

        reset(findViewById(R.id.reset));
    }

    public void reset(View v) {
        correctAnswers = 0;
        editTextquestion6.getText().clear();
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();
        radioGroup5.clearCheck();
        if (checkQ7Choice1.isChecked()) {
            checkQ7Choice1.toggle();
        }
        if (checkQ7Choice2.isChecked()) {
            checkQ7Choice2.toggle();
        }
        if (checkQ7Choice3.isChecked()) {
            checkQ7Choice3.toggle();
        }
        if (checkQ7Choice4.isChecked()) {
            checkQ7Choice4.toggle();
        }
        scrollView.fullScroll(ScrollView.FOCUS_UP);
    }
}