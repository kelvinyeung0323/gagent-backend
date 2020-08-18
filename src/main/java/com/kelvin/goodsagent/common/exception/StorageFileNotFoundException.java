package com.kelvin.goodsagent.common.exception;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/16 11:23
 * @description:
 */
public class StorageFileNotFoundException extends RuntimeException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
