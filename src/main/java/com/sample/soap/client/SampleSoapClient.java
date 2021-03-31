package com.sample.soap.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.sample.stub.VehicleServiceStub;
import com.sample.stub.VehicleServiceStub.AddVehicle;
import com.sample.stub.VehicleServiceStub.Vehicle;
import com.sample.stub.VehicleServiceStub.AddVehicleResponse;

public class SampleSoapClient {

    public int getNumSeats(int vehicleNum) {
        return getVehicle(vehicleNum).getNoOfSeats();
    }

    private Vehicle getVehicle(int vehicleNum) {

        Vehicle vehicle = null;

        try {
            VehicleServiceStub stub = new VehicleServiceStub();
            VehicleServiceStub.GetVehicle vehNum = new VehicleServiceStub.GetVehicle();
            vehNum.setId(vehicleNum);
            VehicleServiceStub.GetVehicleResponse response1 = stub.getVehicle(vehNum);
            vehicle = response1.get_return();

//log response.getGetGeoIPResult().getCountryName()
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return vehicle;
    }

    public static void main(String [] args){

        SampleSoapClient client = new SampleSoapClient();
        int numSeats = client.getNumSeats(0);
        System.out.println("Number of seats: " + numSeats);
    }
}
