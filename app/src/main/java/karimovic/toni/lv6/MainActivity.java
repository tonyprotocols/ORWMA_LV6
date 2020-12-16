package karimovic.toni.lv6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener{
    private RecyclerView rvStudentList;
    private List<String> listStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillListData();
        setupRecyclerView();

        CustomAdapter customAdapter = new CustomAdapter(listStudent, this);
        rvStudentList.setAdapter(customAdapter);
    }

    private void setupRecyclerView(){
        rvStudentList = (RecyclerView) findViewById(R.id.rvStudentList);
        rvStudentList.setLayoutManager(new LinearLayoutManager(this));

        /*
        * TODO
        *  Custom adapter
        *  setAdapter
        * */
    }
    private void  fillListData(){
        listStudent = new ArrayList<>();
        listStudent.add("Toni");
        listStudent.add("Ivan");
        listStudent.add("WTF");
        listStudent.add("Fran");
        listStudent.add("Cristiano");
        listStudent.add("Marin");
        listStudent.add("Monkey");
        listStudent.add("Dragon");
        listStudent.add("Dragon");
        listStudent.add("Dragon");
        listStudent.add("Dragon");
        listStudent.add("Dragon");
        listStudent.add("Dragon");
    }

    @Override
    public void onNameClickListener(int position) {
        Log.d("onNameClickListener","Element" + position + "remove.");

    }
}