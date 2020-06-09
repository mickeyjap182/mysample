package practice.basicfeature.novice.threading;

public class Detail {
    public enum InputDataValue {
        UNITPRICE(0),
        NAME(1);

        private final Integer inputNo;
        private InputDataValue(Integer inputNo) {
            this.inputNo = inputNo;
        }
        public Integer getInputNo() { return inputNo;}

    }
    public enum EntityValue {
        ID(0, "id"),
        UNITPRICE(1, "unitPrice"),
        NAME(2, "unitPrice");

        private final Integer columnId;
        private final String key;
        private EntityValue(Integer columnId, String key) {
            this.columnId = columnId;
            this.key = key;
        }
        public Integer getColumnId() { return columnId;}
        public String getKey() { return key;}

    }
    public int id;
    public int unitPrice;
    public String name;
}
