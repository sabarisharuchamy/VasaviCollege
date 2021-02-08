package matrix.cube;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3,button4;
    EditText ed1,ed2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        ed1 = findViewById(R.id.editText1);
        ed2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView3);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                StringBuilder sb = new StringBuilder();
//                int x,y,res;
//                x = Integer.valueOf(ed1.getText().toString());
//                y = Integer.valueOf(ed2.getText().toString());
//                res=x+y;
//                textView.setText("Addition of two nos is "+String.valueOf(res));
//                //Toast.makeText(MainActivity.this,"Button Clicked!",Toast.LENGTH_LONG).show();
////                sb.append("Addition of 2nos is "+String.valueOf(res));
////                res=x-y;
////                sb.append("\nSubtraction of 2nos is "+String.valueOf(res));
////                res=x*y;
////                sb.append("\nMultiplication of 2nos is "+String.valueOf(res));
////                res=x/y;
////                sb.append("\nDivision of 2nos is "+String.valueOf(res));
////                textView.setText(sb.toString());
//
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int x,y,res;
//                x = Integer.valueOf(ed1.getText().toString());
//                y = Integer.valueOf(ed2.getText().toString());
//                res=x-y;
//                textView.setText("Subtraction of two nos is "+String.valueOf(res));
//
//            }
//        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int x,y,res;
//                x = Integer.valueOf(ed1.getText().toString());
//                y = Integer.valueOf(ed2.getText().toString());
//                res=x*y;
//                textView.setText("Multiplication of two nos is "+String.valueOf(res));
//
//            }
//        });
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int x,y,res;
//                x = Integer.valueOf(ed1.getText().toString());
//                y = Integer.valueOf(ed2.getText().toString());
//                res=x/y;
//                textView.setText("Division of two nos is "+String.valueOf(res));
//
//            }
//        });

    }

    public void onClick(View  view){
        int x,y,res;
        x = Integer.valueOf(ed1.getText().toString());
        y = Integer.valueOf(ed2.getText().toString());
switch (view.getId()){
    case R.id.button:
        res=x+y;
        textView.setText("Addition of two nos is "+String.valueOf(res));
        break;
    case R.id.button2:
        res=x-y;
        textView.setText("Subtraction of two nos is "+String.valueOf(res));
        break;
    case R.id.button3:
        res=x*y;
        textView.setText("Multiplication of two nos is "+String.valueOf(res));
        break;
    case R.id.button4:
        res=x/y;
        textView.setText("Division of two nos is "+String.valueOf(res));
        break;
}
    }
}