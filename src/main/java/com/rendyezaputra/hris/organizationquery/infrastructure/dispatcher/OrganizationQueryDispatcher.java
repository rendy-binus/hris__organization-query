package com.rendyezaputra.hris.organizationquery.infrastructure.dispatcher;

import com.rendyezaputra.hris.hriswebresources.cqrs.handler.QueryHandlerMethod;
import com.rendyezaputra.hris.hriswebresources.cqrs.query.BaseQuery;
import com.rendyezaputra.hris.hriswebresources.cqrs.query.QueryDispatcher;
import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class OrganizationQueryDispatcher implements QueryDispatcher {
    private final Map<Class<? extends BaseQuery>, List<QueryHandlerMethod>> routes = new HashMap<>();

    @Override
    public <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler) {
        List<QueryHandlerMethod> handlers = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public <U extends BaseEntity> Page<U> send(BaseQuery query) {
        List<QueryHandlerMethod> handlers = routes.get(query.getClass());

        if (handlers == null || handlers.size() < 1) {
            throw new RuntimeException("No query handler is registered");
        }

        if (handlers.size() > 1) {
            throw new RuntimeException("Cannot send query to more than one handler");
        }

        return handlers.get(0).handle(query);
    }
}
