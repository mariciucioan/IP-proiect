package com.caramelpanda.driversapp.data;

import androidx.annotation.NonNull;

/**
 * A generic class that holds a result success w/ data or an error exception.
 */
public class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

    @Override
    @NonNull
    public String toString() {
        if (this instanceof Success) {
            Result.Success<?> success = (Result.Success<?>) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error<Exception> error = (Result.Error<Exception>) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    public final static class Success<T> extends Result<T> {
        private T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    // Error sub-class
    public final static class Error<T> extends Result<T> {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }
    }
}