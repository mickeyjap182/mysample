package practice.basicfeature.ui.service.component;

import practice.basicfeature.ui.entities.scheduleset.LongRest;
import practice.basicfeature.ui.entities.scheduleset.Rest;
import practice.basicfeature.ui.entities.scheduleset.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * 画面の情報を保持するクラスと生成系を分ける
 */
public class ScheduleBuilder {
    // TODO add final.
    private final List<Work> works;
    private final List<Rest> rest;
    private final List<LongRest> longRest;

    private ScheduleBuilder(Builder builder) {
        this.works = builder.works;
        this.rest = builder.rest;
        this.longRest = builder.longRest;
    }

    /**
     * ビルダーパターンによる時間セットの生成
     */
    public static class Builder  {
        private final int units;
        private List<Work> works = new ArrayList<>();
        private List<Rest> rest = new ArrayList<>();
        private List<LongRest> longRest = new ArrayList<>();

        public static ScheduleBuilder.Builder getInstance(int units) {
            return new Builder(units);
        }
        private Builder(int units) {
            this.units = units;
        }
        public Builder rest(Rest oneRest) {
            this.rest.add(oneRest);
            return this;
        }

        public ScheduleBuilder build() {
            return new ScheduleBuilder(this);
        }
    }

}
