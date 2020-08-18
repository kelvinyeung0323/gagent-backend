package com.kelvin.goodsagent.common.exception;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/16 11:22
 * @description:
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
