package com.global.book.datajpabooksproject.error;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException() {
    }

    public DuplicateRecordException(String message) {
        super(message);
    }
}
