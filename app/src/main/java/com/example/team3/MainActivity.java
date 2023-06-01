package com.example.team3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText sideEffectEditText;
    private Button addButton;
    private ListView sideEffectListView;
    private List<String> sideEffectList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sideEffectEditText = findViewById(R.id.sideEffectEditText);
        addButton = findViewById(R.id.addButton);
        sideEffectListView = findViewById(R.id.sideEffectListView);
        sideEffectList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sideEffectList);
        sideEffectListView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sideEffect = sideEffectEditText.getText().toString().trim();
                if (!sideEffect.isEmpty()) {
                    sideEffectList.add(sideEffect);
                    adapter.notifyDataSetChanged();
                    sideEffectEditText.setText("");
                }
            }
        });
    }
}
