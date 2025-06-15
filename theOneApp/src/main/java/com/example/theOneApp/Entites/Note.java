package com.example.theOneApp.Entites;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

//@Getter
//@Setter
@Component
@Document(collection = "notes")
public class Note {

    @Id
    private ObjectId id;
    @NonNull
    private String Title;
    @NonNull
    private String Content;
    private LocalDateTime time;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public @NonNull String getTitle() {
        return Title;
    }

    public void setTitle(@NonNull String title) {
        Title = title;
    }

    public @NonNull String getContent() {
        return Content;
    }

    public void setContent(@NonNull String content) {
        Content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
