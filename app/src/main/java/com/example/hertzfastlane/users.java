package com.example.hertzfastlane;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by dapik on 9/30/2016.
 */


/*
 * Users class parses JSON data from table users in AWS database
 */
@DynamoDBTable(tableName = "users")
public class users {
    @DynamoDBHashKey(attributeName = "username")
    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    @DynamoDBIndexRangeKey(attributeName = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String usersname;
    private String password;
}
