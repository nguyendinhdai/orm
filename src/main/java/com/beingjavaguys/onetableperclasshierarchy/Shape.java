/*
 * FILENAME
 *     Shape.java
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

package com.beingjavaguys.onetableperclasshierarchy;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 @Inheritance:
 For implementing inheritance in hiberante,@Inheritance annotation is used.
 It defines inheritance strategy to be implement for entity class hierarchy.
 For one table per class hierarhcy,we have used Single_Table as inheritance strategy.
 This annotation is defined at root level or sub hierarchy level where different strategy is to be applied.
 Read more at http://javapostsforlearning.blogspot.com/2013/02/hibernate-inheritancetable-per-class.html#T88vYJ1PtA9cOwmr.99

 @DiscriminatorColumn:
 This annotation is used to define discriminator column for Single_Table and joined strategy.
 It is used to distinguish between different class instances.
 This annotation is defined at root level or sub hierarchy level where different strategy is to be applied.
 If @DiscriminatorColumn annotation is not specified,then hibernate will create a column named as "DType" and DiscriminatorType will be string.

 @DiscriminatorValue:
 This annotation defines value in discriminator column for that class.
 This can only be applied on entity concrete class.
 For example,If entry will be of shape instance in SHAPE table then "s" will be value for that row in discriminator column.
 If this annotation is not specified and Discriminator column is used then provider specific values will be provided and 
 if Discriminator type is String then discriminator value will be entity name.Discriminator value,
 if not defaulted need to specified on each enitity in hierarchy.
 */

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name = "SHAPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "S")
public class Shape
{

    @Id
    @GeneratedValue
    @Column(name = "Shape_Id")
    int shapeId;
    @Column(name = "Shape_Name")
    String shapeName;

    public Shape()
    {

    }

    public Shape(String shapeName)
    {
        this.shapeName = shapeName;
    }
    //getters and setters

}
