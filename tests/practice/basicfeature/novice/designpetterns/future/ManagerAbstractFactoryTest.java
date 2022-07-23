package practice.basicfeature.novice.designpetterns.future;

import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.designpetterns.feature.ManagerAbstractFactory;
import practice.basicfeature.novice.designpetterns.feature.abstractfactory.EngineeringManager;
import practice.basicfeature.novice.designpetterns.feature.abstractfactory.ProjectManager;

import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerAbstractFactoryTest {
    @Test
    void testCreate() {
        List<ManagerAbstractFactory> mng = List.of(new EngineeringManager(), new ProjectManager());
        mng.parallelStream().forEach( mg ->
            {
                mg.createRecruitment();
                mg.createCostManagement();
                mg.createHealthMonitoring();
                mg.createObjectiveScoreSheet();
                mg.createScheduleManagement();
                mg.createTrainingMethod();
            }
        );

        assertTrue(true);
    }

    public static void echo(Object o) {
        out.print(o.toString());
    }

}