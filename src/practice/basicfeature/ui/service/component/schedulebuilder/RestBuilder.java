package practice.basicfeature.ui.service.component.schedulebuilder;

import org.apache.commons.lang3.NotImplementedException;
import practice.basicfeature.ui.entities.scheduleset.LongRest;
import practice.basicfeature.ui.entities.scheduleset.Rest;
import practice.basicfeature.ui.entities.scheduleset.Work;
import practice.basicfeature.ui.service.component.ScheduleBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 画面の情報を保持するクラスと生成系を分ける
 */
final public class RestBuilder extends ScheduleBuilder {
    // TODO add final.

    protected RestBuilder(Builder builder) {
        super(builder);
    }

    /**
     * ビルダーパターンによる時間セットの生成
     */
    public final static class Builder extends ScheduleBuilder.Builder<Builder>  {
        private List<Rest> rest = new ArrayList<>();
        private List<LongRest> longRest = new ArrayList<>();

        public static Builder newInstance(int units) {
            return new Builder(units);
        }

        protected ScheduleBuilder.Builder self() {
            // TODO:要整理
            throw new NotImplementedException();
        }


        private Builder(int units) {
            super(units);
        }
        public Builder rest(Rest oneRest) {
            this.rest.add(oneRest);
            return this;
        }

        RestBuilder build() {
            return new RestBuilder(this);
        }
    }

}
