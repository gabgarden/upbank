package com.upbank.dtos;

import java.math.BigDecimal;

public record DepositDTO(BigDecimal value, Long accountHolderId) {
}
