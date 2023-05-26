package com.example.test0422

import android.util.Log
import java.sql.*

class Mysql {
    var mysql_ip = "localhost"
    var mysql_port = 3306 // Port : 3306
    var db_name = "mysqlDB"
    var url = "jdbc:mysql://$mysql_ip:$mysql_port/$db_name"
    var db_user = "root"
    var db_password = "509170621"
    //db_tableName = "UserTable"

    var con: Connection? = null
    var stat: Statement? = null
    var rs: ResultSet? = null
    var pst: PreparedStatement? = null

    fun connectDB() {
        // connect database
        try {
            Class.forName("com.mysql.jdbc.Driver")
            con = DriverManager.getConnection(url, db_user, db_password)
            Log.v("DB", "connection successful")
        } catch (e1: ClassNotFoundException) {
            Log.e("DB", "failed")
        } catch (e2: SQLException) {
            Log.e("DB", "connection failed")
            Log.e("DB", e2.toString())
        }finally {
            close()
        }
    }

    fun insertTable(name: String?, passwd: String?) {
        try {
            var insertSQL = "insert into UserTable(name,passwd) values(?, ?)"
            pst = con?.prepareStatement(insertSQL)
            pst?.setString(1, name)
            pst?.setString(2, passwd)
            pst?.executeUpdate()
        } catch (e: SQLException) {
            Log.e("Insert failed",e.toString())
        } finally {
            close()
        }
    }
    fun searchTable(name: String?, passwd: String?) : Boolean? {
        try {
            if(name=="" || passwd==""){
                return false
            }
            var searchSQL = "select * from UserTable where name = ? and passwd = ?"
            pst = con?.prepareStatement(searchSQL)
            pst?.setString(1, name)
            pst?.setString(2, passwd)
            rs = pst?.executeQuery()
            var ret= rs?.next()
            return ret
        } catch (e: SQLException) {
            Log.e("Search failed",e.toString())
        } finally {
            close()
        }
        return false
    }
    fun close() {
        try {
            if (rs != null) {
                rs!!.close()
                rs = null
            }
            if (stat != null) {
                stat!!.close()
                stat = null
            }
            if (pst != null) {
                pst!!.close()
                pst = null
            }
        } catch (e: SQLException) {
            Log.e("Close failed",e.toString())
        }
    }
}
