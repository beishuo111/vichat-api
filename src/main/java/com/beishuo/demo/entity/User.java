package com.beishuo.demo.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("user")
public class User {

    @Id(keyType = KeyType.Auto)

    private int id;
    private String username;
    private String password;
    private String name;
    private int age;
    private int gender;
    private String avator;

}
