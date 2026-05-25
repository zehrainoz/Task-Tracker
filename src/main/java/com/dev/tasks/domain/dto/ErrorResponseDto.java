package com.dev.tasks.domain.dto;

/**
 * Models the standard error format used by the REST API.
 *
 * @param error The error message.
 */

public record ErrorResponseDto(String error) {
}
