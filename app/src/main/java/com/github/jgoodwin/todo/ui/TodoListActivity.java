package com.github.jgoodwin.todo.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.github.jgoodwin.todo.R;


public class TodoListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new TodoListFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_todo_list, menu);
        return true;
    }
  
}
