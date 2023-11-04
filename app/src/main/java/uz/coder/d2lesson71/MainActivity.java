package uz.coder.d2lesson71;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import uz.coder.d2lesson71.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyDBHelper myDBHelper;
    private MyAdapter adapter;
    private List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDBHelper = new MyDBHelper(this);
//        binding.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Student student = new Student("Shohrux",15,"+998990000000");
//                myDBHelper.addStudent(student);
//
//            }
//        })
        loadData();
        adapter = new MyAdapter(studentList);
        binding.rec.setLayoutManager(new LinearLayoutManager(this));
        binding.rec.setAdapter(adapter);


    }

    private void loadData() {
        studentList = new ArrayList<>();
        studentList = myDBHelper.getAllStudent();
    }
}