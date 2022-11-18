package ashley.croft.sharecare;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Contact extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.contact);

        Button phone = findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "01074073691";
                if (ContextCompat.checkSelfPermission(Contact.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                    startActivity(it);
                } else {
                    ActivityCompat.requestPermissions(Contact.this, new String[]{Manifest.permission.CALL_PHONE}, 123);
                }
            }
        });

        Button email = findViewById(R.id.email);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"yuri.croft26@stu.siskorea.org"});
                startActivity(email);


            }
        });
    }
}