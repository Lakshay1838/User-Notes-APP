package com.example.theOneApp.Services;

import com.example.theOneApp.Entites.Note;
import com.example.theOneApp.Entites.User;
import com.example.theOneApp.Repositories.NoteRepository;
import com.example.theOneApp.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepo;
    @Autowired
    private UserService userService;

//    create note
    public Note create(Note note){
        note.setTime(LocalDateTime.now());
        return noteRepo.save(note);
    }
//    create note for specific user
    public Note createForUser(String email, Note note){
        User user = userService.findByEmail(email);

        if(user != null){
            note.setTime(LocalDateTime.now());
            Note justSaved = noteRepo.save(note);
            List<Note> noteList = user.getNotesList();
            noteList.add(justSaved);
            userService.create(user);
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getNotesList());
            return justSaved;
        }
        return null;
    }
//    get all notes
    public List<Note> getAll(){
        List<Note> list = noteRepo.findAll();
        System.out.println("size of list = " + list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getId() + "-+-" +
                    " " + list.get(i).getTitle() + "- " + list.get(i).getContent() + "- " + list.get(i).getTime());
        }
        return list;
    }

//    get all notes of user
    public List<Note> getAllNoteOfUser(String email){
        User user = userService.findByEmail(email);
        List<Note> noteList = user.getNotesList();
        return noteList;
    }

//    get note by id
    public Note getById(String id){
        Optional<Note> note = noteRepo.findById(new ObjectId(id));
        if(note.isPresent()){
            return note.get();
        }else return new Note();
    }


//    update note
    public Note update(String id,Note note){
        ObjectId newId = new ObjectId(id);
        Note n = noteRepo.findById(newId).get();
        if(n == null){
            return null;
        }
        if(note.getTitle() != null)    n.setTitle(note.getTitle());
        if(note.getContent() != null)  n.setContent(note.getContent());
        n.setTime(LocalDateTime.now());
        return noteRepo.save(n);
    }
//    update note of a user by id
    public Note updateNoteForUser(String email,String NoteId,Note note){
        User user = userService.findByEmail(email);
        if(user != null){
            List<Note> list = user.getNotesList();
            for(Note n:list){
                if(n.getId().equals(new ObjectId(NoteId))){
                    return update(NoteId,note);
                }
            }
        }
        return null;
    }

//    delete note
    public void delete(String id){
        noteRepo.deleteById(new ObjectId(id));
    }

//    delete note of a user
    public void deleteNoteOfAUser(String email,String NoteId){
        User user = userService.findByEmail(email);
        if(user != null){
            user.getNotesList().removeIf(x -> x.getId().equals(new ObjectId(NoteId)));

//            for(Note n:list){
//                if(n.getId() == new ObjectId(NoteId)){
//                    list.remove(n);
//                }
//            }
            noteRepo.deleteById(new ObjectId(NoteId));
            userService.create(user);
        }
    }
}
