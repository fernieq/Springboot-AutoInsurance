package com.synergisticit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.domain.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
