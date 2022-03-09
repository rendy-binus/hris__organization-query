package com.rendyezaputra.hris.organizationquery.api.constant;

public enum JobFunctionSortField {
    NAME("name"),
    LEVEL("level"),
    CREATED_DATE("createdDate"),
    UPDATED_DATE("updatedDate"),
    ;

    private final String field;

    JobFunctionSortField(String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }
}
