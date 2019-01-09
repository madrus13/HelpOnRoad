package ru.Service;

import org.hibernate.dialect.MySQLDialect;

public class LocalMysqlDialect extends MySQLDialect {
    @Override
    public String getTableTypeString() {
        return " DEFAULT CHARSET=utf8";
    }
}
