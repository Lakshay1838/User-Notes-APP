package com.example.theOneApp.Controllers;

import com.example.theOneApp.Entites.Note;
import com.example.theOneApp.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/noteController")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
//    public List<Note> getAll(){
//        return noteService.getAll();
//    }
//     --NOTE - use {id} in path and @PathVariable String id in parameter then convert to ObjectId(); {{{{RULE}}}}
//    @GetMapping("/{id}")
//    public Note getById(@PathVariable String id){
//        return noteService.getById(id);
//    }

//    @PostMapping
//    public Note create(@RequestBody Note note){
//        return noteService.create(note);
//    }
    @PostMapping("/{email}")
    public Note createNoteForUser(@PathVariable String email,@RequestBody Note note){
        return noteService.createForUser(email,note);
    }

//    @PutMapping("/{id}")
//    public Note update(@PathVariable String id,@RequestBody Note note){
//        return noteService.update(id,note);
//    }
    @PutMapping("/{email}/{id}")
    public Note updateForUser(@PathVariable String email,@PathVariable String id,@RequestBody Note note){
        return noteService.updateNoteForUser(email,id,note);
    }
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable String id){
//        noteService.delete(id);
//    }
    @DeleteMapping("{email}/{id}")
    public void deleteForUSer(@PathVariable String email,@PathVariable String id){
        noteService.deleteNoteOfAUser(email,id);
    }
}
