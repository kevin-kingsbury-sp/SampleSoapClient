/**
 * VehicleServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.8  Built on : May 19, 2018 (07:06:11 BST)
 */
package com.sample.stub;


/**
 *  VehicleServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class VehicleServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public VehicleServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public VehicleServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getVehicle method
     * override this method for handling normal response from getVehicle operation
     */
    public void receiveResultgetVehicle(
        com.sample.stub.VehicleServiceStub.GetVehicleResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getVehicle operation
     */
    public void receiveErrorgetVehicle(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addVehicle method
     * override this method for handling normal response from addVehicle operation
     */
    public void receiveResultaddVehicle(
        com.sample.stub.VehicleServiceStub.AddVehicleResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addVehicle operation
     */
    public void receiveErroraddVehicle(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for removeVehicle method
     * override this method for handling normal response from removeVehicle operation
     */
    public void receiveResultremoveVehicle(
        com.sample.stub.VehicleServiceStub.RemoveVehicleResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from removeVehicle operation
     */
    public void receiveErrorremoveVehicle(java.lang.Exception e) {
    }
}
