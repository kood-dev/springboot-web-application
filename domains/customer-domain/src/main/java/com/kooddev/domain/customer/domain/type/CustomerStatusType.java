package com.kooddev.domain.customer.domain.type;

import lombok.Getter;

/**
 * @author gwkoo
 */
@Getter
public enum CustomerStatusType {
    Normal("normal", "정상"),
    Dormancy("dormancy", "휴면"),
    Leave("leave", "탈퇴");

    private final String type;
    private final String description;

    CustomerStatusType(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
