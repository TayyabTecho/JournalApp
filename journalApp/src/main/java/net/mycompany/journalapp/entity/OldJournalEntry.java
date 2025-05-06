package net.mycompany.journalapp.entity;

import lombok.Data;

@Data
public class OldJournalEntry {
    private String title;
    private String content;
    private long id;
}
