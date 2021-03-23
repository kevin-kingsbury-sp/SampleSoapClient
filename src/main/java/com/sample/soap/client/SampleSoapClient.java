package com.sample.soap.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.sample.stub.VehicleServiceStub;
import com.sample.stub.VehicleServiceStub.AddVehicle;
import com.sample.stub.VehicleServiceStub.Vehicle;
import com.sample.stub.VehicleServiceStub.AddVehicleResponse;

public class SampleSoapClient {

    public static void main(String [] args){

        try {
            VehicleServiceStub stub = new VehicleServiceStub();
            VehicleServiceStub.GetVehicle vehNum = new VehicleServiceStub.GetVehicle();
            vehNum.setId(0);
            VehicleServiceStub.GetVehicleResponse response1 = stub.getVehicle(vehNum);
            Vehicle vehicle = response1.get_return();
            System.out.println(vehicle.toString());

//            Vehicle vehicle1 = new Vehicle();
//            vehicle1.setId(0);
//            vehicle1.setBrand("Brand1");
//            vehicle1.setModel("Model1");
//            vehicle1.setNoOfSeats(4);
//            AddVehicle addV1 = new AddVehicle();
//            addV1.setVehicle(vehicle1);
//            AddVehicleResponse response = stub.addVehicle(addV1);
//log response.getGetGeoIPResult().getCountryName()
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
