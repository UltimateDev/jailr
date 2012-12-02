package com.tyzoid.jailr.models;

import com.tyzoid.jailr.util.ExceptionPrinter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Meta extends Model {
    int id;
    String key;
    String value;

    private Meta(int id, String key, String value) {
        this.saved = true;
        this.tableName = this.config.get("prefix") + "meta";

        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Meta(String key, String value) {
        this.saved = false;
        this.tableName = this.config.get("prefix") + "meta";

        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("#%s:%s", this.key, this.value);
    }

    public void save() {
        if (!this.saved) {
            switch (this.engine) {
                case H2:
                    try {
                        this.conn = DatabaseCommon.getConnection();
                        this.pst = this.conn.prepareStatement("INSERT INTO " + this.tableName + " (key, value) VALUES (?, ?)");
                        this.pst.setString(1, this.key);
                        this.pst.setString(2, this.value);

                        this.pst.executeUpdate();

                        this.saved = true;
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    } finally {
                        try {
                            if (this.rs != null) {
                                this.rs.close();
                            }

                            if (this.pst != null) {
                                this.pst.close();
                            }

                            if (this.conn != null) {
                                this.conn.close();
                            }
                        } catch (SQLException ex) {
                            ExceptionPrinter.printFriendlyStackTrace(ex);
                        }
                    }
                    break;
                case MYSQL:
                    try {
                        this.conn = DatabaseCommon.getConnection();
                        this.pst = this.conn.prepareStatement("INSERT INTO " + this.tableName + " (key, value) VALUES (?, ?)");
                        this.pst.setString(1, this.key);
                        this.pst.setString(2, this.value);

                        this.pst.executeUpdate();

                        this.saved = true;
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    } finally {
                        try {
                            if (this.rs != null) {
                                this.rs.close();
                            }

                            if (this.pst != null) {
                                this.pst.close();
                            }

                            if (this.conn != null) {
                                this.conn.close();
                            }
                        } catch (SQLException ex) {
                            ExceptionPrinter.printFriendlyStackTrace(ex);
                        }
                    }
                    break;
            }
        }
    }

    public static List<Meta> selectAll() {
        List<Meta> metaValues = new ArrayList<Meta>();
        String tableName = DatabaseCommon.getDatabaseConfig().get("prefix") + "meta";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        switch (DatabaseCommon.getEngine()) {
            case H2:
                try {
                    conn = DatabaseCommon.getConnection();
                    st = conn.createStatement();
                    rs = st.executeQuery("SELECT * FROM " + tableName);

                    while (rs.next()) {
                        metaValues.add(new Meta(rs.getInt("id"), rs.getString("key"), rs.getString("value")));
                    }
                } catch (SQLException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }

                        if (st != null) {
                            st.close();
                        }

                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    }
                }
                break;
            case MYSQL:
                try {
                    conn = DatabaseCommon.getConnection();
                    st = conn.createStatement();
                    rs = st.executeQuery("SELECT * FROM " + tableName);

                    while (rs.next()) {
                        metaValues.add(new Meta(rs.getInt("id"), rs.getString("key"), rs.getString("value")));
                    }
                } catch (SQLException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }

                        if (st != null) {
                            st.close();
                        }

                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    }
                }
                break;
        }

        return metaValues;
    }

    public static List<Meta> selectWhere(String where) {
        List<Meta> metaValues = new ArrayList<Meta>();
        String tableName = DatabaseCommon.getDatabaseConfig().get("prefix") + "meta";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        switch (DatabaseCommon.getEngine()) {
            case H2:
                try {
                    conn = DatabaseCommon.getConnection();
                    st = conn.createStatement();
                    rs = st.executeQuery("SELECT * FROM " + tableName + " WHERE " + where);

                    while (rs.next()) {
                        metaValues.add(new Meta(rs.getInt("id"), rs.getString("key"), rs.getString("value")));
                    }
                } catch (SQLException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }

                        if (st != null) {
                            st.close();
                        }

                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    }
                }
                break;
            case MYSQL:
                try {
                    conn = DatabaseCommon.getConnection();
                    st = conn.createStatement();
                    rs = st.executeQuery("SELECT * FROM " + tableName + " WHERE " + where);

                    while (rs.next()) {
                        metaValues.add(new Meta(rs.getInt("id"), rs.getString("key"), rs.getString("value")));
                    }
                } catch (SQLException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }

                        if (st != null) {
                            st.close();
                        }

                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    }
                }
                break;
        }

        return metaValues;
    }

    public static void removeWhere(String where) {
        String tableName = DatabaseCommon.getDatabaseConfig().get("prefix") + "meta";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        switch (DatabaseCommon.getEngine()) {
            case H2:
                try {
                    conn = DatabaseCommon.getConnection();
                    st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rs = st.executeQuery("SELECT * FROM " + tableName + " WHERE " + where);

                    while (rs.next()) {
                        rs.deleteRow();
                    }
                } catch (SQLException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }

                        if (st != null) {
                            st.close();
                        }

                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    }
                }
                break;
            case MYSQL:
                try {
                    conn = DatabaseCommon.getConnection();
                    st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rs = st.executeQuery("SELECT * FROM " + tableName + " WHERE " + where);

                    while (rs.next()) {
                        rs.deleteRow();
                    }
                } catch (SQLException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }

                        if (st != null) {
                            st.close();
                        }

                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ExceptionPrinter.printFriendlyStackTrace(ex);
                    }
                }
                break;
        }
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
