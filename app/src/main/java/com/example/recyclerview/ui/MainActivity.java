package com.example.recyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.BookAdapter;
import com.example.recyclerview.model.Book;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        Book [] books =
                {
                        new Book("Clean Code","Robert C.Martin"),
                        new Book("Code Complete","Steve McConnell"),
                        new Book("Python Programming","John Zelle"),
                        new Book("Clean Code","Robert C.Martin"),
                        new Book("Code Complete","Steve McConnell"),
                        new Book("Python Programming","John Zelle"),
                        new Book("Clean Code","Robert C.Martin"),
                        new Book("Code Complete","Steve McConnell"),
                        new Book("Python Programming","John Zelle"),
                        new Book("Clean Code","Robert C.Martin"),
                        new Book("Code Complete","Steve McConnell"),
                        new Book("Python Programming","John Zelle")
                };

        BookAdapter adapter = new BookAdapter(books, new BookAdapter.ItemClickListener() {
            @Override
            public void onItemClickListener(Book book) {
                Toast.makeText(MainActivity.this, "The item" + book.getName() + "is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}