package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private enum OPERATOR {PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAl}
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDot;
    private Button btnAdd;
    private Button btnMinus;
    private Button btnDivision;
    private Button btnMultiply;
    private Button btnClear;
    private Button btnEqual;
    private TextView txtCalculation;

    // Instance Variable
    private OPERATOR currentOperator;
    private double calculationResult;
    private String sign;
    private String currentNumber;
    private String stringNumberAtRight;
    private String stringNumberAtLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationResult = 0;
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnClear = findViewById(R.id.btnClear);
        btnEqual = findViewById(R.id.btnEqual);
        txtCalculation = findViewById(R.id.txtScreen);

    }

    public void getValue(View view) {

        switch (view.getId()){

            case R.id.btnAdd:
                operatorIsTapped(OPERATOR.PLUS);
                break;
            case R.id.btnMinus:
                operatorIsTapped(OPERATOR.SUBTRACT);
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                break;
            case R.id.btnDivision:
                operatorIsTapped(OPERATOR.DIVIDE);
                break;
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAl);
                break;
            case R.id.btnClear:
                clear();
                break;
            default:
                numberIsTapped(view.getTag().toString());


        }
    }

    private void numberIsTapped(String tappedNumber){

        currentNumber+=tappedNumber;
        txtCalculation.setText(currentNumber);
    }

    private void operatorIsTapped(OPERATOR tappedOperator){

        switch (tappedOperator){
            case PLUS:
                sign = "+";
                break;
            case SUBTRACT:
                sign = "-";
                break;
            case MULTIPLY:
                sign = "*";
                break;
            case DIVIDE:
                sign = "/";
                break;
            case EQUAl:
                sign = "=";
                break;
        }

        if (currentOperator != null){

            if (currentNumber != "") {

                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator){

                    case PLUS:
                        calculationResult = Double.parseDouble(stringNumberAtLeft) + Double.parseDouble(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResult = Double.parseDouble(stringNumberAtLeft) - Double.parseDouble(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Double.parseDouble(stringNumberAtLeft) * Double.parseDouble(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Double.parseDouble(stringNumberAtLeft) / Double.parseDouble(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationResult);
                if (tappedOperator == OPERATOR.EQUAl){
                    txtCalculation.setText(sign+"\n"+stringNumberAtLeft);
                }else {
                    txtCalculation.setText(stringNumberAtLeft + "\n" + sign + "\n");
                }

            }

        }else{

            stringNumberAtLeft = currentNumber;
            currentNumber = "";
            txtCalculation.setText(stringNumberAtLeft+"\n"+sign+"\n");
            sign = "";
        }
        if (currentOperator == OPERATOR.EQUAl){
            txtCalculation.setText(stringNumberAtLeft+"\n"+sign+"\n");
        }
        currentOperator = tappedOperator;


    }

    private void clear(){

        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        currentOperator = null;
        calculationResult = 0;
        currentNumber ="";
        txtCalculation.setText("0");

    }


}
