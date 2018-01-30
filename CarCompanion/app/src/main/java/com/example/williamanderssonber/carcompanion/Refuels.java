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
    public Date date;

    @ColumnInfo(name = "amount")
    public float amount;

    @ColumnInfo(name = "total_price")
    public float totalPrice;

    @ColumnInfo(name = "price")
    public float price;

    @ColumnInfo(name = "mileage")
    public int mileage;

    public int getRefuelId(){
        return refuelId;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public float getAmount(){
        return amount;
    }
    public void setAmount(float amount){
        this.amount = amount;
    }
    public float getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(float totalPrice){
        this.totalPrice = totalPrice;
    }
    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public int getMileage(){
        return mileage;
    }
    public void setMileage(int mileage){
        this.mileage = mileage;
    }
}
