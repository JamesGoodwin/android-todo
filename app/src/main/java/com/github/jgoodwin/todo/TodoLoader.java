package com.github.jgoodwin.todo;

import android.content.Context;
import android.content.Loader;

import com.github.jgoodwin.todo.domain.Todo;

import java.util.ArrayList;
import java.util.Date;

public class TodoLoader extends Loader<ArrayList<Todo>> {

    public TodoLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        ArrayList<Todo> data = new ArrayList<>();
        data.add(new Todo(false, new Date(), "Buy milk", ""));
        deliverResult(data);
    }
}
