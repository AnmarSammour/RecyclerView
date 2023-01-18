package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>
{
    Book [] bookList;
    ItemClickListener itemClickListener;
    boolean flag = false;


    public BookAdapter(Book[] bookList, ItemClickListener itemClickListener) {
        this.bookList = bookList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(bookList[position].getName());
        holder.author.setText(bookList[position].getAuthor());
        holder.itemView.setOnClickListener(view ->{
            itemClickListener.onItemClickListener(bookList[position]);
        });

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag)
                {
                    holder.like.setImageResource(R.drawable.likeblue);
                    flag =  true;
                }
                else
                {
                    holder.like.setImageResource(R.drawable.like);
                    flag = false;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.length;
    }

    public interface ItemClickListener
    {
        void onItemClickListener(Book book);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView like;
        TextView name,author;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bookName);
            author = itemView.findViewById(R.id.authorName);
            like = itemView.findViewById(R.id.like);
        }
    }
}
