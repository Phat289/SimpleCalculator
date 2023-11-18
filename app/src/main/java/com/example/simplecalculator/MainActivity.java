package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private TextView textViewResult;
        private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,  buttonMulti,
                 buttonDiv, buttonMinus, buttonC,  buttonEqual, buttonAdd;

        private StringBuilder operand;
        private double num1, num2;
        private String operator;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textViewResult = findViewById(R.id.textViewResult);
            button7 = findViewById(R.id.button7);
            button8 = findViewById(R.id.button8);
            button9 = findViewById(R.id.button9);
            buttonDiv = findViewById(R.id.buttonDiv);
            button4 = findViewById(R.id.button4);
            button5 = findViewById(R.id.button5);
            button6 = findViewById(R.id.button6);
            buttonMulti = findViewById(R.id.buttonMulti);
            button1 = findViewById(R.id.button1);
            button2 = findViewById(R.id.button2);
            button3 = findViewById(R.id.button3);
            buttonMinus = findViewById(R.id.buttonMinus);
            buttonC = findViewById(R.id.buttonC);
            button0 = findViewById(R.id.button0);
            buttonEqual = findViewById(R.id.buttonEqual);
            buttonAdd = findViewById(R.id.buttonAdd);

            button7.setOnClickListener(this);
            button8.setOnClickListener(this);
            button9.setOnClickListener(this);
            buttonDiv.setOnClickListener(this);
            button4.setOnClickListener(this);
            button5.setOnClickListener(this);
            button6.setOnClickListener(this);
            buttonMulti.setOnClickListener(this);
            button1.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            buttonMinus.setOnClickListener(this);
            buttonC.setOnClickListener(this);
            button0.setOnClickListener(this);
            buttonEqual.setOnClickListener(this);
            buttonAdd.setOnClickListener(this);

            operand = new StringBuilder();
            num1 = 0;
            num2 = 0;
            operator = "";
        }

        @Override
        public void onClick(View view) {
            int id = view.getId();

            if (id == R.id.button1) {
                appendOperand("1");
            } else if (id == R.id.button2) {
                appendOperand("2");
            } else if (id == R.id.button3) {
                appendOperand("3");
            } else if (id == R.id.button4) {
                appendOperand("4");
            } else if (id == R.id.button5) {
                appendOperand("5");
            } else if (id == R.id.button6) {
                appendOperand("6");
            } else if (id == R.id.button7) {
                appendOperand("7");
            } else if (id == R.id.button8) {
                appendOperand("8");
            } else if (id == R.id.button9) {
                appendOperand("9");
            } else if (id == R.id.buttonDiv) {
                setOperator("/");

            } else if (id == R.id.buttonMulti) {
                setOperator("*");

            } else if (id == R.id.buttonMinus) {
                setOperator("-");
            } else if (id == R.id.buttonC) {
                clear();
            } else if (id == R.id.button0) {
                appendOperand("0");
            } else if (id == R.id.buttonEqual) {
                calculateResult();
            } else if (id == R.id.buttonAdd) {
                setOperator("+");
            }
        }


        private void appendOperand(String digit) {
            operand.append(digit);
            String displayText = textViewResult.getText().toString() + digit;
            textViewResult.setText(displayText);
        }

        private void setOperator(String op) {
            operator = op;
            if (operand.length() > 0) {
                num1 = Double.parseDouble(operand.toString());
                String displayText = textViewResult.getText().toString() + operator;
                textViewResult.setText(displayText);
                operand.setLength(0); // Reset operand
            }
        }

        private void clear() {
            operand.setLength(0);
            num1 = 0;
            num2 = 0;
            operator = "";
            textViewResult.setText("");
        }

        private void calculateResult() {
            if (operand.length() > 0) {
                num2 = Double.parseDouble(operand.toString());

                double result = 0;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textViewResult.setText("Error");
                            return;
                        }
                        break;
                }


                textViewResult.setText(String.valueOf(result));
                operand.setLength(0); // Reset operand
                num1 = result;
            }
        }
    }
