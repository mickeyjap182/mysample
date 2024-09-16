package practice.basicfeature.ui.entities.scheduleset;

import java.time.LocalDateTime;

public record LongRest(LocalDateTime startTime, LocalDateTime endTime) implements Period {

    @Override
    public String getType() {
        return "";
    }
}
