package com.healthmonitor.monitor.integration.event;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.healthmonitor.domain.event.MonitorInitializedEvent;
import com.healthmonitor.domain.event.PlanGeneratedEvent;
import com.healthmonitor.domain.event.TaskPerformedEvent;

@Service
public class MonitorEventPublisherService{

    private static final String monitorApplication_BINDING_NAME = "monitorApplication-out-0";
    private static final String planGeneration_BINDING_NAME = "planGeneration-out-0";
    private static final String taskPerforming_BINDING_NAME = "taskPerforming-out-0";

    private final StreamBridge stream;

    public MonitorEventPublisherService(StreamBridge stream){
        this.stream = stream;
    }

    @TransactionalEventListener
    public void handleMonitorInitializedEvent(MonitorInitializedEvent monitorInitializedEvent){
        boolean sent = stream.send(monitorApplication_BINDING_NAME, monitorInitializedEvent);
    }

    @TransactionalEventListener
    public void handlePlanGeneratedEvent(PlanGeneratedEvent planGeneratedEvent){
        boolean sent = stream.send(planGeneration_BINDING_NAME, planGeneratedEvent);
    }
    
    @TransactionalEventListener
    public void handleTaskPerformedEvent(TaskPerformedEvent taskPerformedEvent){
        boolean sent = stream.send(taskPerforming_BINDING_NAME, taskPerformedEvent);
    }
}
