/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

/**
 * Start time:09:26:46 2009-04-22<br>
 * Project: mobicents-isup-stack<br>
 * 
 * @author <a href="mailto:baranowb@gmail.com">Bartosz Baranowski
 *         </a>
 * 
 */
package org.mobicents.protocols.ss7.isup.impl.message;

import org.mobicents.protocols.ss7.isup.message.CircuitGroupUnblockingMessage;
import org.mobicents.protocols.ss7.isup.message.ISUPMessage;
import org.mobicents.protocols.ss7.isup.message.parameter.CallReference;
import org.mobicents.protocols.ss7.isup.message.parameter.RangeAndStatus;

import static org.testng.Assert.*;

import org.testng.*;
import org.testng.annotations.*;
/**
 * Start time:09:26:46 2009-04-22<br>
 * Project: mobicents-isup-stack<br>
 * Test for CGU
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class CGUTest extends MessageHarness {
	

	@Test(groups = { "functional.encode","functional.decode","message"})
	public void testTwo_Params() throws Exception
	{
		byte[] message = getDefaultBody();

		//CircuitGroupUnblockingMessage cgb=new CircuitGroupUnblockingMessageImpl(this,message);
		CircuitGroupUnblockingMessage cgb=super.messageFactory.createCGU(0);
		((AbstractISUPMessage)cgb).decode(message,parameterFactory);

		
		try{
			RangeAndStatus RS = (RangeAndStatus) cgb.getParameter(RangeAndStatus._PARAMETER_CODE);
			assertNotNull(RS,"Range And Status return is null, it should not be");
			if(RS == null)
				return;
			byte range = RS.getRange();
			assertEquals( range,0x11,"Range is wrong");
			byte[] b=RS.getStatus();
			assertNotNull(b,"RangeAndStatus.getRange() is null");
			if(b == null)
			{
				return;
			}	
			assertEquals(b.length,3 ,"Length of param is wrong");
			if(b.length != 3)
				return;
			assertTrue( super.makeCompare(b, new byte[]{
					0x02
					,0x03
					,0x04
					}),"RangeAndStatus.getRange() is wrong");
			
		}catch(Exception e)
		{
			e.printStackTrace();
			fail("Failed on get parameter["+CallReference._PARAMETER_CODE+"]:"+e);
		}
		
	}
	
	protected byte[] getDefaultBody() {
		//FIXME: for now we strip MTP part
		byte[] message={

				0x0C
				,(byte) 0x0B
				,CircuitGroupUnblockingMessage.MESSAGE_CODE
				//Circuit group supervision message type
				,0x01 // hardware failure oriented
				,0x01 // ptr to variable part
				//no optional, so no pointer
				//RangeAndStatus._PARAMETER_CODE
				,0x04
				,0x11
				,0x02
				,0x03
				,0x04

		};
		return message;
	}

	
	protected ISUPMessage getDefaultMessage() {
		return super.messageFactory.createCGU(0);
	}
}