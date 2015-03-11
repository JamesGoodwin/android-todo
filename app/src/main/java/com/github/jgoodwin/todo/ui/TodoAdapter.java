package com.github.jgoodwin.todo.ui;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.github.jgoodwin.todo.R;
import com.github.jgoodwin.todo.domain.Todo;

import java.util.Date;
import java.util.List;

import static com.github.jgoodwin.todo.R.id.title_edit_text;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> implements TextView.OnEditorActionListener {

    private final List<Todo> todos;

    public TodoAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View v = layoutInflater.inflate(R.layout.todo_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < todos.size()) {
            showTodo(holder, position);
        } else {
            showNewTodo(holder);
        }
    }

    private void showNewTodo(ViewHolder holder) {
        holder.titleEditText.setVisibility(View.VISIBLE);
        holder.titleEditText.setOnEditorActionListener(this);
        
        holder.title.setVisibility(View.GONE);
        holder.checkbox.setEnabled(false);
        holder.checkbox.setChecked(false);
    }

    private void showTodo(ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        TextView title = holder.title;
        title.setText(todo.action());
        title.setVisibility(View.VISIBLE);
        
        CheckBox checkbox = holder.checkbox;
        checkbox.setEnabled(true);
        checkbox.setChecked(todo.isDone());

        holder.titleEditText.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return todos.size() + 1;
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
        if (event != null 
                && event.getAction() == KeyEvent.ACTION_DOWN 
                && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {     
            
            Todo todo = new Todo(false, new Date(), textView.getText().toString(), "");
            textView.setText("");

            this.todos.add(todo);
            notifyDataSetChanged();
            
            return true;
        }
        return false;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final CheckBox checkbox;
        private final EditText titleEditText;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            checkbox = (CheckBox) v.findViewById(R.id.check_box);
            titleEditText = (EditText) v.findViewById(title_edit_text);
        }
    }


}
