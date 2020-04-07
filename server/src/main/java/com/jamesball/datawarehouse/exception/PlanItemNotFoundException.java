package com.jamesball.datawarehouse.exception;

import com.jamesball.datawarehouse.entity.PlanItemId;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanItemNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public PlanItemNotFoundException(String message, PlanItemId invalidPlanItemId) {
        super(message);
        extensions.put("invalidPlanItemId", invalidPlanItemId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
