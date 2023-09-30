package ro.andreeapopa.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult, tvHistory;
    private AppCompatButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine,
                            btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals, btnPoint, btnAC, btnDEL;
    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat decimalFormat = new DecimalFormat("######.######");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiateElements();

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator) {
                    if (status == "multiplication") multiply();
                    else if (status == "division") divide();
                    else if (status == "subtraction") minus();
                    else plus();
                }
                status = "sum";
                operator = false;
                number = null;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator) {
                    if (status == "sum") plus();
                    else if (status == "multiplication") multiply();
                    else if (status == "division") divide();
                    else minus();
                }
                status = "subtraction";
                operator = false;
                number = null;
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator) {
                    if (status == "sum") plus();
                    else if (status == "subtraction") minus();
                    else if (status == "division") divide();
                    else multiply();
                }
                status = "multiplication";
                operator = false;
                number = null;
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator) {
                    if (status == "sum") plus();
                    else if (status == "subtraction") minus();
                    else if (status == "multiplication") multiply();
                    else divide();
                }
                status = "division";
                operator = false;
                number = null;
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator)
                    if (status == "sum") plus();
                    else if (status == "subtraction") minus();
                    else if (status == "multiplication") multiply();
                    else if (status == "division") divide();
                    else firstNumber = Double.parseDouble(tvResult.getText().toString());
                    
                operator = false;
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = null;
                status = null;
                tvResult.setText("0");
                tvHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
            }
        });
        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = number.substring(0, number.length()-1);
                tvResult.setText(number);
            }
        });
    }

    private void instantiateElements() {
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnEquals = findViewById(R.id.btnEquals);
        btnPoint = findViewById(R.id.btnPoint);
        btnAC = findViewById(R.id.btnAC);
        btnDEL = findViewById(R.id.btnDEL);

        tvResult = findViewById(R.id.tvResult);
        tvHistory = findViewById(R.id.tvHistory);
    }

    private void numberClick(String number) {
        if (this.number == null) this.number = number;
        else this.number += number;

        tvResult.setText(this.number);
        operator = true;
    }

    private void plus() {
        lastNumber = Double.parseDouble(tvResult.getText().toString());
        firstNumber += lastNumber;

        tvResult.setText(decimalFormat.format(firstNumber));
    }

    private void minus() {
        if (firstNumber == 0) firstNumber = Double.parseDouble(tvResult.getText().toString());
        else {
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber -= lastNumber;
        }
        tvResult.setText(decimalFormat.format(firstNumber));
    }

    private void multiply() {
        if (firstNumber == 0) {
            firstNumber = 1;
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber *= lastNumber;
        } else {
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber *= lastNumber;
        }
        tvResult.setText(decimalFormat.format(firstNumber));
    }

    public void divide() {
        if (firstNumber == 0) {
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber = lastNumber / 1;
        } else {
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber /= lastNumber;
        }
        tvResult.setText(decimalFormat.format(firstNumber));
    }
}