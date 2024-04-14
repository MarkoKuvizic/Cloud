package com.okta.mongodb.mongodbouth;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoviePhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    @Value("TABLE_NAME")
    private String table;

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment){
        return Identifier.toIdentifier(table);
    }
}
