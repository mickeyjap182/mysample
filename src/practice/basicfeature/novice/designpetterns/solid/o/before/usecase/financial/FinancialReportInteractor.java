package practice.basicfeature.novice.designpetterns.solid.o.before.usecase.financial;

import practice.basicfeature.novice.designpetterns.solid.o.before.Database;

public class FinancialReportInteractor {
    public final Database database;
    enum Report {
        FINANCIAL_REPORT("Financial Report", "FINRP");
        private final String name;
        private final String code;
        Report(String name, String code) {
            this.name = name;
            this.code = code;
        }
        public String getCode() {
            return this.code;
        }
        public String getName() {
            return this.name;
        }
    }
    public FinancialReportInteractor(Database database) {
        this.database = database;
    }
    public Report getHeader() {
        return Report.FINANCIAL_REPORT;
    }
    public void save() {
        database.save(Report.values());
    }
}
