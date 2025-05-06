package net.mycompany.journalapp.controller;

import net.mycompany.journalapp.entity.JournalEntry;
import net.mycompany.journalapp.entity.User;
import net.mycompany.journalapp.service.JournalEntryService;
import net.mycompany.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalEntryService.getById(myId).orElse(null);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllJournalEntryOfUser(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all != null & !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @DeleteMapping("id/{id}")
    public boolean deleteById(@PathVariable Long id) {
        journalEntryService.deleteById(id);
        return true;
    }

    //ObjectId dataype offers by MongoDB
    @PutMapping("id/{id}")
    public JournalEntry updateById(@PathVariable Long id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.getById(id).orElse(null);
        if (old != null) {
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
            old.setTitle(newEntry.getTitle() != null && !newEntry.equals("") ? newEntry.getTitle() : old.getTitle());}
        journalEntryService.saveEntry(old);
        return old;
    }
}

