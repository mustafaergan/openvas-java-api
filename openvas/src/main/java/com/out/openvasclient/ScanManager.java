/*
 * Copyright (C) 2015 Christoph Bless
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.out.openvasclient;

import java.util.List;

import com.out.openvasclient.commands.GetConfigsCommand;
import com.out.openvasclient.commands.GetResultsCommand;
import com.out.openvasclient.commands.GetTasksCommand;
import com.out.openvasclient.commands.ResumeTaskCommand;
import com.out.openvasclient.commands.StartTaskCommand;
import com.out.openvasclient.commands.StopTaskCommand;
import com.out.openvasclient.model.resources.config.Config;
import com.out.openvasclient.model.resources.results.Result;
import com.out.openvasclient.model.responses.GetTasksResponse;
import com.out.openvasclient.model.responses.ResumeTaskResponse;
import com.out.openvasclient.model.responses.StartTaskResponse;
import com.out.openvasclient.model.responses.StopTaskResponse;

/**
 * This class provides methods for accessing tasks. This includes methods for 
 * starting or stopping or a method for requesting the results of the task.
 * @author Christoph Bless
 */
public class ScanManager {

    private final OMPClient client;

    public ScanManager(OMPClient client) {
        this.client = client;
    }

    public List<Config> getConfigs() throws OpenVASException, StatusException {
        GetConfigsCommand cmd = new GetConfigsCommand();
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse().getConfigList();
    }

    /**
     * This method is used to start the given task. The response contains the 
     * report id which should be used to get the results.
     * 
     * @param uuid id of the task to start
     * @return The StartTaskResponse with the status text, status code and 
     * report id that should be used for getting the results
     * @throws StatusException Thrown if the start of the given task fails.
     * @throws OpenVASException Thrown if any error occurs.
     */
    public StartTaskResponse startTask(String uuid)
            throws OpenVASException, StatusException {
        StartTaskCommand cmd = new StartTaskCommand();
        cmd.setTaskId(uuid);
        client.executeWithStatusCheck(cmd);
        return cmd.getResponseHandler().getResponse();
    }

    /**
     * This method is used to start the given task.
     * 
     * @param uuid id of the task to start
     * @return The StopTaskResponse with status text und status code
     * @throws StatusException Thrown if the start of the given task fails.
     * @throws OpenVASException Thrown if any error occurs.
     */
    public StopTaskResponse stopTask(String uuid) 
            throws OpenVASException, StatusException {
        StopTaskCommand cmd = new StopTaskCommand();
        cmd.setTaskId(uuid);
        client.executeWithStatusCheck(cmd);
        return cmd.getResponseHandler().getResponse();
    }

    /**
     * This method is used to resume a stopped task. The response contains the 
     * report id which should be used to get the results. To resume a task it is 
     * required that the task was stopped before.
     * 
     * @param uuid id of the task to start
     * @return The ResumeTaskResponse with the status text, status code and 
     * report id that should be used for getting the results
     * @throws StatusException Thrown if the start of the given task fails.
     * @throws OpenVASException Thrown if any error occurs.
     */
    public ResumeTaskResponse resumeTask(String uuid) 
            throws OpenVASException, StatusException {
        ResumeTaskCommand cmd = new ResumeTaskCommand();
        cmd.setTaskId(uuid);
        client.executeWithStatusCheck(cmd);
        return cmd.getResponseHandler().getResponse();
    }

    /**
     * Gets all available tasks.
     * 
     * @return GetTaskResponse with the status text, status code and a list 
     * of tasks.
     * @throws OpenVASException Thrown if any error occurs.
     */
    public GetTasksResponse getTasks() throws OpenVASException{
        GetTasksCommand cmd = new GetTasksCommand();
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse();
    }

    /**
     * Gets the task with the given id.
     * 
     * @param uuid The id of the task to get
     * @return GetTaskResponse with the status text, status code and a list 
     * of tasks.
     * @throws OpenVASException Thrown if any error occurs.
     */
    public GetTasksResponse getTasks(String uuid) throws OpenVASException {
        GetTasksCommand cmd = new GetTasksCommand();
        cmd.setUUID(uuid);
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse();
    }
    
    /**
     * This methods requests the current status of a task. This could be any 
     * status defined in the OMP-Type task_status. 
     * @see http://www.greenbone.net/technology/omp.html#type_status
     * 
     * @param uuid The UUID of the task
     * @return The current status of the task
     * @throws OpenVASException If an error occurs during the execution
     * @throws StatusException If the response contains a return code >= 400. 
     *      Error codes between 400 and 500 are Client errors and error codes 
     *      >= 500 are Server errors.
     * 
     */
    public String getTaskStatus(String uuid) throws OpenVASException, 
            StatusException {
        GetTasksCommand cmd = new GetTasksCommand();
        cmd.setUUID(uuid);
        client.executeWithStatusCheck(cmd);
        GetTasksResponse response = cmd.getResponseHandler().getResponse();
        if (response.getTasks().size() > 0){
            return response.getTasks().get(0).getStatus();
        } else {
            throw new StatusException(404, "Task not found");
        }
        
    }

    /**
     * Gets the results of the given task.
     * @param taskid The id of the task
     * @return list of Results
     * @throws OpenVASException  Thrown if any error occurs
     */
    public List<Result> getResults(String taskid) throws OpenVASException{
        GetResultsCommand cmd = new GetResultsCommand();
        cmd.setTaskId(taskid);
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse().getResults();
    }
}
