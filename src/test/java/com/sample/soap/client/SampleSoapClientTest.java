/*
 * (c) Copyright 2021 SailPoint Technologies, Inc., All Rights Reserved.
 */

package com.sample.soap.client;

import org.junit.Assert;
import org.junit.Test;

public class SampleSoapClientTest {

    @Test
    public void testGetDefaultVehicle() {
        SampleSoapClient client = new SampleSoapClient();
        Assert.assertEquals(4, client.getNumSeats(0));
    }

}
