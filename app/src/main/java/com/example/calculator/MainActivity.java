package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txtResult;
    Button btnAC, btnDel,btnDot, btnEqual, btnMinus, btnPlus, btnMultiply, btnDivide, btnPercent;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);
        btnAC = findViewById(R.id.btnAC);btnAC.setOnClickListener(this);
        btnDel= findViewById(R.id.btnDel);btnDel.setOnClickListener(this);
        btnDot= findViewById(R.id.btnDot);btnDot.setOnClickListener(this);
        btnEqual= findViewById(R.id.btnEqual);btnEqual.setOnClickListener(this);
        btnMinus= findViewById(R.id.btnMinus);btnMinus.setOnClickListener(this);
        btnPlus= findViewById(R.id.btnPlus);btnPlus.setOnClickListener(this);
        btnMultiply= findViewById(R.id.btnMultiply);btnMultiply.setOnClickListener(this);
        btnDivide= findViewById(R.id.btnDivide);btnDivide.setOnClickListener(this);
        btnPercent= findViewById(R.id.btnPercent);btnPercent.setOnClickListener(this);

        btn1 = findViewById(R.id.btn1);btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);btn9.setOnClickListener(this);
        btn0 = findViewById(R.id.btn0);btn0.setOnClickListener(this);


    }

    public enum STATE {
        FIRST_OP, RESET_SECOND_OP, SECOND_OP;
    }

    STATE state = STATE.FIRST_OP;
    double first_op = 0, second_op = 0;
    String operator = "";

    @Override
    public void onClick(View v) {


        switch (state){
            case FIRST_OP:
                //Bấm AC
                if(v.getId() == R.id.btnAC){
                    first_op = 0;
                    second_op = 0;
                    operator = "";
                    txtResult.setText("");
                    state = STATE.FIRST_OP;
                }
                //Bấm số
                if(v.getId() == R.id.btn0 || v.getId() == R.id.btn1
                        || v.getId() == R.id.btn2 || v.getId() == R.id.btn3
                        || v.getId() == R.id.btn4 || v.getId() == R.id.btn5
                        || v.getId() == R.id.btn6 || v.getId() == R.id.btn7
                        || v.getId() == R.id.btn8 || v.getId() == R.id.btn9){
                    String displayNumber = ((Button)v).getText().toString();
                    if(txtResult.getText().toString().equals("0") == true){
                        txtResult.setText(displayNumber);
                    }else {
                        txtResult.setText(txtResult.getText() + displayNumber);
                    }
                }


                //Bấm .
                if(v.getId() == R.id.btnDot){
                    if(txtResult.getText().toString().equals("0") == true){
                        txtResult.setText("0.");
                    }else {
                        txtResult.setText(txtResult.getText()+".");
                    }
                }
                //Bấm DEL
                if(v.getId() == R.id.btnDel) {
                    if (txtResult.getText().toString().length() > 1) {
                        txtResult.setText(txtResult.getText().toString().substring(0, txtResult.getText().toString().length() - 1));
                    } else if (txtResult.getText().toString().length() <= 1) {
                        txtResult.setText("0");
                    }
                }

                //Bấm +
                if(v.getId() == R.id.btnPlus){
                    first_op = Double.parseDouble(txtResult.getText().toString());
                    operator = "ADD";
                    state = STATE.RESET_SECOND_OP;
                }
                //Bấm -
                if(v.getId() == R.id.btnMinus){
                    first_op = Double.parseDouble(txtResult.getText().toString());
                    operator = "MINUS";
                    state = STATE.RESET_SECOND_OP;
                }
                //Bấm x
                if(v.getId() == R.id.btnMultiply){
                    first_op = Double.parseDouble(txtResult.getText().toString());
                    operator = "MULTI";
                    state = STATE.RESET_SECOND_OP;
                }
                //Bấm /
                if(v.getId() == R.id.btnDivide){
                    first_op = Double.parseDouble(txtResult.getText().toString());
                    operator = "DIVIDE";
                    state = STATE.RESET_SECOND_OP;
                }
                //Bấm %
                if(v.getId() == R.id.btnPercent){
                    first_op = Double.parseDouble(txtResult.getText().toString());
                    first_op /= 100;
                    txtResult.setText(first_op + "");
                }


                break;

            case RESET_SECOND_OP:
                //Bấm AC
                if(v.getId() == R.id.btnAC){
                    first_op = 0;
                    second_op = 0;
                    operator = "";
                    txtResult.setText("");
                    state = STATE.FIRST_OP;
                }
                //Bấm số
                if(v.getId() == R.id.btn0 || v.getId() == R.id.btn1
                        || v.getId() == R.id.btn2 || v.getId() == R.id.btn3
                        || v.getId() == R.id.btn4 || v.getId() == R.id.btn5
                        || v.getId() == R.id.btn6 || v.getId() == R.id.btn7
                        || v.getId() == R.id.btn8 || v.getId() == R.id.btn9){
                    String displayNumber = ((Button)v).getText().toString();
                    txtResult.setText(displayNumber);
                    state = STATE.SECOND_OP;
                }
                //Bấm DEL
                if(v.getId() == R.id.btnDel) {
                    if (txtResult.getText().toString().length() > 1) {
                        txtResult.setText(txtResult.getText().toString().substring(0, txtResult.getText().toString().length() - 1));
                    } else if (txtResult.getText().toString().length() <= 1) {
                        txtResult.setText("0");
                    }
                }
                //Bấm %
                if(v.getId() == R.id.btnPercent){
                    first_op = Double.parseDouble(txtResult.getText().toString());
                    first_op /= 100;
                    txtResult.setText(first_op + "");
                    state = STATE.FIRST_OP;
                }
                break;


            case SECOND_OP:
                //Bấm AC
                if(v.getId() == R.id.btnAC){
                    first_op = 0;
                    second_op = 0;
                    operator = "";
                    txtResult.setText("");
                    state = STATE.FIRST_OP;
                }
                //Bấm DEL
                if(v.getId() == R.id.btnDel) {
                    if (txtResult.getText().toString().length() > 1) {
                        txtResult.setText(txtResult.getText().toString().substring(0, txtResult.getText().toString().length() - 1));
                    } else if (txtResult.getText().toString().length() <= 1) {
                        txtResult.setText("0");
                    }
                }
                //Bấm =
                if(v.getId() == R.id.btnEqual){
                    if(operator == "ADD") {
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op += second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MINUS"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op -= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MULTI"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op *= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "DIVIDE"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op /= second_op;
                        txtResult.setText(first_op + "");
                    }
                    state = STATE.FIRST_OP;
                }
                //Bấm số
                if(v.getId() == R.id.btn0 || v.getId() == R.id.btn1
                        || v.getId() == R.id.btn2 || v.getId() == R.id.btn3
                        || v.getId() == R.id.btn4 || v.getId() == R.id.btn5
                        || v.getId() == R.id.btn6 || v.getId() == R.id.btn7
                        || v.getId() == R.id.btn8 || v.getId() == R.id.btn9){
                    String displayNumber = ((Button)v).getText().toString();
                    txtResult.setText(txtResult.getText() + displayNumber);
                }
                //Bấm +
                if(v.getId() == R.id.btnPlus){
                    if(operator == "ADD") {
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op += second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MINUS"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op -= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MULTI"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op *= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "DIVIDE"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op /= second_op;
                        txtResult.setText(first_op + "");
                    }
                    operator = "ADD";
                    state = STATE.RESET_SECOND_OP;
                }

                //Bấm -
                if(v.getId() == R.id.btnMinus){
                    if(operator == "ADD") {
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op += second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MINUS"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op -= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MULTI"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op *= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "DIVIDE"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op /= second_op;
                        txtResult.setText(first_op + "");
                    }
                    operator = "MINUS";
                    state = STATE.RESET_SECOND_OP;
                }
                //Bấm x
                if(v.getId() == R.id.btnMultiply){
                    if(operator == "ADD") {
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op += second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MINUS"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op -= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MULTI"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op *= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "DIVIDE"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op /= second_op;
                        txtResult.setText(first_op + "");
                    }
                    operator = "MULTI";
                    state = STATE.RESET_SECOND_OP;
                }

                //Bấm /
                if(v.getId() == R.id.btnDivide){
                    if(operator == "ADD") {
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op += second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MINUS"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op -= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "MULTI"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op *= second_op;
                        txtResult.setText(first_op + "");
                    }
                    if(operator == "DIVIDE"){
                        second_op = Double.parseDouble(txtResult.getText().toString());
                        first_op /= second_op;
                        txtResult.setText(first_op + "");
                    }
                    operator = "DIVIDE";
                    state = STATE.RESET_SECOND_OP;
                }

                //Bấm .
                if(v.getId() == R.id.btnDot){
                    if(txtResult.getText().toString().equals("0") == true){
                        txtResult.setText("0.");
                    }else {
                        txtResult.setText(txtResult.getText()+".");
                    }
                }
                break;

        }


    }
}
