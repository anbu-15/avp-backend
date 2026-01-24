package com.avp.management.enums;

public enum RequestStatus {
    /** The request has been submitted but not yet reviewed by a manager. */
    PENDING,

    /** The request has been authorized by the manager or HR. */
    APPROVED,

    /** The request was declined. Usually, a reason should be provided. */
    REJECTED,

    /** The employee has withdrawn the request before it was processed. */
    CANCELLED
}