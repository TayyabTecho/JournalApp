package net.mycompany.journalapp.controller;

import net.mycompany.journalapp.entity.JournalEntry;
import net.mycompany.journalapp.entity.User;
import net.mycompany.journalapp.service.JournalEntryService;
import net.mycompany.journalapp.service.JournalEntryServiceNew;
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
import java.util.Optional;

@RestController
@RequestMapping("/RC")
public class Response {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private JournalEntryServiceNew journalEntryServiceNew;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createJournalEntry(@RequestBody JournalEntry journalEntry) {
        JournalEntry newJournalEntry = journalEntryService.createNew(journalEntry);
        return new ResponseEntity<>(newJournalEntry, HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntriesOfUser(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all != null) {
            return new ResponseEntity<>(all, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable Long myId) {
        Optional<JournalEntry> entry = journalEntryService.getById(myId);
        if (entry.isPresent()) {
            return new ResponseEntity<>(entry.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userName}")
    public ResponseEntity<JournalEntry> createJournalEntryOfUser(@RequestBody JournalEntry myEntry, @PathVariable String userName) {
        try {
            journalEntryServiceNew.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        journalEntryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("id/{userName}/{id}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable Long id, @PathVariable String userName) {
        journalEntryServiceNew.deleteById(id, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.getById(id).orElse(null);
        if (old != null) {
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
            old.setTitle(newEntry.getTitle() != null && !newEntry.equals("") ? newEntry.getTitle() : old.getTitle());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //ISME DOUBT HAI
    @PutMapping("id/{userName}/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody JournalEntry newEntry, @PathVariable String userName) {
        JournalEntry old = journalEntryServiceNew.getById(id).orElse(null);
        if (old != null) {
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
            old.setTitle(newEntry.getTitle() != null && !newEntry.equals("") ? newEntry.getTitle() : old.getTitle());
            journalEntryServiceNew.saveEntry(old, userName);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}