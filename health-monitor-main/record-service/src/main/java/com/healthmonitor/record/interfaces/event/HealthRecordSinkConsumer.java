package com.healthmonitor.record.interfaces.event;

import com.healthmonitor.domain.event.MonitorInitializedEvent;
import com.healthmonitor.domain.event.PlanGeneratedEvent;
import com.healthmonitor.domain.event.TaskPerformedEvent;
import com.healthmonitor.record.application.commandservice.HealthRecordCommandService;
import com.healthmonitor.record.domain.command.SaveRecordCommand;
import com.healthmonitor.record.interfaces.event.assembler.SaveRecordCommandDTOAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class HealthRecordSinkConsumer {
    private HealthRecordCommandService healthRecordCommandService;

    public HealthRecordSinkConsumer(HealthRecordCommandService healthRecordCommandService) {
        this.healthRecordCommandService = healthRecordCommandService;
    }

    @Bean
    public Consumer<MonitorInitializedEvent> handleMonitorInitializedEvent() {
        return monitorInitializedEvent -> {
            //添加针对MonitorInitializedEvent的处理逻辑
            SaveRecordCommand saveRecordCommand = SaveRecordCommandDTOAssembler.toCommandFromDTO(monitorInitializedEvent);
            healthRecordCommandService.handleHealthRecordCreation(saveRecordCommand);
        };
    }

    @Bean
    public Consumer<PlanGeneratedEvent> handlePlanGeneratedEvent() {
        return planGeneratedEvent -> {
            //添加针对PlanGeneratedEvent的处理逻辑
            SaveRecordCommand saveRecordCommand = SaveRecordCommandDTOAssembler.toCommandFromDTO(planGeneratedEvent);
            healthRecordCommandService.handleHealthRecordCreation(saveRecordCommand);
        };
    }

    @Bean
    public Consumer<TaskPerformedEvent> handleTaskPerformedEvent() {
        return taskPerformedEvent -> {
            //添加针对TaskPerformedEvent的处理逻辑
            SaveRecordCommand saveRecordCommand = SaveRecordCommandDTOAssembler.toCommandFromDTO(taskPerformedEvent);
            healthRecordCommandService.handleHealthRecordCreation(saveRecordCommand);
        };
    }

}
