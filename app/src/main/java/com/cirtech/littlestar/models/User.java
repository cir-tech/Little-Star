package com.cirtech.littlestar.models;

//Objeto Json
/*
{ "id": 0,
  "name": "",
  "lastName": "",
   "nickName": ""
}
*/
//Recuerda que este es un simple mapeo de la respuesta que esperamos
//Puedes ocupar http://www.jsonschema2pojo.org/ para realizar la entidad
public class User {

    private int id;
    private String name;
    private String lastName;
    private String nickName;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    public User(int id, String name, String lastName, String nickName) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
