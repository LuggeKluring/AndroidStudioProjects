package com.example.williamanderssonber.carcompanion;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by william.anderssonber on 2018-01-29.
 */

@Entity(tableName = "refuels")
public class Refuels {
    @PrimaryKey(autoGenerate = true)
    public int refuelId;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "amount")
    public double amount;

    @ColumnInfo(name = "total_price")
    public double cost;



    @ColumnInfo(name = "mileage")
    public int mileage;

    public int getRefuelId(){
        return refuelId;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getCost(){
        return cost;
    }
    public void setCost(double totalPrice){
        this.cost = totalPrice;
    }

    public int getMileage(){
        return mileage;
    }
    public void setMileage(int mileage){
        this.mileage = mileage;
    }
}
