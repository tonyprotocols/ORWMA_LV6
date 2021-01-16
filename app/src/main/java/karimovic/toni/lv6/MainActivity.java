package karimovic.toni.lv6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RemoveClickListener, View.OnClickListener {
    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    private List<String> itemList;
    private EditText etName;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etName=(EditText) findViewById(R.id.etName);
        this.btnAdd=(Button) findViewById(R.id.btnAdd);
        setUpRecyclerData();
        setUpRecyclerView();
        this.btnAdd.setOnClickListener(this);
    }

    private void setUpRecyclerView(){
        this.recycler=(RecyclerView) findViewById(R.id.rvList);
        this.recycler.setLayoutManager( new LinearLayoutManager(this));
        adapter=new RecyclerAdapter(this, itemList);
        this.recycler.setAdapter(adapter);
    }

    private void setUpRecyclerData(){
        itemList=new ArrayList<>();
    }

    @Override
    public void onRemoveClick(int position) {
        adapter.removeCell(position);
    }

    @Override
    public void onClick(View v) {
        int position=itemList.size();
        if(!TextUtils.isEmpty(etName.getText())) {
            String name = etName.getText().toString();
            adapter.addNewCell(name, position);
        }
        else {
            Toast.makeText(this,"Insert NAME!!!", Toast.LENGTH_LONG).show();
        }
    }
}