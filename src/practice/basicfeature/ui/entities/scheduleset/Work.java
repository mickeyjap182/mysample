package practice.basicfeature.ui.entities.scheduleset;

import java.time.LocalDateTime;

record Work(LocalDateTime startTime, LocalDateTime endTime) implements Period{
    @Override
    public String getType() {
        return "";
    }
}
