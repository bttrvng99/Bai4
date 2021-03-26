package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee> arrEmp = new ArrayList<Employee>();
    ListAdapter adapter = null;
    ListView emp_list = null;
    Button btn;
    EditText editCode, editName;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.addEmpButton);
        editCode = (EditText)findViewById(R.id.enter_id_textbox);
        editName = (EditText)findViewById(R.id.enter_name_textbox);
        genderGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        emp_list = (ListView) findViewById(R.id.emp_list);
        arrEmp = new ArrayList<Employee>();
        adapter = new ListAdapter(this,R.layout.employee_list, arrEmp);
        emp_list.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertEmp();
            }
        });
    }

    public void InsertEmp(){
        if (editCode.getText().length()==0 || editName.getText().length()==0){
            Toast.makeText(this,"Please enter ID or Name" , Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            String id = editCode.getText()+"";
            String name = editName.getText()+"";
            boolean gender = false;
            if(genderGroup.getCheckedRadioButtonId()==R.id.radio_female) gender = true;
            Employee emp = new Employee();
            emp.setId(id);
            emp.setName(name);
            emp.setGender(gender);
            arrEmp.add(emp);
            adapter.notifyDataSetChanged();
            editName.setText("");
            editCode.setText("");
            editCode.requestFocus();
        }

    }
}