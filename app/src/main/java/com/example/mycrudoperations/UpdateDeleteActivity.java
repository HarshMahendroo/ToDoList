package com.example.mycrudoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class UpdateDeleteActivity extends AppCompatActivity {
    private UserModel userModel;
    private EditText etname, etmodel;
    private Button btnupdate, btndelete, btnsetrem;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        Intent intent = getIntent();
        userModel = (UserModel) intent.getSerializableExtra("user");
        databaseHelper = new DatabaseHelper(this);
        etname = (EditText) findViewById(R.id.etname);
       // etmodel = (EditText) findViewById(R.id.etmodel);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btnsetrem=(Button)findViewById(R.id.remind);
        etname.setText(userModel.getName());
       // etmodel.setText(userModel.getModel());
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateUser(userModel.getId(),etname.getText().toString());
                Toast.makeText(UpdateDeleteActivity.this, "Updated Successfully!",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new
                        Intent(UpdateDeleteActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteUSer(userModel.getId());
                Toast.makeText(UpdateDeleteActivity.this, "Deleted Successfully!",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new
                        Intent(UpdateDeleteActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btnsetrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateDeleteActivity.this, "Remainder is setting", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteActivity.this,ActivityReminder.class);
                startActivity(intent);
            }
        });
    }
}