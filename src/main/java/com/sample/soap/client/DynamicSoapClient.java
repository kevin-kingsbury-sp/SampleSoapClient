/*
 * (c) Copyright 2021 SailPoint Technologies, Inc., All Rights Reserved.
 */

package com.sample.soap.client;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class DynamicSoapClient implements Serializable {

    private static EndpointReference targetEPR =
            new EndpointReference("http://localhost:8090/SampleSoapService/services/VehicleService");

    private ServiceClient getServiceClient() throws AxisFault {
        OMElement getVehiclePayload = getVehiclePayload(0);
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);

        ServiceClient sender = new ServiceClient();
        sender.setOptions(options);
        return sender;
    }

    private OMElement getVehiclePayload(int vehicleId) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://webservice.MavenAxis2WebService/", "tns");

        OMElement method = fac.createOMElement("getVehicle", omNs);
        OMElement value = fac.createOMElement("id", omNs);
        value.addChild(fac.createOMText(value, Integer.toString(vehicleId)));
        method.addChild(value);
        return method;
    }

    private OMElement getVehicle(int vehicleId) throws AxisFault {
        ServiceClient sender = getServiceClient();
        OMElement result = sender.sendReceive(getVehiclePayload(vehicleId));

        return result.getFirstElement();
    }
    public int getNumSeats(int vehicleId) throws AxisFault {
        OMElement vehicleElement = getVehicle(vehicleId);
        QName vehicleQName = vehicleElement.getQName();
        QName noOfSeatsQName = new QName("http://model.soap.sample.com/xsd", "noOfSeats", "ax21");
        OMElement noOfSeatsElement = vehicleElement.getFirstChildWithName(noOfSeatsQName);

        return Integer.parseInt(noOfSeatsElement.getText());
    }

    public static void main(String[] args) {
        try {
            DynamicSoapClient client = new DynamicSoapClient();

            int noOfSeats = client.getNumSeats(0);
            System.out.println("Number of seats for vehicle 0: " + noOfSeats);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
