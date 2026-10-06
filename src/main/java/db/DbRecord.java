package db;

import java.util.HashMap;

import static javax.swing.UIManager.getInt;

public class DbRecord extends HashMap<String, Object> {
    public String str(String column) {
        Object v = get(column);
        return v == null ? null : v.toString();
    }

    public Integer getInt(String column) {
        Object v = get(column);
        if (v == null) return null;
        if (v instanceof Number) return ((Number) v).intValue();
        return Integer.parseInt(v.toString().trim());
    }
}