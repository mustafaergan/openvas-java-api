package com.out.openvasclient.model.responses;

import java.util.ArrayList;
import java.util.List;

import com.out.openvasclient.model.resources.tasks.Task;

public class GetTasksResponse extends Response {

    private List<Task> tasks = new ArrayList<Task>();

    public GetTasksResponse() {
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }
    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "GetTasksResponse{status=" + status + ", statusText=" + statusText + " tasks=" + tasks + '}';
    }
    
    
}
