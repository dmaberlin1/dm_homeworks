package com.dmadev.java.part15;

import java.time.LocalDateTime;


    class CallRecord {
        private int complaintId;
        private LocalDateTime callDateTime;
        private String formattedPhone;

        public CallRecord(int complaintId, LocalDateTime callDateTime, String formattedPhone) {
            this.complaintId = complaintId;
            this.callDateTime = callDateTime;
            this.formattedPhone = formattedPhone;
        }

        public int getComplaintId() {
            return complaintId;
        }

        public LocalDateTime getCallDateTime() {
            return callDateTime;
        }

        public String getFormattedPhone() {
            return formattedPhone;
        }
    }
