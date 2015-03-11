package com.github.jgoodwin.todo;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;

public class TodoApplication extends Application {

    private ObjectGraph objectGraph;

    @Override public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(new TodoModule(this));
    }

    public static ObjectGraph objectGraph(Context context) {
        return ((TodoApplication) context.getApplicationContext()).objectGraph;
    }

}
