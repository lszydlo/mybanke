package com.bottega.qdocref.gateway;


import com.bottega.qdocref.services.editor.QDocContent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "/content")
public interface QDocContentResource extends PagingAndSortingRepository<QDocContent, UUID> {
}
