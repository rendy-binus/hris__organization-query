package com.rendyezaputra.hris.organizationquery.api.constant;

public enum TeamSortField {
    NAME("name"),
    CREATED_DATE("createdDate"),
    UPDATED_DATE("updatedDate"),
    ;

    private final String field;

    TeamSortField(String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }
}
