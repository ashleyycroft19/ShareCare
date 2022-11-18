package ashley.croft.sharecare;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Call extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);

        Button sos = findViewById(R.id.sos_btn);
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "112";
                if (ContextCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                    startActivity(it);}
                else { ActivityCompat.requestPermissions( Call.this, new String[]{Manifest.permission.CALL_PHONE},                             123);                 }
            }
        });
    }
}


