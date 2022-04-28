package practice.basicfeature.novice.designpetterns.solid.o.before.usecase.financial;

import practice.basicfeature.novice.designpetterns.solid.o.before.Database;

public class FinancialDatabase implements Database {
    @Override
    public boolean save(Object record) {
        return true;
    }
}
