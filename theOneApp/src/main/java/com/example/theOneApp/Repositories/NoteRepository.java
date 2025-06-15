package com.example.theOneApp.Repositories;

import com.example.theOneApp.Entites.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, ObjectId> {

}
