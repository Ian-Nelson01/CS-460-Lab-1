package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * MainActivity class serves as the main interface for the calculator application.
 * It handles user input through buttons, displays the expression, and computes results.
 */
public class MainActivity extends AppCompatActivity {

    public TextView textView;
    public TextView textEqual;



    // region declare all buttons
        Button ButtonA, ButtonL, ButtonR, ButtonDiv, ButtonMul,
        ButtonAdd, ButtonSub, ButtonEq, ButtonC, ButtonDec,
        Button0, Button1, Button2, Button3, Button4, Button5,
        Button6, Button7, Button8, Button9;
    // endregion

    /**
     * Called when the activity is first created.
     * This is where you should perform one-time initialization, such as setting up the UI
     * and handling any necessary configurations.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *                           being shut down, this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState(Bundle)}.
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = (TextView) findViewById(R.id.textView);
        textEqual = (TextView) findViewById(R.id.textEqual);

        /**declare each button in the xml as the button in the java
        *  pass it to the touch method so buttons can be read as "being touched"
         */
        // region
            ButtonA = (Button) findViewById(R.id.ButtonA);
            setButtonTouchListener(ButtonA);
            ButtonL = (Button) findViewById(R.id.ButtonL);
            setButtonTouchListener(ButtonL);
            ButtonR = (Button) findViewById(R.id.ButtonR);
            setButtonTouchListener(ButtonR);
            ButtonDiv = (Button) findViewById(R.id.ButtonDiv);
            setButtonTouchListener(ButtonDiv);

            Button7 = (Button) findViewById(R.id.Button7);
            setButtonTouchListener(Button7);
            Button8 = (Button) findViewById(R.id.Button8);
            setButtonTouchListener(Button8);
            Button9 = (Button) findViewById(R.id.Button9);
            setButtonTouchListener(Button9);
            ButtonMul = (Button) findViewById(R.id.ButtonMul);
            setButtonTouchListener(ButtonMul);

            Button4 = (Button) findViewById(R.id.Button4);
            setButtonTouchListener(Button4);
            Button5 = (Button) findViewById(R.id.Button5);
            setButtonTouchListener(Button5);
            Button6 = (Button) findViewById(R.id.Button6);
            setButtonTouchListener(Button6);
            ButtonSub = (Button) findViewById(R.id.ButtonSub);
            setButtonTouchListener(ButtonSub);

            Button1 = (Button) findViewById(R.id.Button1);
            setButtonTouchListener(Button1);
            Button2 = (Button) findViewById(R.id.Button2);
            setButtonTouchListener(Button2);
            Button3 = (Button) findViewById(R.id.Button3);
            setButtonTouchListener(Button3);
            ButtonAdd = (Button) findViewById(R.id.ButtonAdd);
            setButtonTouchListener(ButtonAdd);

            Button1 = (Button) findViewById(R.id.Button1);
            setButtonTouchListener(Button1);
            Button2 = (Button) findViewById(R.id.Button2);
            setButtonTouchListener(Button2);
            Button3 = (Button) findViewById(R.id.Button3);
            setButtonTouchListener(Button3);
            ButtonAdd = (Button) findViewById(R.id.ButtonAdd);
            setButtonTouchListener(ButtonAdd);

            Button0 = (Button) findViewById(R.id.Button0);
            setButtonTouchListener(Button0);
            ButtonDec = (Button) findViewById(R.id.ButtonDec);
            setButtonTouchListener(ButtonDec);
            ButtonC = (Button) findViewById(R.id.ButtonC);
            setButtonTouchListener(ButtonC);
            ButtonEq = (Button) findViewById(R.id.ButtonEq);
            setButtonTouchListener(ButtonEq);




        // endregion



    }

    /**
     * sets up holds to prevent user from writing gibberish instead of math.
     * holds prevent certain chars from use
     */
    boolean opHold = false;
    boolean parenHold = false;

    int parenNum = 0;
    boolean decHold = false;

    // I could have used a switch statement, but i dont care enough to
   


    //links the 1 click listner to the = button in arithmatic

    /**
     * Serves as an action listner for the 1 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick1(View view) {
        

        exp = exp + "1";
        textView.setText(exp);
        opHold = false; //
    }





    /**
     * Serves as an action listner for the 7 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick7(View view) {
        
        exp = exp + "7";
        textView.setText(exp);
        opHold = false;
    }

    /**
     * Serves as an action listner for the 8 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick8(View view) {
        
        exp = exp + "8";
        textView.setText(exp);
        opHold = false;
    }

    /**
     * Serves as an action listner for the 9 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick9(View view) {
        
        exp = exp + "9";
        textView.setText(exp);
        opHold = false;
    }

    /**
     * Serves as an action listner for the 4 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick4(View view) {
        
        exp = exp + "4";
        textView.setText(exp);
        opHold = false;
    }

    /**
     * Serves as an action listner for the 5 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick5(View view) {
        
        exp = exp + "5";
        textView.setText(exp);
        opHold = false;
    }

    /**
     * Serves as an action listner for the 6 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick6(View view) {
        
        exp = exp + "6";
        textView.setText(exp);
        opHold = false;

    }


    /**
     * Serves as an action listner for the 2 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick2(View view) {
        
        exp = exp + "2";
        textView.setText(exp);
        opHold = false;

    }
    /**
     * Serves as an action listner for the 3 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick3(View view) {
        
        exp = exp + "3";
        textView.setText(exp);
        opHold = false;
    }

    /**
     * Serves as an action listner for the 0 key
     * appends 1 to the math string
     * sets that string to the screens textbox
     * allows for -+/* to come after
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClick0(View view) {
        
        exp = exp + "0";
        textView.setText(exp);
        opHold = false;

    }

    /**
     * Serves as an action listner for the + key
     * checks to see if an operator CAN be used
     * appends + to the math string
     * sets that string to the screens textbox
     * enable op hold to prevent multiple operators in a row
     * disables a hold on decimals, so you can have multiple
     *  decimal numbers in the same expression.
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickAdd(View view) {
        if(exp != " ") { // checks if theres nothing. (crashes otherwise)
            if (opHold == false) {
                exp = exp + "+";
                textView.setText(exp);
                opHold = true;
                decHold = false;
            }
        }
    }

    /**
     * Serves as an action listner for the - key
     * checks to see if an operator CAN be used
     * appends - to the math string
     * sets that string to the screens textbox
     * enable op hold to prevent multiple operators in a row
     * disables a hold on decimals, so you can have multiple
     *  decimal numbers in the same expression.
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickSub(View view) {
        if(exp != " ") { // checks if theres nothing. (crashes otherwise)
            if (opHold == false) {
                exp = exp + "-";
                textView.setText(exp);
                opHold = true;
                decHold = false;
            }
        }
    }

    /**
     * Serves as an action listner for the * key
     * checks to see if an operator CAN be used
     * appends * to the math string
     * sets that string to the screens textbox
     * enable op hold to prevent multiple operators in a row
     * disables a hold on decimals, so you can have multiple
     *  decimal numbers in the same expression.
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickMul(View view) {
        if(exp != " ") { // checks if theres nothing. (crashes otherwise)
            if (opHold == false) {
                exp = exp + "*";
                textView.setText(exp);
                opHold = true;
                decHold = false;
            }
        }
    }

    /**
     * Serves as an action listner for the / key
     * checks to see if an operator CAN be used
     * appends / to the math string
     * sets that string to the screens textbox
     * enable op hold to prevent multiple operators in a row
     * disables a hold on decimals, so you can have multiple
     *  decimal numbers in the same expression.
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickDiv(View view) {
        if(exp != " ") { // checks if theres nothing. (crashes otherwise)
            if (opHold == false) {
                exp = exp + "/";
                textView.setText(exp);
                opHold = true;
                decHold = false;
            }
        }
    }

    /**
     * Serves as an action listner for the . key
     * decHold checks to see if a decimal CAN be used
     *  decHold prevents stuff like "1..0" or "1.0.0"
     * checks opHold to see if user's trying to do "1+."
     *  fixes it into "1+0."
     * appends . to the math string
     * sets that string to the screens textbox
     * enable all holds so only numbers follow a decimal
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickDec(View view) {

       if (decHold == false) {
            if (opHold == true) {
                exp = exp + "0";
            }
                exp = exp + ".";
                textView.setText(exp);
                decHold = true;
                opHold = true;
                parenHold = true;

        }

    }

    /**
     * Serves as an action listener for the ( key
     * checks parenHold to see if parens can be used
     * appends ( to the math string
     * sets that string to the screens textbox
     * enable ophold to prevent "(+"
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickL(View view) {
        
        if( parenHold == false) {

                    exp = exp + "(";
            textView.setText(exp);
            opHold = true;
            parenNum = parenNum + 1;
        }

    }

    /**
     * Serves as an action listener for the ) key
     * checks ophold to prevent "+)"
     * also checks num of open paren to prevent "())"
     * appends ) to the math string
     * sets that string to the screens textbox
     * decrement number or available close paren
     * disables holds on operators and paren so math can be done to enclosed expression
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickR(View view) {
        if( opHold == false && parenNum > 0) {
            exp = exp + ")";
            textView.setText(exp);
            parenNum = parenNum -1;
            parenHold = false;
            opHold = false
            ;
        }
    }

    /**
     * Serves as an action listener for the = key
     *
     * checks ophold to prevent user from trying to solve "1+"
     * also checks num of open paren, appends closed parens until 0.
     * checks if there's numbers adjacent to parens, treats as multiplication
     * calls evaluateExpression Method. it does math.
     * displays result on screen
     * @param view takes in the button as a UI view component.
     *
     */
    //links the = eq click listner to the = button in arithmatic
    public void onClickEq(View view) {
       if(exp != " ") { // checks if theres nothing. (crashes otherwise)
           if (opHold == false) {
               while (parenNum != 0) {
                   exp = exp + ")";
                   parenNum = parenNum - 1;
               }
               exp = addMultiplicationSymbol(exp);
               exp = addMultiplicationSymbol(exp);
               double result = evaluateExpression(exp);
               textEqual.setText("" + result);
           }
       }
        //idk why but sometimes parenthesis requires a repress?

    }
    /**
     * Serves as an action listener for the AC key
     * wipes everything in both text views.
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickA(View view) {
        exp = " ";
        opHold = false;
        parenHold = false;

        parenNum = 0;
        decHold = false;
        textView.setText(exp);
    }

    /**
     * Serves as an action listener for the C key
     * wipes the most recent entry into the string by keeping a substring of all but the last char
     *
     * uses big switch statements to preserve hold logic depending on what gets deleted.
     *
     * @param view takes in the button as a UI view component.
     *
     */
    public void onClickC(View view) {
        try {
            int penultimateNum = (exp.length() - 1);
            String newExp = exp.substring(0, penultimateNum);

            // for preserving logic if you delete a . or something
            int ultimateNum = (exp.length());
            String lastExp = exp.substring(penultimateNum, ultimateNum);

            // check last entered thing, undoes whatever flags it applied
            switch (lastExp) {
                case ".":
                    decHold = false;
                    break;
                case "*":
                    opHold = false;
                    break;
                case "/":
                    opHold = false;
                    break;
                case "+":
                    opHold = false;
                    break;
                case "-":
                    opHold = false;
                    break;
                case "(":
                    parenNum = parenNum - 1;
                    parenHold = false;
                    opHold = false;
                    break;
                case ")":
                    parenNum = parenNum + 1;
                    parenHold = true;
                    opHold = true;
                    break;

                default:

                    break;
            }
            exp = newExp;


            /** last ensure  i cant exploit calculator by deleting numbers, think fallout dogmeat glitch
             *
             */
             penultimateNum = (exp.length() - 1);
            /** for preserving logic if you delete a . or something
             *
             */
             ultimateNum = (exp.length());
             lastExp = exp.substring(penultimateNum, ultimateNum);

            /** redoes any flags changed by the deleted input
             *
             */
            switch (lastExp) {
                case ".":
                    decHold = true;
                    opHold = true;
                    parenHold = true;
                    break;
                case "*":
                    opHold = true;
                    decHold = false;
                    break;
                case "/":
                    opHold = true;
                    decHold = false;
                    break;
                case "+":
                    opHold = true;
                    decHold = false;
                    break;
                case "-":
                    opHold = true;
                    decHold = false;
                    break;
                case "(":
                    parenHold = true;
                    opHold = true;
                    break;
                case ")":
                    parenHold = false;
                    opHold = false;
                    break;

                default:
                    opHold = false;
                    break;
            }

            textView.setText(exp);
        }
        catch(Exception e){

            /** doesnt crash the app
            * just doesnt do anything if you try and delete nothing
             */
            exp = " ";
             opHold = false;
             parenHold = false;

             parenNum = 0;
             decHold = false;
            textView.setText(exp);
        }

    }


    /**
     * setButtonTouchListener() acts as a special buttonListener, allowing button touch AND un-touch
     * to be registered and used.
     * this is used to grey out buttons during taps.
      * @param button takes in button specifically
     */
    @SuppressLint("ClickableViewAccessibility") // Idk what this is, but android studio reccomended
    private void setButtonTouchListener(Button button) {
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent onMotion) {
                /** take a chance to change default view from name and ID
                 */
                if ( exp == "CWU ID: 417462956"){
                    exp = " ";
                    textEqual.setText("0");
                    Button3.setText("3");
                    textView.setText(exp);
                }

                /**
                 * changes the button color to grey while tapping
                 */
                int currentColor = button.getDrawingCacheBackgroundColor();

                switch (onMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        button.setBackgroundColor(Color.rgb(100, 100, 100));
                        //onClick(v);
                        return false; // this must be false of it will skip the onClick listerner.
                    case MotionEvent.ACTION_UP:
                        button.setBackgroundColor(currentColor);
                        return false;

                }
                return false;
            }

        });
    }
public static String exp = "CWU ID: 417462956";












    /**
     * Evaluates a mathematical expression represented as a string.
     *
     * This method parses the provided expression and computes its result using
     * the Shunting Yard algorithm. It supports basic arithmetic operations:
     * addition, subtraction, multiplication, and division, as well as the use
     * of parentheses for grouping. The expression may contain integers,
     * decimals, and spaces, which will be ignored during processing.
     *
     * @param expression The string representation of the mathematical expression
     *                   to evaluate. It should contain valid characters including
     *                   digits, operators (+, -, *, /), parentheses, and spaces.
     * @return The result of the evaluated expression as a double.
     *         If the expression is invalid, the behavior is undefined.
     * @throws EmptyStackException if the expression does not contain
     *         enough operands for the given operators.
     * @throws NumberFormatException if a number in the expression cannot be
     *         parsed correctly.
     */
// PREBUILT stack based arithmatic solver
// I got this off the internet
// https://www.geeksforgeeks.org/how-to-evaluate-math-expression-given-in-string-form-in-java/

// Function to evaluate a mathematical expression given
// in string form
public static double
evaluateExpression(String expression)
{
    char[] tokens = expression.toCharArray();

    // Stacks to store operands and operators
    Stack<Double> values = new Stack<>();
    Stack<Character> operators = new Stack<>();

    // Iterate through each character in the expression
    for (int i = 0; i < tokens.length; i++) {
        if (tokens[i] == ' ')
            continue;

        // If the character is a digit or a decimal
        // point, parse the number
        if ((tokens[i] >= '0' && tokens[i] <= '9')
                || tokens[i] == '.') {
            StringBuilder sb = new StringBuilder();
            // Continue collecting digits and the
            // decimal point to form a number
            while (i < tokens.length
                    && (Character.isDigit(tokens[i])
                    || tokens[i] == '.')) {
                sb.append(tokens[i]);
                i++;
            }
            // Parse the collected number and push it to
            // the values stack
            values.push(
                    Double.parseDouble(sb.toString()));
            i--; // Decrement i to account for the extra
            // increment in the loop
        }
        else if (tokens[i] == '(') {
            // If the character is '(', push it to the
            // operators stack
            operators.push(tokens[i]);
        }
        else if (tokens[i] == ')') {
            // If the character is ')', pop and apply
            // operators until '(' is encountered
            while (operators.peek() != '(') {
                values.push(applyOperator(
                        operators.pop(), values.pop(),
                        values.pop()));
            }
            operators.pop(); // Pop the '('
        }
        else if (tokens[i] == '+' || tokens[i] == '-'
                || tokens[i] == '*'
                || tokens[i] == '/') {
            // If the character is an operator, pop and
            // apply operators with higher precedence
            while (!operators.isEmpty()
                    && hasPrecedence(tokens[i],
                    operators.peek())) {
                values.push(applyOperator(
                        operators.pop(), values.pop(),
                        values.pop()));
            }
            // Push the current operator to the
            // operators stack
            operators.push(tokens[i]);
        }
    }

    // Process any remaining operators in the stack
    while (!operators.isEmpty()) {
        values.push(applyOperator(operators.pop(),
                values.pop(),
                values.pop()));
    }

    // The result is the only remaining element in the
    // values stack
    return values.pop();
}

    // Function to check if operator1 has higher precedence
    // than operator2
    private static boolean hasPrecedence(char operator1,
                                         char operator2)
    {
        if (operator2 == '(' || operator2 == ')')
            return false;
        return (operator1 != '*' && operator1 != '/')
                || (operator2 != '+' && operator2 != '-');
    }

    // Function to apply the operator to two operands
    private static double applyOperator(char operator,
                                        double b, double a)
    {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    /**
     * Adds multiplication symbols to expressions where numbers are
     * adjacent to parentheses.
     *
     * This method searches the input string for patterns where a number
     * is immediately followed by or preceded by parentheses. When such
     * patterns are found, it inserts a multiplication symbol (*) to
     * clarify the operation.
     *
     * For example:
     * - "3(2 + 5)" becomes "3*(2 + 5)"
     * - "(2 + 5)4" becomes "(2 + 5)*4"
     *
     * @param input The input string containing the mathematical expression
     *              where multiplication symbols need to be added.
     * @return A new string with multiplication symbols added where
     *         necessary. If no modifications are needed, the original
     *         string is returned.
     */
    // check for naked parantheses, adds multiplication signs so the math can read em
    // AI generated BTW
    public static String addMultiplicationSymbol(String input) {
        // Regular expression to find numbers followed or preceded by parentheses
        String regex = "(\\d)\\s*\\((.*?)\\)|\\((.*?)\\)\\s*(\\d)";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Replace the matches with the multiplication format
        String result = matcher.replaceAll(match -> {
            String numberBefore = match.group(1);
            String numberAfter = match.group(4);
            if (numberBefore != null) {
                return numberBefore + "*" + "(" + match.group(2) + ")";
            } else {
                return "(" + match.group(3) + ")" + "*" + numberAfter;
            }
        });

        return result;
    }





        }