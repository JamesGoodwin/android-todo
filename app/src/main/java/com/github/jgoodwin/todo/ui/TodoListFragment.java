package com.github.jgoodwin.todo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jgoodwin.todo.ui.DividerItemDecoration;
import com.github.jgoodwin.todo.R;
import com.github.jgoodwin.todo.ui.TodoAdapter;
import com.github.jgoodwin.todo.domain.Todo;
import com.squareup.sqlbrite.SqlBrite;

import java.util.ArrayList;


import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TodoListFragment extends Fragment {


    
    @InjectView(R.id.list) RecyclerView list;

    @Inject SqlBrite db;
    
    private TodoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        ArrayList<Todo> todos = new ArrayList<>();
        this.adapter = new TodoAdapter(todos);

        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialiseTodos();
    }

    private void initialiseTodos() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());

        list.setHasFixedSize(true);
        list.addItemDecoration(new DividerItemDecoration(this.getActivity(), null));
        
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
    }

}
