package org.bardframework.demo.productos.service;

import java.util.List;

/**
 * Repository interface for managing service-related data operations.
 * Provides methods to interact with the underlying data source for services.
 */
public interface ServiceRepository {

    /**
     * Finds a service by its unique identifier.
     *
     * @param id the unique identifier of the service
     * @return the service object if found, otherwise null
     */