package org.despagnehugo.api;

public class DropWizardExpediaException extends Exception {
    private final int code;
    public DropWizardExpediaException() {
        this(500);
    }
    public DropWizardExpediaException(int code) {
        this(code, "Error while processing the request", null);
    }
    public DropWizardExpediaException(int code, String message) {
        this(code, message, null);
    }
    public DropWizardExpediaException(int code, String message, Exception exception) {
        super(message, exception);
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}

