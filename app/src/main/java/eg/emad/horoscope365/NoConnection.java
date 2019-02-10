package eg.emad.horoscope365;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoConnection extends AppCompatActivity {

    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);
        getSupportActionBar().hide();

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_internet);
        dialog.setCancelable(false);

        Button btnRetry = dialog.findViewById(R.id.retry);
        Button btnTryLater = dialog.findViewById(R.id.tryLater);

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoConnection.this, MainActivity.class));
                finish();
            }
        });

        btnTryLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        dialog.show();

    }
}
