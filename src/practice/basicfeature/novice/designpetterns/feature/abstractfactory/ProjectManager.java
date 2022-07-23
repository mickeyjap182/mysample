package practice.basicfeature.novice.designpetterns.feature.abstractfactory;

import practice.basicfeature.novice.designpetterns.feature.ManagerAbstractFactory;

public class ProjectManager implements ManagerAbstractFactory {

    @Override
    public void createRecruitment() {
        System.out.println("プロジェクトマネージャによるプロジェクトメンバ面談活動");
    }

    @Override
    public void createTrainingMethod() {

    }

    @Override
    public void createObjectiveScoreSheet() {

    }

    @Override
    public void createHealthMonitoring() {

    }

    @Override
    public void createScheduleManagement() {

    }

    @Override
    public void createCostManagement() {

    }

    enum FactoryType{ NOTIFICATIO, }

}
