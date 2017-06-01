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

package org.mobicents.protocols.ss7.sccp.message;

import org.mobicents.protocols.ss7.sccp.parameter.Credit;
import org.mobicents.protocols.ss7.sccp.parameter.ErrorCause;
import org.mobicents.protocols.ss7.sccp.parameter.HopCounter;
import org.mobicents.protocols.ss7.sccp.parameter.Importance;
import org.mobicents.protocols.ss7.sccp.parameter.LocalReference;
import org.mobicents.protocols.ss7.sccp.parameter.ProtocolClass;
import org.mobicents.protocols.ss7.sccp.parameter.ReceiveSequenceNumber;
import org.mobicents.protocols.ss7.sccp.parameter.RefusalCause;
import org.mobicents.protocols.ss7.sccp.parameter.ReleaseCause;
import org.mobicents.protocols.ss7.sccp.parameter.ResetCause;
import org.mobicents.protocols.ss7.sccp.parameter.ReturnCause;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import org.mobicents.protocols.ss7.sccp.parameter.Segmentation;
import org.mobicents.protocols.ss7.sccp.parameter.SegmentingReassembling;
import org.mobicents.protocols.ss7.sccp.parameter.SequencingSegmenting;

public interface SccpConnMessage extends SccpMessage {
    LocalReference getDestinationLocalReferenceNumber();
    void setDestinationLocalReferenceNumber(LocalReference number);

    LocalReference getSourceLocalReferenceNumber();
    void setSourceLocalReferenceNumber(LocalReference number);

    SccpAddress getCalledPartyAddress();
    void setCalledPartyAddress(SccpAddress address);

    SccpAddress getCallingPartyAddress();
    void setCallingPartyAddress(SccpAddress address);

    ProtocolClass getProtocolClass();
    void setProtocolClass(ProtocolClass value);

    SegmentingReassembling getSegmentingReassembling();
    void setSegmentingReassembling(SegmentingReassembling value);

    ReceiveSequenceNumber getReceiveSequenceNumber();
    void setReceiveSequenceNumber(ReceiveSequenceNumber value);

    SequencingSegmenting getSequencingSegmenting();
    void setSequencingSegmenting(SequencingSegmenting value);

    Credit getCredit();
    void setCredit(Credit value);

    ReleaseCause getReleaseCause();
    void setReleaseCause(ReleaseCause value);

    ReturnCause getReturnCause();
    void setReturnCause(ReturnCause value);

    ResetCause getResetCause();
    void setResetCause(ResetCause value);

    ErrorCause getErrorCause();
    void setErrorCause(ErrorCause value);

    byte[] getUserData();
    void setUserData(byte[] data);

    RefusalCause getRefusalCause();
    void setRefusalCause(RefusalCause value);

    HopCounter getHopCounter();
    void setHopCounter(HopCounter counter);

    Segmentation getSegmentation();
    void setSegmentation(Segmentation segmentation);

    Importance getImportance();
    void setImportance(Importance importance);
}