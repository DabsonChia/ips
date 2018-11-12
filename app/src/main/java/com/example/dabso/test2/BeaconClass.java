package com.example.dabso.test2;


import android.bluetooth.BluetoothDevice;

import java.io.Serializable;
import java.math.BigInteger;

public class BeaconClass implements Serializable {
    private String address;
    private transient BluetoothDevice bdevice;
    private int rssi;
    private byte[] scanrecord;
    final int txPower=-59;

    public BeaconClass(){

    }

    public  BeaconClass(BluetoothDevice bdevice, int rssi, byte[] scanrecord) {
        this.bdevice = bdevice;
        this.rssi = rssi;
        this.scanrecord = scanrecord;
        this.address=bdevice.getAddress();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        this.address = bdevice.getAddress();
    }

    public boolean isMyBeacon(){
        return bdevice.getAddress().contains("00:A0:50");
    }

    public BluetoothDevice getBdevice() {
        return bdevice;
    }

    public void setBdevice(BluetoothDevice bdevice) {
        this.bdevice = bdevice;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public byte[] getScanrecord() {
        return scanrecord;
    }

    public void setScanrecord(byte[] scanrecord) {
        this.scanrecord = scanrecord;
    }

    public String distance(){
        String distanceString=""+getDistance(rssi, txPower);
        return distanceString;
    }

    private String byteToHex(byte[] scanRecord){
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i < scanRecord.length; i++){
            buffer.append(Character.forDigit((scanRecord[i] >> 4) & 0xF, 16));
            buffer.append(Character.forDigit((scanRecord[i] & 0xF), 16));
        }
        //return buffer.toString();

        BigInteger n = new BigInteger(scanRecord);
        String hexa = n.toString(16);
        return hexa;
    }

    @Override
    public String toString(){
        return ("Device Name: " + bdevice.getAddress() + " rssi: " + rssi + " Distance: " + getDistance(rssi, txPower) +
                "m  Scan Record: " + scanrecord.toString() + "\n");
    }
    private double getDistance(int rssi, int txPower) {
        return (double)Math.round((Math.pow(10d, ((double) txPower - rssi) / (10 * 2))) * 100) / 100;
    }
}
