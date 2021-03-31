/*
 * (c) Copyright 2021 SailPoint Technologies, Inc., All Rights Reserved.
 */

package com.sample.soap.client;

import org.apache.axis2.AxisFault;
import org.junit.Assert;
import org.junit.Test;

public class DynamicSoapClientTest {

    @Test
    public void testGetDefaultVehicle() throws AxisFault {
        DynamicSoapClient client = new DynamicSoapClient();
        Assert.assertEquals(4, client.getNumSeats(0));
    }

}
