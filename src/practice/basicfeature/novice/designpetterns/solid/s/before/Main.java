package practice.basicfeature.novice.designpetterns.solid.s.before;

import practice.basicfeature.novice.designpetterns.solid.s.before.actors.CFO;
import practice.basicfeature.novice.designpetterns.solid.s.before.actors.COO;
import practice.basicfeature.novice.designpetterns.solid.s.before.actors.CTO;
import practice.basicfeature.novice.designpetterns.solid.s.before.domains.Employee;
import practice.basicfeature.novice.designpetterns.solid.s.before.domains.Repository;

/**
 * 単一責任の原則 :before
 */
public class Main {
    public static void main(String[] args) {
        // アクターたち
        COO ema = new COO("Ema", "001");
        CFO bob = new CFO("BoB", "002");
        CTO martin = new CTO("Martin", "003");
        Employee betty = new Employee("E001","Betty",1500);

        // 各自ユースケースに応じた操作
        Repository repo = Repository.getInstance();
        martin.save(repo, betty);
        int hours = ema.reportHours(betty, 20, 8);
        int salary = bob.calculatePay(betty, 20, 8);
        Employee saved = repo.getEmployee(betty.getCode());

        // 結果出力
        System.out.println(String.format("employee-> id : %d name:%s totalhours: %d, salary:%d", saved.getId(), saved.getName(), hours, salary));
    }
}
