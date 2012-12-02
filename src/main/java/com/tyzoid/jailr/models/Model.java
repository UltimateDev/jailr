package com.tyzoid.jailr.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class Model {
    Map<String, Object> config;

    DatabaseEngine engine;
    boolean saved;
    String tableName;

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Statement st;

    public Model() {
        this.engine = DatabaseCommon.getEngine();
        this.config = DatabaseCommon.getDatabaseConfig();
    }
}
