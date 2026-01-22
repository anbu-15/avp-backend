package com.avp.management.enums;

public enum EmployeeStatus {
    /** Employee is currently working. */
    ACTIVE,

    /** Employee is no longer with the company. */
    INACTIVE,

    /** Employee has resigned and is serving their notice period. */
    ON_NOTICE,

    /** Employee is on a long-term sabbatical or maternity/paternity leave. */
    ON_LEAVE
}