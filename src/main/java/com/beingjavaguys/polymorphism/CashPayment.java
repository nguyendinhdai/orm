/*
 * FILENAME
 *     CashPayment.java
 *
 * FILE LOCATION
 *     $Source$
 *
 * VERSION
 *     $Id$
 *         @version       $Revision$
 *         Check-Out Tag: $Name$
 *         Locked By:     $Lockers$
 *
 * FORMATTING NOTES
 *     * Lines should be limited to 78 characters.
 *     * Files should contain no tabs.
 *     * Indent code using four-character increments.
 *
 * COPYRIGHT
 *     Copyright (C) 2007 Genix Ventures Pty. Ltd. All rights reserved.
 *     This software is the confidential and proprietary information of
 *     Genix Ventures ("Confidential Information"). You shall not
 *     disclose such Confidential Information and shall use it only in
 *     accordance with the terms of the license agreement you entered into
 *     with Genix Ventures.
 */

package com.beingjavaguys.polymorphism;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class CashPayment implements Payment
{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long paymentId;
    private Long paymentAmount;
    private String paymentCurrency;
    private String payerName;

    public CashPayment()
    {
    }

    public CashPayment(final Long paymentAmount, final String paymentCurrency, final String payerName)
    {
        this.paymentAmount = paymentAmount;
        this.paymentCurrency = paymentCurrency;
        this.payerName = payerName;
    }

    public Long getPaymentId()
    {
        return paymentId;
    }

    public void setPaymentId(Long paymentId)
    {
        this.paymentId = paymentId;
    }

    public Long getPaymentAmount()
    {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount)
    {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentCurrency()
    {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency)
    {
        this.paymentCurrency = paymentCurrency;
    }

    public String getPayerName()
    {
        return payerName;
    }

    public void setPayerName(String payerName)
    {
        this.payerName = payerName;
    }

    @Override
    public String toString()
    {
        ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
        toStringBuilder.append("paymentId", paymentId);
        toStringBuilder.append("paymentAmount", paymentAmount);
        toStringBuilder.append("paymentCurrency", paymentCurrency);
        toStringBuilder.append("payerName", payerName);
        return toStringBuilder.toString();
    }
}
