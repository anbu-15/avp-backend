package com.avp.management.enums;


public enum PayslipStatus {
    /** The payslip has been calculated but is not yet visible to the employee. */
    DRAFT,

    /** The payslip is finalized and can be viewed/downloaded by the employee. */
    GENERATED,

    /** The funds have been transferred and the salary is marked as paid. */
    PAID,

    /** Something was wrong with the calculation and it has been invalidated. */
    VOID
}