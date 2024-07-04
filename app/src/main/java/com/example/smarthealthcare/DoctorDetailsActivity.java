package com.example.smarthealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name : Thalente","Hospital Address : KwaMashu","Exp : 5yrs", "Mobile No : 0679322930","600"},
                    {"Doctor Name : Nonku","Hospital Address : Newlands","Exp : 15yrs", "Mobile No : 0718051045","900"},
                    {"Doctor Name : Phumzile","Hospital Address : Durban","Exp : 10yrs", "Mobile No : 0740460826","300"},
                    {"Doctor Name : Saminathi","Hospital Address : Pretoria","Exp : 25yrs", "Mobile No : 0786934564","500"},
                    {"Doctor Name : Unathi","Hospital Address : Pretoria","Exp : 35yrs", "Mobile No : 0689345623","800"}
            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name : Govender","Hospital Address : Phoenix","Exp : 1yrs", "Mobile No : 0789239840","200"},
                    {"Doctor Name : Naidoo","Hospital Address : India","Exp : 2yrs", "Mobile No : 0734452637","700"},
                    {"Doctor Name : Pillay","Hospital Address : SingarPore","Exp : 10yrs", "Mobile No : 0740499384","300"},
                    {"Doctor Name : Caluza","Hospital Address : Pretoria","Exp : 25yrs", "Mobile No : 0786934564","500"},
                    {"Doctor Name : Thusi","Hospital Address : Pretoria","Exp : 35yrs", "Mobile No : 0689345623","800"}
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Sibusiso","Hospital Address : Indosia","Exp : 5yrs", "Mobile No : 0679322930","600"},
                    {"Doctor Name : Tylor","Hospital Address : China","Exp : 15yrs", "Mobile No : 0718051045","900"},
                    {"Doctor Name : Ngubane","Hospital Address : Pinville","Exp : 10yrs", "Mobile No : 0740460826","300"},
                    {"Doctor Name : Folkod","Hospital Address : University","Exp : 25yrs", "Mobile No : 0786934564","500"},
                    {"Doctor Name : Sandile","Hospital Address : Inkandla","Exp : 35yrs", "Mobile No : 0689345623","800"}
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Baker","Hospital Address : KwaMashu","Exp : 5yrs", "Mobile No : 0679322930","600"},
                    {"Doctor Name : Tyreese","Hospital Address : Newlands","Exp : 15yrs", "Mobile No : 0718051045","900"},
                    {"Doctor Name : Qhakaza","Hospital Address : Durban","Exp : 10yrs", "Mobile No : 0740460826","300"},
                    {"Doctor Name : Esethu","Hospital Address : Pretoria","Exp : 25yrs", "Mobile No : 0786934564","500"},
                    {"Doctor Name : Lungelo","Hospital Address : Pretoria","Exp : 35yrs", "Mobile No : 0689345623","800"}
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Nomonde","Hospital Address : KwaMashu","Exp : 5yrs", "Mobile No : 0679322930","600"},
                    {"Doctor Name : Lerato","Hospital Address : Newlands","Exp : 15yrs", "Mobile No : 0718051045","900"},
                    {"Doctor Name : Andiswa","Hospital Address : Durban","Exp : 10yrs", "Mobile No : 0740460826","300"},
                    {"Doctor Name : Sne","Hospital Address : Pretoria","Exp : 25yrs", "Mobile No : 0786934564","500"},
                    {"Doctor Name : Palisa","Hospital Address : Pretoria","Exp : 35yrs", "Mobile No : 0689345623","800"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item= new HashMap<String,String>();
            item.put( "line_a",doctor_details[i][0]);
            item.put( "line_b",doctor_details[i][1]);
            item.put( "line_c",doctor_details[i][2]);
            item.put( "line_d",doctor_details[i][3]);
            item.put( "line_e","Cons Fees:"+doctor_details[i][4]+"R");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line_a","line_b","line_c","line_d","line_e"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }

}