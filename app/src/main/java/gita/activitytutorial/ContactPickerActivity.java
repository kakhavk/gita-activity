package gita.activitytutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactPickerActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView person1TV, person2TV, person3TV, person4TV;
    private LinearLayout person1Layout, person2Layout, person3Layout, person4Layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_picker);
        findViews();
    }

    private void findViews() {
        person1TV = (TextView) findViewById(R.id.person_1_name);
        person2TV = (TextView) findViewById(R.id.person_2_name);
        person3TV = (TextView) findViewById(R.id.person_3_name);
        person4TV = (TextView) findViewById(R.id.person_4_name);

        person1Layout = (LinearLayout) findViewById(R.id.person_1_layout);
        person2Layout = (LinearLayout) findViewById(R.id.person_2_layout);
        person3Layout = (LinearLayout) findViewById(R.id.person_3_layout);
        person4Layout = (LinearLayout) findViewById(R.id.person_4_layout);

        person1Layout.setOnClickListener(this);
        person2Layout.setOnClickListener(this);
        person3Layout.setOnClickListener(this);
        person4Layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String contactName;
        int imageId;

        if (v == person1Layout) {
            contactName = person1TV.getText().toString();
            imageId = R.mipmap.p1;
        } else if (v == person2Layout) {
            contactName = person2TV.getText().toString();
            imageId = R.mipmap.p2;
        } else if (v == person3Layout) {
            contactName = person3TV.getText().toString();
            imageId = R.mipmap.p3;
        } else {
            contactName = person4TV.getText().toString();
            imageId = R.mipmap.p4;
        }

        intent.putExtra("contactName", contactName);
        intent.putExtra("imageId", imageId);

        setResult(RESULT_OK, intent);
        finish();
    }

    public void onCancelClick(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
