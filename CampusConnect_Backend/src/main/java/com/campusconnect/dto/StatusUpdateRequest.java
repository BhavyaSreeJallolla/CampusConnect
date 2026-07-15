package com.campusconnect.dto;

import com.campusconnect.enums.VerificationStatus;

public class StatusUpdateRequest {

    private VerificationStatus status;

    public StatusUpdateRequest() {
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }
}