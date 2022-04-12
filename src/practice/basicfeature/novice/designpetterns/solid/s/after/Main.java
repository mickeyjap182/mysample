package practice.basicfeature.novice.designpetterns.solid.s.after;


import practice.basicfeature.novice.designpetterns.solid.s.after.actors.CFO;
import practice.basicfeature.novice.designpetterns.solid.s.after.actors.COO;
import practice.basicfeature.novice.designpetterns.solid.s.after.actors.CTO;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeFacade;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.EmployeeData;
import practice.basicfeature.novice.designpetterns.solid.s.after.domains.Repository;

/**
 * 単一責任の原則 :after
 */
public class Main {
    public static void main(String[] args) {
        // アクターたち
        COO ema = new COO("Ema", "001");
        CFO bob = new CFO("BoB", "002");
        CTO martin = new CTO("Martin", "003");
        EmployeeData betty = new EmployeeData("E001","Betty",1500);

        // 各自ユースケースに応じた操作
        Repository repo = Repository.getInstance();

        EmployeeFacade.save(repo, betty);
        int hours = ema.reportHours(betty, 20, 8);
        int salary = bob.calculatePay(betty, 20, 8, 150);
        EmployeeData saved = repo.getEmployee(betty.getCode());

        // 結果出力
        System.out.println(String.format("employee-> id : %d name:%s totalhours: %d, salary:%d", saved.getId(), saved.getName(), hours, salary));
    }
}
