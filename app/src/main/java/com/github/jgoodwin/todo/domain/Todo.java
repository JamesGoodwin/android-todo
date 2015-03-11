package com.github.jgoodwin.todo.domain;

import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    private final boolean done;
    private final Date dueDate;
    private final String action;
    private final String notes;
 
    public Todo(boolean done, Date dueDate, String action, String notes) {
        this.done = done;
        this.dueDate = dueDate;
        this.action = action;
        this.notes = notes;
    }
    
    public Todo(Todo todo) {
        this.done = todo.isDone();
        this.dueDate = todo.dueDate();
        this.action = todo.action();
        this.notes = todo.notes();
    }

    public Date dueDate() {
        return dueDate;
    }

    public String action() {
        return action;
    }

    public boolean isDone() {
        return done;
    }

    public String notes() {
        return notes;
    }
}
