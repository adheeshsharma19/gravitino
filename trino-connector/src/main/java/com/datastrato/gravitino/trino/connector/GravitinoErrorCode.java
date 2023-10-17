/*
 * Copyright 2023 Datastrato.
 * This software is licensed under the Apache License version 2.
 */
package com.datastrato.gravitino.trino.connector;

import static io.trino.spi.ErrorType.EXTERNAL;

import io.trino.spi.ErrorCode;
import io.trino.spi.ErrorCodeSupplier;
import io.trino.spi.ErrorType;

public enum GravitinoErrorCode implements ErrorCodeSupplier {
  GRAVITINO_UNSUPPORTED_TRINO_VERSION(0, EXTERNAL),
  GRAVITINO_METALAKE_NOT_EXISTS(1, EXTERNAL),
  GRAVITINO_MISSING_CONFIG(2, EXTERNAL),
  GRAVITINO_CREATE_INNER_CONNECTOR_FAILED(3, EXTERNAL),
  GRAVITINO_UNSUPPORTED_CATALOG_PROVIDER(4, EXTERNAL),
  GRAVITINO_CREATE_INTERNAL_CONNECTOR_ERROR(5, EXTERNAL),
  GRAVITINO_SCHEMA_NOT_EXISTS(6, EXTERNAL),
  GRAVITINO_CATALOG_NOT_EXISTS(7, EXTERNAL),
  GRAVITINO_TABLE_NOT_EXISTS(8, EXTERNAL),
  GRAVITINO_UNSUPPORTED_TRINO_DATATYPE(9, EXTERNAL),
  GRAVITINO_UNSUPPORTED_GRAVITINO_DATATYPE(10, EXTERNAL),
  GRAVITINO_UNSUPPORTED_OPERATION(11, EXTERNAL),
  GRAVITINO_COLUMN_NOT_EXISTS(12, EXTERNAL),
  GRAVITINO_SCHEMA_ALREADY_EXISTS(13, EXTERNAL),
  GRAVITINO_TABLE_ALREADY_EXISTS(14, EXTERNAL),
  GRAVITINO_SCHEMA_NOT_EMPTY(15, EXTERNAL),
  ;

  private final ErrorCode errorCode;

  GravitinoErrorCode(int code, ErrorType type) {
    errorCode = new ErrorCode(code + 0x0200_0000, name(), type);
  }

  @Override
  public ErrorCode toErrorCode() {
    return errorCode;
  }
}
