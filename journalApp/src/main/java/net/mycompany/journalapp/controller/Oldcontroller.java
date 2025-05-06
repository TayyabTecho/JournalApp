package net.mycompany.journalapp.controller;


import net.mycompany.journalapp.entity.OldJournalEntry;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/OC")
@RestController
public class Oldcontroller {

    private Map<Long, OldJournalEntry> entries = new HashMap<>();

    @PostMapping("/p")
    public String cr1(@RequestBody OldJournalEntry journalEntry1) {
        entries.put(journalEntry1.getId(), journalEntry1);
        return "entry created";
    }

    @GetMapping
    public List<OldJournalEntry> getAll() {
        return new ArrayList<>(entries.values());
    }

    @GetMapping("/g/{id}")
    public OldJournalEntry getById(@PathVariable long id) {
        return entries.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        entries.remove(id);
    }

    @PutMapping("/{id}")
    public OldJournalEntry update(@PathVariable long id, @RequestBody OldJournalEntry myJournalEntry) {
        OldJournalEntry myJournalEntry1 = entries.get(id);
        myJournalEntry1.setContent(myJournalEntry.getContent());
        myJournalEntry1.setTitle(myJournalEntry.getTitle());
        return myJournalEntry1;
    }

    @PutMapping("/{id1}")
    public OldJournalEntry updatte1(@PathVariable long id1, @RequestBody OldJournalEntry myJournalEntry) {
        return entries.put(id1, myJournalEntry);
    }
}
