package practice.basicfeature.novice.designpetterns.feature.abstractfactory;

import practice.basicfeature.novice.designpetterns.feature.ManagerAbstractFactory;

public class EngineeringManager implements ManagerAbstractFactory {

    @Override
    public void createRecruitment() {
        System.out.println("エンジニアマネージャによる採用活動");
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
