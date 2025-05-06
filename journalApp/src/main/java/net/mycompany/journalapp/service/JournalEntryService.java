package net.mycompany.journalapp.service;

import net.mycompany.journalapp.entity.JournalEntry;
import net.mycompany.journalapp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry) {
//        User user = userService.findByUsername(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        //user.getJournalEntries().add(saved);
    }

    public JournalEntry createNew(JournalEntry journalEntry) {
        JournalEntry journalEntryNew = new JournalEntry();
        journalEntryNew.setTitle(journalEntry.getTitle());
        journalEntryNew.setContent(journalEntry.getContent());
        journalEntryNew.setDate(LocalDateTime.now());
        JournalEntry save = journalEntryRepository.save(journalEntryNew);
        return save;
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(Long myId) {
        return journalEntryRepository.findById(myId);
    }

    public void deleteById(Long id) {
        journalEntryRepository.deleteById(id);
    }
}
