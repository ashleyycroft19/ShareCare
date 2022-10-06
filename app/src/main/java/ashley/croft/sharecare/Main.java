package ashley.croft.sharecare;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainpage);

        String a = "hello";
        Button btn = findViewById(R.id.click_contact);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Main.this,Contact.class);
                startActivity(it);

            }
        });
        Button btn2 = findViewById(R.id.button3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Main.this,Share.class);
                startActivity(it);

            }
        });
        Button btn3 = findViewById(R.id.btn);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Main.this,Qna.class);
                startActivity(it);

            }
        });

        Button btn4 = findViewById(R.id.btn);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Main.this,Qna.class);
                startActivity(it);

            }
        });
        Button btn5 = findViewById(R.id.button4);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Main.this,Navigation.class);
                startActivity(it);

            }
        });
    }
}
