package gita.activitytutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CONTACT_REQUEST = 10;
    private ImageView contactImage;
    private TextView contactText;
    private Button pickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactImage = (ImageView) findViewById(R.id.contact_image);
        contactText = (TextView) findViewById(R.id.contact_name);
        pickButton = (Button) findViewById(R.id.pick_contact_btn);

        pickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, ContactPickerActivity.class), CONTACT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                contactImage.setImageResource(data.getIntExtra("imageId", 0));
                contactText.setText(data.getStringExtra("contactName"));
            } else {
                Toast.makeText(this, "კონტაქტის არჩევა გაუქმებულია!", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
